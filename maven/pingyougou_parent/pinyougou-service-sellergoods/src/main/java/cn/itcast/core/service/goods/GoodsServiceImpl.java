package cn.itcast.core.service.goods;

import cn.itcast.core.entity.PageResult;
import cn.itcast.core.pojo.good.Goods;
import cn.itcast.core.pojo.good.GoodsDesc;
import cn.itcast.core.pojo.good.GoodsQuery;
import cn.itcast.core.pojo.item.Item;
import cn.itcast.core.pojo.item.ItemQuery;
import cn.itcast.core.dao.good.BrandDao;
import cn.itcast.core.dao.good.GoodsDao;
import cn.itcast.core.dao.good.GoodsDescDao;
import cn.itcast.core.dao.item.ItemCatDao;
import cn.itcast.core.dao.item.ItemDao;
import cn.itcast.core.dao.seller.SellerDao;
import cn.itcast.core.service.goods.GoodsService;
import cn.itcast.core.vo.GoodsVo;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.jms.*;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsDescDao goodsDescDao;
    @Resource
    private GoodsDao goodsDao;
    @Resource
    private ItemDao itemDao;
    @Resource
    private ItemCatDao itemCatDao;
    @Resource
    private SellerDao sellerDao;
    @Resource
    private BrandDao brandDao;
    @Resource
    private SolrTemplate solrTemplate;
    @Resource
     private JmsTemplate jmsTemplate;
    @Resource
    private Destination topicPageAndSolrDestination;
    @Resource
    private Destination queueSolrDeleteDestination;

    /**
     * 新增
     *
     * @param goodsVo
     */
    @Transactional
    @Override
    public void add(GoodsVo goodsVo) {
        //新增商品
        Goods goods = goodsVo.getGoods();
        goods.setAuditStatus("0");  // 商品待审核的状态
        goodsDao.insertSelective(goods);//设置返回自增主键
        //新增商品明细
        GoodsDesc goodsDesc = goodsVo.getGoodsDesc();
        goodsDesc.setGoodsId(goods.getId());
        goodsDescDao.insertSelective(goodsDesc);
        //新增商品对应的库存信息
        // 是否启用规格
        if ("1".equals(goods.getIsEnableSpec())) {
            // 启用规格：一个spu对应多个sku
            List<Item> itemList = goodsVo.getItemList();
            if (itemList != null && itemList.size() > 0) {
                for (Item item : itemList) {
                    // 商品的标题：spu的名称+spu副标题+规格名称
                    // 例子：小米8SE 游戏机 16G  联通3G
                    String title = goods.getGoodsName() + " " + goods.getCaption();
                    // 查询数据：打断点  查看数据库中的测试数据
                    // 举个例子：spec: {"机身内存":"16G","网络":"联通3G"}
                    String spec = item.getSpec();
                    Map<String, String> specMap = JSON.parseObject(spec, Map.class);
                    Set<Map.Entry<String, String>> entries = specMap.entrySet();
                    for (Map.Entry<String, String> entry : entries) {
                        title += " " + entry.getValue();
                    }
                    item.setTitle(title);
                    setItemAttribute(goods, goodsDesc, item);
                    // 保存
                    itemDao.insertSelective(item);
                }
            }
        } else {
            // 不启用规格：一个spu对应一个sku
            Item item = new Item();
            item.setTitle(goods.getGoodsName() + " " + goods.getCaption()); // 标题
            item.setPrice(goods.getPrice());    // 商品价格
            item.setStatus("1");    // 是否启用该商品
            item.setNum(9999);      // 库存量
            item.setIsDefault("1"); // 是否默认
            item.setSpec("{}");
            setItemAttribute(goods, goodsDesc, item);
            itemDao.insertSelective(item);
        }
    }

    /**
     * 商家系统下的商品列表查询
     * @param page
     * @param rows
     * @param goods
     * @return
     */
    @Override
    public PageResult searchForShop(Integer page, Integer rows, Goods goods) {
        // 分页条件
        PageHelper.startPage(page, rows);
        // 查询条件：当前商家id
        GoodsQuery goodsQuery = new GoodsQuery();
        goodsQuery.createCriteria().andSellerIdEqualTo(goods.getSellerId());
        // 根据条件查询
        Page<Goods> p = (Page<Goods>) goodsDao.selectByExample(goodsQuery);
        return new PageResult(p.getResult(), p.getTotal());
    }

    /**
     * 商品修改数据回显
     * @param id
     * @return
     */
    @Override
    public GoodsVo findOne(Long id) {
        GoodsVo goodsVo = new GoodsVo();
        //商品信息
        Goods goods = goodsDao.selectByPrimaryKey(id);
        goodsVo.setGoods(goods);
        //商品明细信息
        GoodsDesc goodsDesc = goodsDescDao.selectByPrimaryKey(id);
        goodsVo.setGoodsDesc(goodsDesc);
        //商品库存信息
        ItemQuery itemQuery = new ItemQuery();
        itemQuery.createCriteria().andGoodsIdEqualTo(id);
        List<Item> itemList = itemDao.selectByExample(itemQuery);
        goodsVo.setItemList(itemList);
        return goodsVo;
    }

    /**
     * 商品修改
     * @param goodsVo
     */
    @Transactional
    @Override
    public void update(GoodsVo goodsVo) {
     //修改商品
        Goods goods = goodsVo.getGoods();
        goodsDao.updateByPrimaryKeySelective(goods);
        //修改商品明细
        GoodsDesc goodsDesc = goodsVo.getGoodsDesc();
        goodsDescDao.updateByPrimaryKeySelective(goodsDesc);
        //修改库存
        //先删除再修改
        //删除
        ItemQuery itemQuery = new ItemQuery();
        itemQuery.createCriteria().andGoodsIdEqualTo(goods.getId());
        itemDao.deleteByExample(itemQuery);
        //再修改
        if ("1".equals(goods.getIsEnableSpec())) {//启用规格
            List<Item> itemList = goodsVo.getItemList();
            if (itemList!=null && itemList.size()>0) {
                for (Item item : itemList) {
                    String title = goods.getGoodsName()+" "+goods.getCaption();
                    String spec = item.getSpec();
                    Map<String,String> specMap = JSON.parseObject(spec, Map.class);
                    Set<Map.Entry<String, String>> entries = specMap.entrySet();
                    for (Map.Entry<String, String> entry : entries) {
                        title += " "+entry.getValue();
                    }
                    item.setTitle(title);
                    setItemAttribute(goods,goodsDesc,item);
                    //保存
                    itemDao.insertSelective(item);
                }

            }

        }else{
            // 不启用规格：一个spu对应一个sku
            Item item = new Item();
            item.setTitle(goods.getGoodsName() + " " + goods.getCaption()); // 标题
            item.setPrice(goods.getPrice());    // 商品价格
            item.setStatus("1");    // 是否启用该商品
            item.setNum(9999);      // 库存量
            item.setIsDefault("1"); // 是否默认
            item.setSpec("{}");
            setItemAttribute(goods, goodsDesc, item);
            itemDao.insertSelective(item);
        }

    }

    /**
     * 运营商查询商品列表信息
     * @param page
     * @param rows
     * @param goods
     * @return
     */
    @Override
    public PageResult searchByManager(Integer page, Integer rows, Goods goods) {
        //设置分页条件
        PageHelper.startPage(page,rows);
        //设置查询条件
        GoodsQuery goodsQuery = new GoodsQuery();
        GoodsQuery.Criteria criteria = goodsQuery.createCriteria();
        goodsQuery.setOrderByClause("id desc");//降序
        if (goods.getAuditStatus()!=null && !"".equals(goods.getAuditStatus().trim())) {
            criteria.andAuditStatusEqualTo(goods.getAuditStatus().trim());
        }
        //未删除的商品
        criteria.andIsDeleteIsNull();
        //根据条件查询
        Page<Goods> p = (Page<Goods>) goodsDao.selectByExample(goodsQuery);
        //返回结果
        return new PageResult(p.getResult(),p.getTotal());

    }
    /**
     *
     * @Title: updateStatus
     * @Description: 商品审核
     * @param ids
     * @param status
     * @return void
     * @throws
     */
    @Transactional
    @Override
    public void updateStatus(Long[] ids, String status) {
        if(ids != null && ids.length > 0){
            Goods goods = new Goods();
            goods.setAuditStatus(status);
            for (final Long id : ids) {
                goods.setId(id);
                goodsDao.updateByPrimaryKeySelective(goods);
                if("1".equals(status)){ // 审核成功
                    // 2、将商品进行上架
                    // 说明：今天将所有的库存信息保存到索引库中(目的：为了索引库中有很多的数据，可以搜索操作)
//                    dataImportToSolrForItem();
                    // 正真的实现：将审核通过后的商品对应的库存保存到索引库中
                   // updateItemToSolr(id);
                    // 生成商品详情的静态页
                    //将商品id发送到mq中
                    jmsTemplate.send(topicPageAndSolrDestination, new MessageCreator() {
                        @Override
                        public Message createMessage(Session session) throws JMSException {
                            // 将商品的id封装成消息进行发送
                            TextMessage textMessage = session.createTextMessage(String.valueOf(id));
                            return textMessage;
                        }
                    });

                }
            }
        }
    }

    // 将商品对应的库存信息保存到索引库中
    private void updateItemToSolr(Long id) {
        // 查询该商品对应的库存信息
        ItemQuery itemQuery = new ItemQuery();
        itemQuery.createCriteria().andGoodsIdEqualTo(id).andIsDefaultEqualTo("1").andStatusEqualTo("1");
        List<Item> items = itemDao.selectByExample(itemQuery);
        if(items != null && items.size() > 0){
            // 处理动态字段
            for (Item item : items) {
                // 栗子：{"机身内存":"16G","网络":"联通3G"}
                String spec = item.getSpec();
                // 拼接的动态字段：item_spec_机身内存 、 item_spec_网络
                Map<String, String> specMap = JSON.parseObject(spec, Map.class);
                item.setSpecMap(specMap);
            }
            solrTemplate.saveBeans(items);
            solrTemplate.commit();
        }
    }
    /**
     *
     * @Title: delete
     * @Description: 删除商品
     * @param ids
     * @return void
     * @throws
     */
    @Transactional
    @Override
    public void delete(Long[] ids) {
        if(ids != null && ids.length > 0){
            Goods goods = new Goods();
            goods.setIsDelete("1");
            for (final Long id : ids) {
                goods.setId(id);
                goodsDao.updateByPrimaryKeySelective(goods);
                //将商品id发送到Mq中
                jmsTemplate.send(queueSolrDeleteDestination, new MessageCreator() {
                    @Override
                    public Message createMessage(Session session) throws JMSException {
                       //将商品的id封装成消息进行发送
                        TextMessage textMessage = session.createTextMessage(String.valueOf(id));
                        return textMessage;
                    }
                });
                // 删除商品详情的静态页（在本项目中不删除）
            }
        }
    }

    /**
     * 将全部库存的信息保存到索引库中
     */
    private void dataImportToSolrForItem() {
        //设置查询条件
        ItemQuery itemQuery = new ItemQuery();
        itemQuery.createCriteria().andStatusEqualTo("1");//将正常的库存信息保存到索引库中
        //查询数据
        List<Item> items = itemDao.selectByExample(itemQuery);
        //判断数据  处理动态字段
        if (items != null && items.size() > 0) {
            for (Item item : items) {
                // 栗子：{"机身内存":"16G","网络":"联通3G"}
                String spec = item.getSpec();
                // 拼接的动态字段：item_spec_机身内存 、 item_spec_网络
                Map<String ,String > specMap = JSON.parseObject(spec, Map.class);
                item.setSpecMap(specMap);
            }
            solrTemplate.saveBeans(items);
            solrTemplate.commit();
        }

    }


    // 设置item的公共的属性
    private void setItemAttribute(Goods goods, GoodsDesc goodsDesc, Item item) {
        // 商品图片
        // 例子：
        // [{"color":"粉色","url":"http://192.168.25.133/group1/M00/00/00/wKgZhVmOXq2AFIs5AAgawLS1G5Y004.jpg"},
        // {"color":"黑色","url":"http://192.168.25.133/group1/M00/00/00/wKgZhVmOXrWAcIsOAAETwD7A1Is874.jpg"}]
        String itemImages = goodsDesc.getItemImages();
        List<Map> images = JSON.parseArray(itemImages, Map.class);
        if(images != null && images.size() > 0){
            String image = images.get(0).get("url").toString();
            item.setImage(image);
        }
        // 商品三级分类id
        item.setCategoryid(goods.getCategory3Id());
        item.setCreateTime(new Date());
        item.setUpdateTime(new Date());
        item.setGoodsId(goods.getId()); // 商品id
        item.setSellerId(goods.getSellerId());  // 商家id
        item.setCategory(itemCatDao.selectByPrimaryKey(goods.getCategory3Id()).getName()); // 分类名称
        item.setBrand(brandDao.selectByPrimaryKey(goods.getBrandId()).getName());    // 品牌名称
        item.setSeller(sellerDao.selectByPrimaryKey(goods.getSellerId()).getNickName());   // 商家店铺名称
    }
}

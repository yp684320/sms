package cn.itcast.core.service.goods;

import cn.itcast.core.entity.PageResult;
import cn.itcast.core.pojo.good.Goods;
import cn.itcast.core.vo.GoodsVo;

public interface GoodsService {
    /**
     * 新增
     * @param goodsVo
     */
    public void add(GoodsVo goodsVo);
    /**
     * 商家系统下的商品列表查询
     * @param page
     * @param rows
     * @param goods
     * @return
     */
    public PageResult searchForShop(Integer page, Integer rows, Goods goods);

    /**
     * 商品修改数据回显
     * @param id
     * @return
     */
    public GoodsVo findOne(Long id);

    /**
     * 商品修改
     * @param goodsVo
     */
    public void update(GoodsVo goodsVo);

    /**
     * 运营商查询商品列表信息
     * @param page
     * @param rows
     * @param goods
     */
    public PageResult searchByManager(Integer page,Integer rows,Goods goods);
    /**
     *
     * @Title: updateStatus
     * @Description: 商品审核
     * @param ids
     * @param status
     * @return void
     * @throws
     */
    public void updateStatus(Long[] ids, String status);
    /**
     *
     * @Title: delete
     * @Description: 删除商品
     * @param ids
     * @return void
     * @throws
     */
    public void delete(Long[] ids);


}

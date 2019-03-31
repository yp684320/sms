package cn.itcast.core.service.itemcat;
import cn.itcast.core.pojo.item.ItemCat;
import cn.itcast.core.pojo.item.ItemCatQuery;
import cn.itcast.core.dao.item.ItemCatDao;
import cn.itcast.core.service.itemcat.ItemCatService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Resource
    private ItemCatDao itemCatDao;
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 商品分类的列表查询
     * @param parentId
     * @return
     */
    @Override
    public List<ItemCat> findByParentId(Long parentId) {
        //点击列表查询时将数据写到缓存中
        List<ItemCat> itemCats = itemCatDao.selectByExample(null);
        if (itemCats!= null && itemCats.size()>0) {
            for (ItemCat itemCat : itemCats) {
                //将分类名称  模板id保存到缓存中
                 redisTemplate.boundHashOps("itemCat").put(itemCat.getName(),itemCat.getTypeId());            }
        }
        ItemCatQuery itemCatQuery = new ItemCatQuery();
        itemCatQuery.createCriteria().andParentIdEqualTo(parentId);
        return itemCatDao.selectByExample(itemCatQuery);
    }

    /**
     * 商品分类的列表添加
     * @param itemCat
     */
     @Transactional
    @Override
    public void add(ItemCat itemCat) {
        itemCatDao.insertSelective(itemCat);
    }

    /**
     * 通过三级分类加载出模板id
     * @param id
     * @return
     */
    @Override
    public ItemCat findOne(Long id) {
        return itemCatDao.selectByPrimaryKey(id);
    }

    /**
     * 回显分类名称
     * @return
     */
    @Override
    public List<ItemCat> findAll() {
        return itemCatDao.selectByExample(null);
    }


}

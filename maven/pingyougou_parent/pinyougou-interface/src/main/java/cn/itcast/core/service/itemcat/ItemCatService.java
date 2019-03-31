package cn.itcast.core.service.itemcat;

import cn.itcast.core.pojo.item.ItemCat;

import java.util.List;

public interface ItemCatService {

    /**
     * 商品分类的列表查询
     * @param parentId
     * @return
     */
    public List<ItemCat> findByParentId(Long parentId);

    /**
     * 商品分类的列表添加
     * @param itemCat
     */
    public void add(ItemCat itemCat);

    /**
     * 通过三级分类加载出模板id
     * @param id
     * @return
     */
  public ItemCat findOne(Long id);

    /**
     * 回显分类名称
     * @return
     */
    public List<ItemCat> findAll();

}

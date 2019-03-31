package cn.itcast.core.service.search;

import java.util.Map;

public interface ItemSearchService {

    /**12
     * 前台系统的检索
     * @param searchMap
     * @return
     */
    public Map<String ,Object> search(Map<String,String> searchMap);

    /**
     * 将商品信息保存到索引库中
     * @param id
     */
    void updateItemToSolr2(Long id);

    /**
     * 将商品信息从索引库找中删除
     * @param id
     */
    void deleteItemFromSolr(Long id);
}

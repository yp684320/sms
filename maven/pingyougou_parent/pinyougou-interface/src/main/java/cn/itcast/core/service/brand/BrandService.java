package cn.itcast.core.service.brand;

import cn.itcast.core.entity.PageResult;
import cn.itcast.core.pojo.good.Brand;

import java.util.List;
import java.util.Map;

public interface BrandService {
    /**
     * 查询所有
     * @return
     */
    public List<Brand> findAll();

    /**
     * 品牌列表分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult findPage(Integer pageNum, Integer pageSize);
    /**
     * 品牌列表条件查询
     * @param pageNum
     * @param pageSize
     * @param brand
     * @return
     */
    public PageResult search(Integer pageNum, Integer pageSize, Brand brand);
    /**
     * 新增品牌
     * @param brand
     */
    public void add(Brand brand);

    /**
     * 修改数据回显
     * @param id
     * @return
     */
    public Brand findOne(Long id);

    /**
     * 修改保存
     * @param brand
     */
    public void update(Brand brand);

    /**
     * 批量删除
     * @param ids
     */
    public void del(Long[] ids);

    /**
     * 新增模板时初始化品牌
     * @return
     */
    public List<Map<String,String>> selectOptionList();

}

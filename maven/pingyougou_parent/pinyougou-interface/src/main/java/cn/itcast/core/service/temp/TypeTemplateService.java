package cn.itcast.core.service.temp;

import cn.itcast.core.entity.PageResult;
import cn.itcast.core.pojo.template.TypeTemplate;

import java.util.List;
import java.util.Map;

public interface TypeTemplateService {
    /**
     * 商品模板的列表查询
     * @param page
     * @param rows
     * @param typeTemplate
     * @return
     */
    public PageResult search(Integer page , Integer rows,TypeTemplate typeTemplate);

    /**
     * 新增模板
     * @param typeTemplate
     */
    public void add(TypeTemplate typeTemplate);

    /**
     * 修改模板回显数据
     * @param id
     * @return
     */
    public TypeTemplate findOne(Long id);

    /**
     * 修改
     * @param typeTemplate
     */
    public void update(TypeTemplate typeTemplate);

    /**
     * 删除
     * @param ids
     */
    public void delete(Long[] ids);

    /**
     * 根据模板ID获取对应的规格及规格选项
     * @param id
     * @return
     */
    List<Map> findBySpecList(Long id);

    /**
     * 新增分类时获取模板的下拉框列表
     * @return
     */
    public List<TypeTemplate> findAll();
}

package cn.itcast.core.service.temp;

import cn.itcast.core.pojo.specification.SpecificationOption;
import cn.itcast.core.pojo.specification.SpecificationOptionQuery;
import cn.itcast.core.dao.good.BrandDao;
import cn.itcast.core.dao.specification.SpecificationDao;
import cn.itcast.core.dao.specification.SpecificationOptionDao;
import cn.itcast.core.dao.template.TypeTemplateDao;
import cn.itcast.core.entity.PageResult;
import cn.itcast.core.pojo.template.TypeTemplate;
import cn.itcast.core.pojo.template.TypeTemplateQuery;
import cn.itcast.core.service.temp.TypeTemplateService;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service
public class TypeTemplateImpl implements TypeTemplateService {
    @Resource
    SpecificationOptionDao specificationOptionDao;
    @Resource
    SpecificationDao specificationDao;
    @Resource
    BrandDao brandDao;
    @Resource
    private TypeTemplateDao typeTemplateDao;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    /**
     * 商品模板的列表查询
     * @param page
     * @param rows
     * @param typeTemplate
     * @return
     */
    @Override
    public PageResult search(Integer page, Integer rows, TypeTemplate typeTemplate) {
        // 点击列表查询的时候将数据写到缓存中
        List<TypeTemplate> list = typeTemplateDao.selectByExample(null);
        if(list != null && list.size() > 0){
            for (TypeTemplate template : list) {
                // 将品牌结果集放入缓存
                String brandIds = template.getBrandIds();
                List<Map> brandList = JSON.parseArray(brandIds, Map.class);
                redisTemplate.boundHashOps("brandList").put(template.getId(), brandList);
                // 将规格结果集放入缓存
                List<Map> specList = findBySpecList(template.getId());
                redisTemplate.boundHashOps("specList").put(template.getId(), specList);
            }
        }

        // 1、设置分页条件
        PageHelper.startPage(page, rows);
        // 2、设置查询条件
        TypeTemplateQuery typeTemplateQuery = new TypeTemplateQuery();
        if(typeTemplate.getName() != null && !"".equals(typeTemplate.getName().trim())){
            typeTemplateQuery.createCriteria().andNameLike("%" + typeTemplate.getName().trim() + "%");
        }
        // 3、根据条件查询
        Page<TypeTemplate> p = (Page<TypeTemplate>) typeTemplateDao.selectByExample(typeTemplateQuery);
        // 4、将结果封装到PageResult中
        return new PageResult(p.getResult(), p.getTotal());
    }

    /**
     * 新增模板
     * @param typeTemplate
     */
    @Transactional
    @Override
    public void add(TypeTemplate typeTemplate) {
        typeTemplateDao.insertSelective(typeTemplate);
    }

    /**
     * 修改模板回显数据
     * @param id
     * @return
     */
    @Override
    public TypeTemplate findOne(Long id) {
        return typeTemplateDao.selectByPrimaryKey(id);
    }

    /**
     * 修改
     * @param typeTemplate
     */
    @Transactional
    @Override
    public void update(TypeTemplate typeTemplate) {
        typeTemplateDao.updateByPrimaryKeySelective(typeTemplate);

    }

    /**
     * 删除
     * @param ids
     */
    @Transactional
    @Override
    public void delete(Long[] ids) {
        if (ids!=null && ids.length>0) {
            for (Long id : ids) {
                typeTemplateDao.deleteByPrimaryKey(id);
            }
        }
    }

    /**
     * 根据模板ID获取对应的规格及规格选项
     * @param id
     * @return
     */
    @Override
    public List<Map> findBySpecList(Long id) {
       //获取模板
        TypeTemplate typeTemplate = typeTemplateDao.selectByPrimaryKey(id);
        //获取关联的规格
        String specIds = typeTemplate.getSpecIds();
        // 将json串转成对象：阿里fastjson
        List<Map> specList = JSON.parseArray(specIds, Map.class);
        //通过规格获取规格选项
        if (specIds!=null && specIds.length()>0) {
            for (Map map : specList) {
                //获取规格id
                Long specId = Long.parseLong(map.get("id").toString());
                SpecificationOptionQuery optionQuery = new SpecificationOptionQuery();
                optionQuery.createCriteria().andSpecIdEqualTo(specId);
                List<SpecificationOption> options = specificationOptionDao.selectByExample(optionQuery);
                map.put("options",options);

            }
        }
        return specList;
    }
    /**
     * 新增分类时获取模板的下拉框列表
     * @return
     */
    @Override
    public List<TypeTemplate> findAll() {
        return typeTemplateDao.selectByExample(null);
    }
}

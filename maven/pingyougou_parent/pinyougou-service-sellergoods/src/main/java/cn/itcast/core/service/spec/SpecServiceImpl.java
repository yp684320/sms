package cn.itcast.core.service.spec;

import cn.itcast.core.dao.specification.SpecificationDao;
import cn.itcast.core.dao.specification.SpecificationOptionDao;
import cn.itcast.core.entity.PageResult;
import cn.itcast.core.pojo.specification.Specification;
import cn.itcast.core.pojo.specification.SpecificationOption;
import cn.itcast.core.pojo.specification.SpecificationOptionQuery;
import cn.itcast.core.pojo.specification.SpecificationQuery;
import cn.itcast.core.service.spec.SpecService;
import cn.itcast.core.vo.SpecVo;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class SpecServiceImpl implements SpecService {
    @Resource
    SpecificationDao specificationDao;
    @Resource
    SpecificationOptionDao specificationOptionDao;
    /**
     * 列表查询
     * @param page
     * @param rows
     * @param specification
     * @return
     */
    @Override
    public PageResult search(Integer page, Integer rows, Specification specification) {
        // 1、设置分页条件
        PageHelper.startPage(page, rows);
        // 2、设置查询条件
        SpecificationQuery specificationQuery = new SpecificationQuery();
        if(specification.getSpecName() != null && !"".equals(specification.getSpecName().trim())){
            specificationQuery.createCriteria().andSpecNameLike("%" + specification.getSpecName().trim() +"%");
        }
        specificationQuery.setOrderByClause("id desc");
        // 3、根据条件查询
        Page<Specification> p = (Page<Specification>) specificationDao.selectByExample(specificationQuery);
        // 4、将结果封装到PageResult中
        return new PageResult(p.getResult(), p.getTotal());
    }

    /**
     * 保存规格
     * @param specVo
     */
    @Override
    @Transactional
    public void add(SpecVo specVo) {
        //保存规格
        Specification specification = specVo.getSpecification();
        //配置返回主键自增
        specificationDao.insertSelective(specification);
        //保存规格选项
        List<SpecificationOption> specificationOptionList = specVo.getSpecificationOptionList();
        if (specificationOptionList!=null && specificationOptionList.size()>0) {
            for (SpecificationOption specificationOption : specificationOptionList) {
            //设置外键
            specificationOption.setSpecId(specification.getId());
        }//批量保存
            specificationOptionDao.insertSelectives(specificationOptionList);
        }
    }

    /**
     * 修改数据回显
     * @param id
     * @return
     */
    @Override
    public SpecVo findOne(Long id) {
        //查询规格
        Specification specification = specificationDao.selectByPrimaryKey(id);
        //查询规格选项
        SpecificationOptionQuery specificationOptionQuery = new SpecificationOptionQuery();
        SpecificationOptionQuery.Criteria criteria = specificationOptionQuery.createCriteria();
        criteria.andSpecIdEqualTo(id);
        List<SpecificationOption> specificationOptions = specificationOptionDao.selectByExample(specificationOptionQuery);
        //封装数据
        SpecVo specVo = new SpecVo();
        specVo.setSpecification(specification);
        specVo.setSpecificationOptionList(specificationOptions);
        return specVo;
    }

    /**
     * 修改
     * @param specVo
     */
    @Transactional
    @Override
    public void update(SpecVo specVo) {
        //修改规格
        Specification specification = specVo.getSpecification();
        specificationDao.updateByPrimaryKeySelective(specification);
        //修改规格选项
        //先清空再修改
        SpecificationOptionQuery specificationOptionQuery = new SpecificationOptionQuery();
        SpecificationOptionQuery.Criteria criteria = specificationOptionQuery.createCriteria();
        criteria.andSpecIdEqualTo(specification.getId());
        specificationOptionDao.deleteByExample(specificationOptionQuery);
        List<SpecificationOption> specificationOptionList = specVo.getSpecificationOptionList();
        if (specificationOptionList!=null && specificationOptionList.size()>0) {
            for (SpecificationOption specificationOption : specificationOptionList) {
                //设置外键
                specificationOption.setSpecId(specification.getId());
            }
            //批量插入
            specificationOptionDao.insertSelectives(specificationOptionList);
        }

    }

    /**
     * 删除规格
     * @param ids
     */
   @Transactional
    @Override
    public void delete(Long[] ids) {
       if (ids!=null && ids.length>0) {
           for (Long id : ids) {
               //先删除规格选项
               SpecificationOptionQuery specificationOptionQuery = new SpecificationOptionQuery();
               SpecificationOptionQuery.Criteria criteria = specificationOptionQuery.createCriteria();
               criteria.andSpecIdEqualTo(id);
               specificationOptionDao.deleteByExample(specificationOptionQuery);
               //再删除规格
               specificationDao.deleteByPrimaryKey(id);

           }
       }

    }

    /**
     * 新增模板时初始化规格
     * @return
     */
    @Override
    public List<Map<String, String>> selectOptionList() {
        return specificationDao.selectOptionList();
    }
}

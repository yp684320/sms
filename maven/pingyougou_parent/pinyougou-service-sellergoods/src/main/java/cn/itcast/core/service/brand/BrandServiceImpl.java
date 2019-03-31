package cn.itcast.core.service.brand;

import cn.itcast.core.dao.good.BrandDao;
import cn.itcast.core.entity.PageResult;
import cn.itcast.core.pojo.good.Brand;
import cn.itcast.core.pojo.good.BrandQuery;
import cn.itcast.core.service.brand.BrandService;
import com.alibaba.dubbo.config.annotation.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {
    @Resource
    BrandDao brandDao;

    /**
     * 查询所有品牌
     * @return
     */
    @Override
    public List<Brand> findAll() {
        List<Brand> brands = brandDao.selectByExample(null);
        return brands;
    }

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageResult findPage(Integer pageNum, Integer pageSize) {
        //设置分页参数
        PageHelper.startPage(pageNum,pageSize);
        /* 查询结果集 */
        Page<Brand> page = (Page<Brand>) brandDao.selectByExample(null);
        return new PageResult(page.getResult(),page.getTotal());
    }
    /**
     * 品牌列表条件查询
     * @param pageNum
     * @param pageSize
     * @param brand
     * @return
     */
    @Override
    public PageResult search(Integer pageNum, Integer pageSize, Brand brand) {
        // 1、设置分页条件-分页插件
        PageHelper.startPage(pageNum, pageSize);
        // 2、设置查询条件
        BrandQuery brandQuery = new BrandQuery();
        // 封装查询条件：
        BrandQuery.Criteria criteria = brandQuery.createCriteria();
        if(brand.getName() != null && !"".equals(brand.getName().trim())){
            criteria.andNameLike("%" + brand.getName().trim() + "%");
        }
        if(brand.getFirstChar() != null && !"".equals(brand.getFirstChar().trim())){
            criteria.andFirstCharEqualTo(brand.getFirstChar().trim());
        }
        // 设置根据字段排序
        brandQuery.setOrderByClause("id desc");
        // 3、根据条件查询
        Page<Brand> page = (Page<Brand>) brandDao.selectByExample(brandQuery);
        // 4、创建PageResult对象并且封装结果
        return new PageResult(page.getResult(), page.getTotal());
    }
    /**
     * 新增品牌
     * @param brand
     */
    @Transactional
    @Override
    public void add(Brand brand) {
        brandDao.insertSelective(brand);
    }

    /**
     * 修改数据回显
     * @param id
     * @return
     */
    @Override
    public Brand findOne(Long id) {
        return brandDao.selectByPrimaryKey(id);
    }

    /**
     * 修改保存
     * @param brand
     */
    @Transactional
    public void update(Brand brand){
        brandDao.updateByPrimaryKeySelective(brand);
    }

    /**
     * 批量删除
     * @param ids
     */
    @Transactional
    @Override
    public void del(Long[] ids) {
        //判断ids是否为空
        if (ids!=null && ids.length>0) {
            for (Long id : ids) {
                brandDao.deleteByPrimaryKeys(ids);
            }
        }

    }

    /**
     * 新增模板时初始化品牌
     * @return
     */
    @Override
    public List<Map<String, String>> selectOptionList() {
        return brandDao.selectOptionList();
    }
}

package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class LabelService {

    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    public Label queryById(String labelId) {
        return labelDao.findById(labelId).get();
    }

    public List<Label> queryAll() {
        return labelDao.findAll();
    }

    @Transactional
    public void save(Label label) {
        //使用分布式id生成器
        String id = idWorker.nextId() + "";
        label.setId(id);

        labelDao.save(label);
    }

    @Transactional
    public void updateById(Label label) {
        labelDao.save(label);
    }

    @Transactional
    public void deleteById(String labelId) {
        labelDao.deleteById(labelId);
    }

    public List<Label> search(Label label) {
        //调用方法获取查询条件Specification
        Specification<Label> specification = getSpecification(label);
        List<Label> list = labelDao.findAll(specification);

        return list;
    }

    //创建查询条件对象
    private Specification<Label> getSpecification(Label label) {
        return new Specification<Label>() {
            //root是查询条件构建的根
            //query查询条件的条件对象
            //cb:进行查询条件构建的
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder
                    cb) {
                //声明List集合,封装条件对象
                List<Predicate> predicateList = new ArrayList<>();

                //判断条件是否有值,如果有值需要添加到and组合条件中
                if (label.getLabelname() != null && label.getLabelname() != "") {
                    //封装条件
                    Predicate predicate = cb.like(root.get("labelname").as(String.class), label.getLabelname());
                    //把条件放到集合中
                    predicateList.add(predicate);
                }

                //状态
                if (label.getState() != null && label.getState() != "") {
                    Predicate predicate = cb.equal(root.get("state").as(String.class), label.getState());
                    predicateList.add(predicate);
                }

                //使用数量
                if (label.getCount() != null) {
                    Predicate predicate = cb.equal(root.get("count").as(Long.class), label.getCount());
                    predicateList.add(predicate);
                }

                //关注数
                if (label.getFans() != null) {
                    Predicate predicate = cb.equal(root.get("fans").as(Long.class), label.getFans());
                    predicateList.add(predicate);
                }

                //是否推荐
                if (label.getRecommend() != null && label.getRecommend() != "") {
                    Predicate predicate = cb.equal(root.get("recommend").as(String.class), label.getRecommend());
                    predicateList.add(predicate);
                }

                //再根据集合的长度创建数组
                Predicate[] predicates = new Predicate[predicateList.size()];
                //把集合中的元素放到数组中
                predicates = predicateList.toArray(predicates);

                //多个条件查询,中间使用and并且连接,可变参数接受的是数组
                return cb.and(predicates);
            }
        };

        //Specification<Label> specification = new Specification<Label>() {
        //    @Override
        //    public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder
        //            criteriaBuilder) {
        //        return null;
        //    }
        //};
        //return specification;
    }

    public Page<Label> search(Label label, Integer page, Integer size) {
        //获取复杂查询条件对象
        Specification<Label> specification = getSpecification(label);

        //封装分页查询对象,业务要求页码数从1开始,方法的参数是从0开始,需要对传入的页码数-1
        PageRequest pageRequest = PageRequest.of(page - 1, size);

        //执行条件分页查询
        Page<Label> pageData = labelDao.findAll(specification, pageRequest);

        return pageData;
    }
}

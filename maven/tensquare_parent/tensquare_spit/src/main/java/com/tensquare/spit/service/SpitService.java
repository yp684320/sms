package com.tensquare.spit.service;

import com.tensquare.spit.dao.SpitDao;
import com.tensquare.spit.pojo.Spit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.Date;
import java.util.List;

@Service
public class SpitService {

    @Autowired
    private SpitDao spitDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Spit findById(String spitId) {
        return spitDao.findById(spitId).get();
    }

    public List<Spit> findAll() {
        return spitDao.findAll();
    }

    public void save(Spit spit) {
        //现在是分布式架构，需要使用分布式id生成器
        String id = idWorker.nextId() + "";
        spit.set_id(id);

        //设置吐槽的基本数据
        spit.setPublishtime(new Date());
        spit.setVisits(0);//浏览量
        spit.setThumbup(0);//点赞数
        spit.setShare(0);//分享数
        spit.setComment(0);//回复数
        spit.setState("1");//是否可见


//        //查询新添加吐槽的父id
//        try {
//            Spit parent = spitDao.findById(spit.getParentid()).get();
//            if (parent != null) {
//                //如果有父吐槽,把父吐槽的回复数加一
//                parent.setComment(parent.getComment() + 1);
//                spitDao.save(parent);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        //查询新添加吐槽的父id
        try {
            //根据父id查询父吐槽,如果没有查到值,Optional会抛出NoSuchElementException
            Spit parent = spitDao.findById(spit.getParentid()).get();
            //如果有父吐槽,把父吐槽的回复数加一
            parent.setComment(parent.getComment() + 1);
            spitDao.save(parent);

        } catch (Exception e) {
            //如果没有父,神马都不做
        }


        //添加吐槽
        spitDao.save(spit);
    }

    public void updateById(Spit spit) {
        spitDao.save(spit);
    }

    public void deleteById(String spitId) {
        spitDao.deleteById(spitId);
    }

    public Page<Spit> comment(String parentid, Integer page, Integer size) {
        //创建分页查询条件
        PageRequest pageRequest = PageRequest.of(page - 1, size);

        //执行查询
        Page<Spit> pageData = spitDao.findByParentid(parentid, pageRequest);

        return pageData;
    }

    public void thumbup(String spitId) {
//        //根据吐槽id查询吐槽
//        Spit spit = spitDao.findById(spitId).get();
//        //把吐槽的点赞数加一
//        spit.setThumbup(spit.getThumbup() + 1);
//        //执行修改
//        spitDao.save(spit);

        //使用mongoTemplate直接点赞加一，性能更好
        //db.spit.update({"_id" : "5566"},{$inc:{thumbup:NumberInt(1)}})
        //设置修改的条件{"_id" : "5566"}
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is("5566"));

        //设置修改的数据{$inc:{thumbup:NumberInt(1)}}
        Update update = new Update();
        update.inc("thumbup", 1);

        mongoTemplate.updateFirst(query, update, "spit");

    }
}

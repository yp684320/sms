package com.tensquare.recruit.dao;

import com.tensquare.recruit.pojo.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 数据访问接口
 *
 * @author Administrator
 */
public interface RecruitDao extends JpaRepository<Recruit, String>, JpaSpecificationExecutor<Recruit> {

    //查询最新的推荐职位列表
    //state=2 发布时间createtime倒序排序
    public List<Recruit> findByStateOrderByCreatetimeDesc(String state);

    //查询最新职位列表
    //state!=0,发布时间createtime倒序排序
    public List<Recruit> findByStateNotOrderByCreatetimeDesc(String state);

}

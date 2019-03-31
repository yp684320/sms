package com.tensquare.qa.dao;

import com.tensquare.qa.pojo.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 *
 * @author Administrator
 */
public interface ProblemDao extends JpaRepository<Problem, String>, JpaSpecificationExecutor<Problem> {

    //最新回答
    @Query(value = "SELECT * FROM tb_problem WHERE id in (SELECT problemid FROM tb_pl WHERE labelid=?)" +
            "  ORDER BY createtime DESC", nativeQuery = true)
    Page<Problem> newlist(String label, Pageable pageable);

    //热门回答
    @Query(value = "SELECT * FROM tb_problem WHERE id in (SELECT problemid FROM tb_pl WHERE labelid=?)" +
            " ORDER BY reply DESC", nativeQuery = true)
    Page<Problem> hotlist(String label, Pageable pageRequest);

    //等待回答
    @Query(value = "SELECT * FROM tb_problem WHERE id in (SELECT problemid FROM tb_pl WHERE labelid=?)" +
            " AND reply = 0", nativeQuery = true)
    Page<Problem> waitlist(String label, Pageable pageRequest);
}

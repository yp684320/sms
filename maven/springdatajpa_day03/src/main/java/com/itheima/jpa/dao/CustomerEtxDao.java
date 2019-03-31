package com.itheima.jpa.dao;

import com.itheima.jpa.entity.CustomerEtx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CustomerEtxDao extends JpaRepository<CustomerEtx,Long>,JpaSpecificationExecutor<CustomerEtx> {
}

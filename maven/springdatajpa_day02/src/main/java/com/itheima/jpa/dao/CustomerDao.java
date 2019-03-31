package com.itheima.jpa.dao;

import com.itheima.jpa.pojo.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CustomerDao extends JpaRepository<Customer,Long>,JpaSpecificationExecutor<Customer>{
}

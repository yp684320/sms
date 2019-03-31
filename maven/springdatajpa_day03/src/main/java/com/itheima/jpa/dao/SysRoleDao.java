package com.itheima.jpa.dao;

import com.itheima.jpa.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface SysRoleDao extends JpaRepository<SysRole,Long>,JpaSpecificationExecutor<SysRole> {
}

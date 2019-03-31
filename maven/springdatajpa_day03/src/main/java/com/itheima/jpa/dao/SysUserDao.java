package com.itheima.jpa.dao;

import com.itheima.jpa.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SysUserDao extends JpaRepository<SysUser,Long>,JpaSpecificationExecutor<SysUser> {
}

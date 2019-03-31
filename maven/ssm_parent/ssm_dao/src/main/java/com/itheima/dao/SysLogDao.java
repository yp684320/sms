package com.itheima.dao;

import com.itheima.domain.SysLog;
import org.apache.ibatis.annotations.Insert;

public interface SysLogDao {
    @Insert("insert into sys_log values(log_seq.nextval,#{visitTime},#{username},#{ip},#{method})")
    void save(SysLog sysLog);
}

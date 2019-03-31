package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.Role;
import com.itheima.domain.SysUser;
import com.itheima.service.UserService;
import com.itheima.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    UserDao userDao;

    /**
     * 根据用户名载入用户对象(用户名和密码)
     * @param username
     * @return   用户的详情对象-- 安全框架声明的对象
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //1. 根据用户名从数据库中查询该用户
        SysUser sysUser = userDao.findByUsername(username);
        //2. 创建用户详情对象，返回安全框架
        if(sysUser != null){
            /**
             * 参数1：数据库查询到用户名
             * 参数2：数据库查询到密码
             * 参数3：认证角色-- 先提供临时的角色列表
             */
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            //创建假用户角色对象
         //   SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
          //给用户赋予真角色
            for (Role role : sysUser.getRoleList()) {
                SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_"+role.getRoleName());
                authorities.add(grantedAuthority);
            }


            User user = new User(sysUser.getUsername(),sysUser.getPassword(),authorities);
            return user;
        }
        return null;
    }
    //查询所有
    @Override
    public List<SysUser> findAll() {
        return userDao.findAll();
    }
    //保存
    @Override
    public void save(SysUser user) {
        //MD5加密
      /*  //获取明文密码
        String password = user.getPassword();
        //进行加密
        String s = MD5Utils.md5(password);
        ////把加密后的密码存入user中
        user.setPassword(s);
        userDao.save(user);*/

      //安全框架提供的BCryptPasswordEncoder加密
        //获取明文密码
        String password = user.getPassword();
        //进行加密
        String encodePassword = passwordEncoder.encode(password);
        //把加密后的密码存入对象中
        user.setPassword(encodePassword);
        userDao.save(user);


    }

    @Override
    public boolean isUniqueUsername(String username) {
      SysUser user =  userDao.findByUsernameIsUnique(username);
        return user==null;
    }
//查询用户的详情
    @Override
    public SysUser findById(Integer userId) {
        return userDao.findById(userId);
    }
    //为用户添加角色
    @Override
    public void addRoleToUser(Integer userId, Integer[] ids) {
        //删除所有数据
        userDao.delRolesFromUser(userId);
        //维护新的关系
        if (ids!=null) {
            for (Integer roleId : ids) {
                userDao.saveRolesToUser(userId , roleId);
            }
        }
    }


}

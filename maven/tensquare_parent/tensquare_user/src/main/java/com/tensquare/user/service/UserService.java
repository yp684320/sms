package com.tensquare.user.service;

import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.persistence.Transient;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import com.tensquare.user.dao.UserDao;
import com.tensquare.user.pojo.User;

/**
 * 服务层
 *
 * @author Administrator
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private BCryptPasswordEncoder encoder;

    /**
     * 查询全部列表
     *
     * @return
     */
    public List<User> findAll() {
        return userDao.findAll();
    }


    /**
     * 条件查询+分页
     *
     * @param whereMap
     * @param page
     * @param size
     * @return
     */
    public Page<User> findSearch(Map whereMap, int page, int size) {
        Specification<User> specification = createSpecification(whereMap);
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return userDao.findAll(specification, pageRequest);
    }


    /**
     * 条件查询
     *
     * @param whereMap
     * @return
     */
    public List<User> findSearch(Map whereMap) {
        Specification<User> specification = createSpecification(whereMap);
        return userDao.findAll(specification);
    }

    /**
     * 根据ID查询实体
     *
     * @param id
     * @return
     */
    public User findById(String id) {
        return userDao.findById(id).get();
    }

    /**
     * 增加
     *
     * @param user
     */
    public void add(User user) {
        user.setId(idWorker.nextId() + "");
        userDao.save(user);
    }

    /**
     * 修改
     *
     * @param user
     */
    public void update(User user) {
        userDao.save(user);
    }

    /**
     * 删除
     *
     * @param id
     */
    public void deleteById(String id) {
        userDao.deleteById(id);
    }

    /**
     * 动态条件构建
     *
     * @param searchMap
     * @return
     */
    private Specification<User> createSpecification(Map searchMap) {

        return new Specification<User>() {

            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<Predicate>();
                // ID
                if (searchMap.get("id") != null && !"".equals(searchMap.get("id"))) {
                    predicateList.add(cb.like(root.get("id").as(String.class), "%" + (String) searchMap.get("id") + "%"));
                }
                // 手机号码
                if (searchMap.get("mobile") != null && !"".equals(searchMap.get("mobile"))) {
                    predicateList.add(cb.like(root.get("mobile").as(String.class), "%" + (String) searchMap.get("mobile") + "%"));
                }
                // 密码
                if (searchMap.get("password") != null && !"".equals(searchMap.get("password"))) {
                    predicateList.add(cb.like(root.get("password").as(String.class), "%" + (String) searchMap.get("password") + "%"));
                }
                // 昵称
                if (searchMap.get("nickname") != null && !"".equals(searchMap.get("nickname"))) {
                    predicateList.add(cb.like(root.get("nickname").as(String.class), "%" + (String) searchMap.get("nickname") + "%"));
                }
                // 性别
                if (searchMap.get("sex") != null && !"".equals(searchMap.get("sex"))) {
                    predicateList.add(cb.like(root.get("sex").as(String.class), "%" + (String) searchMap.get("sex") + "%"));
                }
                // 头像
                if (searchMap.get("avatar") != null && !"".equals(searchMap.get("avatar"))) {
                    predicateList.add(cb.like(root.get("avatar").as(String.class), "%" + (String) searchMap.get("avatar") + "%"));
                }
                // E-Mail
                if (searchMap.get("email") != null && !"".equals(searchMap.get("email"))) {
                    predicateList.add(cb.like(root.get("email").as(String.class), "%" + (String) searchMap.get("email") + "%"));
                }
                // 兴趣
                if (searchMap.get("interest") != null && !"".equals(searchMap.get("interest"))) {
                    predicateList.add(cb.like(root.get("interest").as(String.class), "%" + (String) searchMap.get("interest") + "%"));
                }
                // 个性
                if (searchMap.get("personality") != null && !"".equals(searchMap.get("personality"))) {
                    predicateList.add(cb.like(root.get("personality").as(String.class), "%" + (String) searchMap.get("personality") + "%"));
                }

                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));

            }
        };

    }

    public void sendsms(String mobile) {
        //创建短信验证码
        Random random = new Random();

        //创建6位的短信验证码
        //random.nextInt(900000) -> 0~899999
        //把结果加100000    范围就变成了  100000~999999
        String code = random.nextInt(900000) + 100000 + "";

        //把创建好的短信验证码放到redis中,设置短信验证码的有效时间是5分钟
        redisTemplate.opsForValue().set("mobile_" + mobile, code, 5, TimeUnit.MINUTES);

        //封装发短信的消息内容,包含手机号和验证码
        Map map = new HashMap();
        map.put("mobile", mobile);
        map.put("code", code);

        System.out.println("手机号" + mobile + "的验证码是:" + code);

        //发消息到RabbitMQ中
        rabbitTemplate.convertAndSend("sendsms", map);

    }

    @Transactional
    public void register(User user) {
        //获取分布式id
        String id = idWorker.nextId() + "";
        user.setId(id);

        //初始化用户的其他属性
        user.setRegdate(new Date());//注册时间
        user.setUpdatedate(user.getRegdate());//修改时间
        user.setFanscount(0);//粉丝数
        user.setFollowcount(0);//关注数

        //给密码加密
        user.setPassword(encoder.encode(user.getPassword()));

        //保存用户
        userDao.save(user);


    }

    public User login(User user) {
        //根据电话号码查询用户
        User result = userDao.findByMobile(user.getMobile());

        //进行密码校验
        if (result != null) {
            if (encoder.matches(user.getPassword(), result.getPassword())) {
                return result;
            }
        }

        return null;
    }


    public static void main(String[] args) {
        //根据编号进行修改

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(21);
        list.add(34);
        list.add(128);

        Integer param = 128;
        //有问题
        for (Integer i : list) {
            //在-128~127
            if (i == param) {
                System.out.println("结果是:" + 111);
            }
            System.out.println(i);
        }


        //有问题
        for (Integer integer : list) {
            list.remove(integer);
        }


        //有问题
        String str = "";//这个参数是传递过来的
        //空处理
        if (str.equals("")) {

        }


    }

    //修改粉丝数
    @Transactional
    public void fanscount(Integer x, String userid) {
        userDao.fanscount(x, userid);

    }

    //修改关注数
    @Transactional
    public void followcount(Integer x, String userid) {
        userDao.followcount(x, userid);
    }
}

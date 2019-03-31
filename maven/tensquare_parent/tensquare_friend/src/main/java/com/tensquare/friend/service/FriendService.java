package com.tensquare.friend.service;

import com.tensquare.friend.dao.FriendDao;
import com.tensquare.friend.pojo.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FriendService {

    @Autowired
    private FriendDao friendDao;

    //添加好友功能
    @Transactional
    public Boolean like(String userId, String friendid) {
        //先查询好友关系是否存在
        //Friend result = friendDao.queryUserIdAndFriendId(userId, friendid);
        //如果存在,返回false,表示好友已经添加过了,不能再添加好友
        if (friendDao.queryUserIdAndFriendId(userId, friendid) != null) {
            return false;
        }

        //保存自己和好友的关系
        Friend friend = new Friend();
        friend.setUserid(userId);
        friend.setFriendid(friendid);
        friend.setIslike("0");//默认是单向喜欢
        friendDao.save(friend);

        //查询对方是否加自己为好友
        Friend result = friendDao.queryUserIdAndFriendId(friendid, userId);
        //如果对方加自己为好友,islike应该修改为1
        if (result != null) {
            //把自己加为对方好友关系,设置为相互喜欢
            friendDao.updateIslike("1", userId, friendid);
            //把对方加为自己好友关系,设置为相互喜欢
            friendDao.updateIslike("1", friendid, userId);
        }

        //操作成功返回true
        return true;
    }

    @Transactional
    public void deleteFriend(String userId, String friendid) {
        //删除好友数据
        friendDao.deleteFriend(userId, friendid);

        //判断别人是否加自己为好友
        if (friendDao.queryUserIdAndFriendId(friendid, userId) != null) {
            //修改对方的islike为0
            friendDao.updateIslike("0", friendid, userId);
        }

    }
}

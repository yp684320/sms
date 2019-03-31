package com.tensquare.friend.service;

import com.tensquare.friend.dao.FriendDao;
import com.tensquare.friend.dao.NoFriendDao;
import com.tensquare.friend.pojo.NoFriend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoFriendService {

    @Autowired
    private NoFriendDao noFriendDao;

    public Boolean add(String userId, String friendid) {
        //根据用户id和好友id查询数据
        if (noFriendDao.queryNoFriend(userId, friendid) != null) {
            //如果有值,表示已经添加过非好友了,返回false
            return false;
        }

        //如果没有值,表示可以添加非好友
        NoFriend noFriend = new NoFriend();
        noFriend.setUserid(userId);
        noFriend.setFriendid(friendid);

        noFriendDao.save(noFriend);

        return true;
    }
}

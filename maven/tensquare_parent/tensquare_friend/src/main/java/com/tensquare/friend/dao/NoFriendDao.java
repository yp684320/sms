package com.tensquare.friend.dao;

import com.tensquare.friend.pojo.NoFriend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NoFriendDao extends JpaRepository<NoFriend, String> {

    //根据用户id和还有id查询非好友关系
    @Query(value = "SELECT * FROM tb_nofriend WHERE userid=? AND friendid=?", nativeQuery = true)
    public NoFriend queryNoFriend(String userid, String friendid);

}

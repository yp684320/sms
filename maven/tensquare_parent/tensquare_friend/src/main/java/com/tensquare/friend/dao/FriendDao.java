package com.tensquare.friend.dao;

import com.tensquare.friend.pojo.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface FriendDao extends JpaRepository<Friend, String> {

    //根据用户id和好友id查询数据
    @Query(value = "SELECT * FROM tb_friend WHERE userid=? AND friendid=?", nativeQuery = true)
    public Friend queryUserIdAndFriendId(String userid, String friendid);

    //根据用户id和好友id修改相互喜欢
    @Query(value = "UPDATE tb_friend SET islike=? WHERE userid=? AND friendid=?", nativeQuery = true)
    @Modifying
    public void updateIslike(String islike, String userid, String friendid);

    //根据用户id和好友id删除数据
    @Query(value = "DELETE FROM tb_friend WHERE userid=? AND friendid=?", nativeQuery = true)
    @Modifying
    void deleteFriend(String userId, String friendid);
}

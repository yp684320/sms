package com.tensquare.friend.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_friend")
//声明联合主键
@IdClass(Friend.class)
public class Friend implements Serializable{

    @Id
    private String userid;
    @Id
    private String friendid;

    private String islike;

    public String getIslike() {
        return islike;
    }

    public void setIslike(String islike) {
        this.islike = islike;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFriendid() {
        return friendid;
    }

    public void setFriendid(String friendid) {
        this.friendid = friendid;
    }
}
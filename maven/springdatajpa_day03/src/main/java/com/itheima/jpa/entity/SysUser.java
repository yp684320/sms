package com.itheima.jpa.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sys_user")
public class SysUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "user_name")
    private String username;
    @Column(name = "user_address")
    private String address;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable( name = "user_role_id",joinColumns ={@JoinColumn(name = "u_id",referencedColumnName = "user_id")},
        inverseJoinColumns = {@JoinColumn(name = "r_id",referencedColumnName = "role_id")})
    private Set<SysRole> sysRoleSet = new HashSet<>();

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<SysRole> getSysRoleSet() {
        return sysRoleSet;
    }

    public void setSysRoleSet(Set<SysRole> sysRoleSet) {
        this.sysRoleSet = sysRoleSet;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", sysRoleSet=" + sysRoleSet +
                '}';
    }
}

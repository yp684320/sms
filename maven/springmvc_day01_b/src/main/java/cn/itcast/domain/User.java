package cn.itcast.domain;

import java.util.List;
import java.util.Map;

public class User {
    private String username;
    private Integer age;
    List<Account> accounts;
    Map<Integer , Account> maps;

    public Map<Integer, Account> getMaps() {
        return maps;
    }

    public void setMaps(Map<Integer, Account> maps) {
        this.maps = maps;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", accounts=" + accounts +
                ", maps=" + maps +
                '}';
    }
}

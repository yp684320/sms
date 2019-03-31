package service;

import domain.User;

import java.util.List;

public interface UserService {
     List<User> findAll() ;

    void delete(String id);
}

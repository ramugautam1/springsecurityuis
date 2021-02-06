package com.vastika.uis.repository;

import com.vastika.uis.model.User;

import java.util.List;

public interface UserRepository {
    void saveUser(User user);

    void updateUser(User user);

    List<User> getAllUser();

    User getUserById(int id);

    void deleteUser(int id);
    
    User getUserByUsername(String username);
}

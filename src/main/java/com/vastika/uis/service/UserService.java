package com.vastika.uis.service;

import com.vastika.uis.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    void updateUser(User user);

    List<User> getAllUser();

    User getUserById(int id);

    void deleteUser(int id);
}

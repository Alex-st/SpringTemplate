package com.services;

import com.models.UserModel;

import java.util.List;

/**
 * Created by Oleksandr on 11/8/2016.
 */
public interface UserService {
    UserModel getUserModelByUsername(String username);

    List<UserModel> getAllUsers();

    void saveUser(UserModel userModel);
}

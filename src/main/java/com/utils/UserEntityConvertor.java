package com.utils;

import com.models.UserModel;
import com.persistence.entities.UserEntity;

/**
 * Created by Oleksandr on 11/8/2016.
 */
public class UserEntityConvertor {
    public static UserModel convertToModel(UserEntity userEntity) {
        UserModel userModel = new UserModel();
        userModel.setEnabled(userEntity.getEnabled());
        userModel.setUsername(userEntity.getLogin());
        userModel.setPassword(userEntity.getPassword());

        return userModel;
    }

    public static UserEntity convertToEntity(UserModel userModel) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEnabled(userModel.isEnabled());
        userEntity.setLogin(userModel.getUsername());
        userEntity.setPassword(userModel.getPassword());

        return userEntity;
    }
}

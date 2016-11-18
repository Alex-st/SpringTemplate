package com.services.impl;

import com.exceptions.UserRuntimeException;
import com.models.UserModel;
import com.persistence.entities.UserEntity;
import com.persistence.repositories.UserRepository;
import com.services.UserService;
import com.utils.UserEntityConvertor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Oleksandr on 11/8/2016.
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Inject
    private UserRepository userRepository;

    public UserModel getUserModelByUsername(String username) {

        UserEntity userEntity = userRepository.findOneByLogin(username);
        if (userEntity == null) {
            throw new UserRuntimeException("User " + username + " not found!");
        }
        return UserEntityConvertor.convertToModel(userEntity);
    }

    public void saveUser(UserModel userModel) {
        UserEntity userEntity = UserEntityConvertor.convertToEntity(userModel);
        userRepository.save(userEntity);
    }

    public List<UserModel> getAllUsers() {
        LOG.info("GetAllUsers service");
        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities.stream()
                .map(UserEntityConvertor::convertToModel)
                .collect(Collectors.toList());
    }
}

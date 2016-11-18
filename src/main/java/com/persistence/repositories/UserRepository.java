package com.persistence.repositories;

import com.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Oleksandr on 11/8/2016.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findAllByEnabledIsTrue();

    UserEntity findOneByLogin(String username);
}

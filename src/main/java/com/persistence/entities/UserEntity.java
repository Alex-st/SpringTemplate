package com.persistence.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Oleksandr on 11/8/2016.
 */
@Getter
@Setter
@Entity
@Table(name = "T_USER")
@NoArgsConstructor
public class UserEntity {
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USER_LOGIN", unique = true, nullable = false)
    private String login;

    @Column(name = "USER_PASS", nullable = false)
    private String password;

    @Column(name = "USER_ENABLED", nullable = false)
    private Boolean enabled;

}

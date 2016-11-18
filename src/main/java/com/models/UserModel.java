package com.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Oleksandr on 11/8/2016.
 */
@Getter
@Setter
public class UserModel {
    public static final String USERNAME_NOT_NULL = "Username shouldn't be null";
    public static final String PASSWORD_NOT_NULL = "Password shouldn't be null";
    public static final String DATA_NOT_VALID = "Input data violates length restriction";

    @NotNull(message = USERNAME_NOT_NULL)
    @Size(min=6, max=50, message = DATA_NOT_VALID)
    String username;

    @NotNull(message = PASSWORD_NOT_NULL)
    @Size(min=6, max=50, message = DATA_NOT_VALID)
    String password;

    boolean enabled;
}

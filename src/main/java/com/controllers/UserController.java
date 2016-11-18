package com.controllers;

import com.exceptions.UserRuntimeException;
import com.models.UserModel;
import com.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * Created by Oleksandr on 11/9/2016.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Inject
    private UserService userService;

    /**
     * @return Returns single {@link UserModel}
     * @description Search for user by its username.
     * @httpMethod GET
     * @httpUrl http://{host}:{port}/user/:username
     * @httpUrlExample http://localhost:8080/user/:username
     * @returnType application/json
     */
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public ResponseEntity<UserModel> getUserModel(final @PathVariable("username") String username) {
        return new ResponseEntity<>(userService.getUserModelByUsername(username), HttpStatus.OK);
    }

    /**
     * @return Returns list of {@link UserModel}
     * @description Return all users.
     * @httpMethod GET
     * @httpUrl http://{host}:{port}/user
     * @httpUrlExample http://localhost:8080/user
     * @returnType application/json
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<UserModel>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    /**
     * @description Method to create new user
     * @httpMethod POST
     * @httpUrl http://{host}:{port}/user
     * @httpUrlExample http://localhost:8080/user
     * @requestBodyExample {"username":"userSuccess@test.com","password":"password","enabled":true}
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<Void> saveUser(@RequestBody @Valid final UserModel userModel) {
        userService.saveUser(userModel);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler({UserRuntimeException.class})
    ResponseEntity<String> handleNotFoundRequests(Exception ex) throws IOException {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}

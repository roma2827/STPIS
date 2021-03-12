package com.stpis.backend.controller;

import com.stpis.backend.entity.BO.UserBO;
import com.stpis.backend.entity.UserEntity;
import com.stpis.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public UserEntity createUser(@RequestBody UserBO user){
        return userService.create(user);
    }

    @RequestMapping(value = "/login/{login}", method = RequestMethod.GET)
    public ResponseEntity<UserEntity> getUserByLogin(@PathVariable(name = "login") String login){
        return ResponseEntity.ok(userService.getByLogin(login));
    }
}

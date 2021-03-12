package com.stpis.fapi.controller;

import com.stpis.fapi.models.BO.UserBO;
import com.stpis.fapi.models.User;
import com.stpis.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login/{login}", method = RequestMethod.GET)
    public ResponseEntity<User> getByLogin(@PathVariable(name = "login") String login){
        return ResponseEntity.ok(userService.getByLogin(login));
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(method = RequestMethod.POST)
    public User create(@RequestBody UserBO user){
        return userService.create(user);
    }
}

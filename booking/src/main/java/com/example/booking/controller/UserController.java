package com.example.booking.controller;

import com.example.booking.entity.User;
import com.example.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/login")
    public Object getUser(@RequestBody Map<String,String> param ){
        Map u=userService.findByUsername(param.get("username"),param.get("password"));
        return u;
    }
    @RequestMapping(value = "/deleteUser")
    public Object deleteUser(@RequestBody Map<String,String> param){
        Map re=userService.deleteUserByUserid(param.get("userid"));
        return re;
    }
}

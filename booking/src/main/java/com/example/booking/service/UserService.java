package com.example.booking.service;

import com.example.booking.dao.UserMapper;
import com.example.booking.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public Map findByUsername(String username, String password){
        Map<String,Object> result=new HashMap<>();
        result.put("result",true);
        result.put("message","登录成功");
         User user=userMapper.findByUsername(username);
         if(user==null){
             result.put("result",false);
             result.put("message","用户不存在");
             return result;
         }
         else if(!password.equals(user.getPassword())){
             result.put("result",false);
             result.put("message","密码错误");
             return result;
         }
        else {
             result.put("userid",user.getUserid());
             result.put("username",user.getUsername());
             result.put("sex",user.getSex());
             result.put("telephone",user.getTelephone());
             result.put("role",user.getRole());
             result.put("cardid",user.getCardid());
             return result;
         }
    }
    public Map deleteUserByUserid(String userid) {
        Map<String,Object> result=new HashMap<>();
        result.put("result",true);
        result.put("message","删除成功");
        int re = userMapper.deleteUserByUserid(userid);
        if (re != 1) {
            result.put("result",false);
            result.put("message","删除错误");
            return result;
        }
        return result;
    }
}

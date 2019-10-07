package com.example.booking.dao;

import com.example.booking.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    /**
     * @username
     * @return
     */
    User findByUsername(String username);

    /**
     *
     * @param userid
     * @return
     */
    int deleteUserByUserid(String userid);

    /**
     *
     * @param userid
     * @param username
     * @param password
     * @param sex
     * @param telephone
     * @param role
     * @param cardid
     * @return
     */
    int insertUser(String userid,String username,String password,String sex,String telephone,String role,String cardid);

    /**
     *
     * @param userid
     * @param username
     * @param password
     * @param sex
     * @param telephone
     * @param role
     * @param cardid
     * @return
     */
    int updateByUserid(String userid,String username,String password,String sex,String telephone,String role,String cardid);
}

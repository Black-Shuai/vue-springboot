package com.example.booking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    protected String  userid;
    protected String username;
    protected String password;
    protected String sex;
    protected String telephone;
    protected String role;
    protected String cardid;
}

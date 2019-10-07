package com.example.booking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    protected String userid;
    protected String roomid;
    protected String btime;
    protected String stime;
    protected String rsort;
    protected String state;
    protected String image;
    protected String price;
    protected String preview;
    protected String username;
    protected String sex;
    protected String telephone;
    protected String role;
    protected String cardid;
}

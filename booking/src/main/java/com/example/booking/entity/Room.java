package com.example.booking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    protected String roomid;
    protected String rsort;
    protected String state;
    protected String image;
    protected String price;
    protected String preview;
}

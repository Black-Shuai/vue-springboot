package com.example.booking.controller;

import com.example.booking.dao.UserMapper;
import com.example.booking.entity.Booking;
import com.example.booking.entity.Room;
import com.example.booking.entity.User;
import com.example.booking.service.BookingService;
import com.example.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class BookingController {
    @Autowired
    BookingService bookingService;
    @Autowired
    UserMapper userMapper;
    @RequestMapping(value = "/getAllByUserid")
    public List<Booking> findAllByUserid(@RequestBody Map<String,String> param){
        User user=userMapper.findByUsername(param.get("username"));
        return bookingService.findAllByUserid(String.valueOf(user.getUserid()));
    }
    @RequestMapping(value = "/getAllByRoomid")
    public List<Booking> findAllByRoomid(@RequestBody Map<String,String> param){
        return bookingService.findAllByRoomid(param.get("roomid"));
    }
    @RequestMapping(value = "/getAllRoom")
    public List<Room> getRoom(){
        return bookingService.getRoom();
    }
    @RequestMapping(value = "/getRoomMess")
    public Room getRoomMess(@RequestBody Map<String,String> param){
        return bookingService.findRoomByRoomid(param.get("roomid"));
    }
    @RequestMapping(value = "/Booking")
    public Map Booking(@RequestBody Map<String,String> param){
        User user=userMapper.findByUsername(param.get("username"));
        String roomid=param.get("roomid");
        String btime=param.get("btime");
        String stime=param.get("stime");
        return bookingService.Booking(roomid,user.getUserid(),btime,stime);
    }
    @RequestMapping(value = "/Sroom")
    public Map Sroom(@RequestBody Map<String,String> param){
        String roomid=param.get("roomid");
        return bookingService.Sroom(roomid);
    }
    @RequestMapping(value = "/insertRoom")
    public Map insertRoom(@RequestBody Map<String,String> param){
        String roomid=param.get("roomid");
        String rsort=param.get("rsort");
        String state=param.get("state");
        String image=param.get("image");
        String price=param.get("price");
        String preview=param.get("preview");
        return bookingService.insertRoom(roomid,rsort,state,image,price,preview);
    }
    @RequestMapping(value = "/deleteRoom")
    public Map deleteRoom(@RequestBody Map<String,String> param){
        String roomid=param.get("roomid");
        return bookingService.delteRoom(roomid);
    }
}

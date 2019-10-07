package com.example.booking.service;

import com.example.booking.dao.BookingMapper;
import com.example.booking.entity.Booking;
import com.example.booking.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookingService {
    @Autowired
    BookingMapper bookingMapper;
    public List<Booking> findAllByUserid(String userid){
        return bookingMapper.findAllByUserid(userid);
    }
    public List<Booking> findAllByRoomid(String roomid){
        return bookingMapper.findAllByRoomid(roomid);
    }
    public Room findRoomByRoomid(String roomid){return bookingMapper.findRoomByRoomid(roomid);}
    public List<Room> getRoom(){return bookingMapper.getRoom();}
    public Map Booking(String roomid,String userid,String btime,String stime){
        Map<String,Object> re=new HashMap<>();
        re.put("result",true);
        re.put("message","预定成功");
        Room room=bookingMapper.findRoomByRoomid(roomid);
        int x=bookingMapper.updateByRoomid(roomid,room.getRsort(),"出租",room.getImage(),room.getPrice(),room.getPreview());
        if(x!=1){
            re.put("result",false);
            re.put("message","预定失败");
        }
        int y=bookingMapper.insertBooking(userid,roomid,btime,stime);
        if(y!=1){
            re.put("result",false);
            re.put("message","预定失败");
        }
        return re;
    }
    public Map Sroom(String roomid){
        Map<String,Object> re=new HashMap<>();
        re.put("result",true);
        re.put("message","退房成功");
        Room room=bookingMapper.findRoomByRoomid(roomid);
        int x=bookingMapper.updateByRoomid(roomid,room.getRsort(),"未租",room.getImage(),room.getPrice(),room.getPreview());
        if(x!=1){
            re.put("result",false);
            re.put("message","退房失败");
        }
        int y=bookingMapper.deleteBookingByroomid(roomid);
        if(y!=1){
            re.put("result",false);
            re.put("message","退房失败");
        }
        return re;
    }
    public Map insertRoom(String roomid,String rsort,String state,String image,String price,String preview){
        Map<String,Object> re=new HashMap<>();
        re.put("result",true);
        re.put("message","添加成功");
        Room room=bookingMapper.findRoomByRoomid(roomid);
        if(room!=null){
            re.put("result",false);
            re.put("message","房间已存在");
            return re;
        }
        else {
            int res=bookingMapper.insertRoom(roomid,rsort,state,image,price,preview);
            if (res==1){
                return re;
            }
            else {
                re.put("result",false);
                re.put("message","添加失败");
                return re;
            }
        }
    }
    public Map delteRoom(String roomid){
        Map<String,Object> re=new HashMap<>();
        re.put("result",true);
        re.put("message","删除成功");
        Room room=bookingMapper.findRoomByRoomid(roomid);
        if(room==null){
            re.put("result",false);
            re.put("message","没有该房源，删除失败");
        }
        int y=bookingMapper.deleteRoomByroomid(roomid);
        if(y!=1){
            re.put("result",false);
            re.put("message","删除失败");
        }
        return re;
    }
}

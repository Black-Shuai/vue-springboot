package com.example.booking.dao;

import com.example.booking.entity.Booking;
import com.example.booking.entity.Room;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookingMapper {
    /**
     * @userid
     * @return
     */
    List<Booking> findAllByUserid(String userid);
    /**
     * @roomid
     * @return
     */
    List<Booking> findAllByRoomid(String roomid);
    /**
     * @roomid
     * @return
     */
    Room findRoomByRoomid(String roomid);
    List<Room> getRoom();

    /**
     *
     * @param roomid
     * @return
     */
    int deleteRoomByroomid(String roomid);

    /**
     *
     * @param roomid
     * @param rsort
     * @param state
     * @param image
     * @param price
     * @param preview
     * @return
     */
    int insertRoom(String roomid,String rsort,String state,String image,String price,String preview);

    /**
     *
     * @param roomid
     * @param rsort
     * @param state
     * @param image
     * @param price
     * @param preview
     * @return
     */
    int updateByRoomid(String roomid,String rsort,String state,String image,String price,String preview);

    /**
     *
     * @param roomid
     * @return
     */
    int deleteBookingByroomid(String roomid);

    /**
     *
     * @param userid
     * @param roomid
     * @param btime
     * @param stime
     * @return
     */
    int insertBooking(String userid,String roomid,String btime,String stime);

    /**
     *
     * @param userid
     * @param roomid
     * @param btime
     * @param stime
     * @return
     */
    int updateBookingByRoomid(String userid,String roomid,String btime,String stime);
}

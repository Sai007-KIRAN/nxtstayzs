package com.example.nxtstayz.repository;

import java.util.*;
import org.springframework.stereotype.Repository;

import com.example.nxtstayz.model.*;

@Repository
public interface HotelRepository {
    ArrayList<Hotel> allHotels();

    Hotel eachHotels(int hotelId);

    Hotel addHotel(Hotel hotel);

    Hotel updateHotel(int hotelId, Hotel hotel);

    void deleteHotel(int hotelId);

    List<Room> getHotelRooms(int hotelId);
}
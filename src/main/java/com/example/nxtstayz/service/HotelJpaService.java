package com.example.nxtstayz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

import com.example.nxtstayz.model.*;
import com.example.nxtstayz.repository.*;

@Service
public class HotelJpaService implements HotelRepository {
    @Autowired
    private HotelJpaRepository hjr;

    @Autowired
    private RoomJpaRepository rjr;

    @Override
    public ArrayList<Hotel> allHotels() {
        List<Hotel> list = hjr.findAll();
        ArrayList<Hotel> all = new ArrayList<>(list);
        return all;
    }

    @Override
    public Hotel eachHotels(int hotelId) {
        try {
            Hotel each = hjr.findById(hotelId).get();
            return each;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Hotel addHotel(Hotel hotel) {
        hjr.save(hotel);
        return hotel;
    }

    @Override
    public Hotel updateHotel(int hotelId, Hotel hotel) {
        try {
            Hotel update = hjr.findById(hotelId).get();
            if (hotel.getHotelName() != null) {
                update.setHotelName(hotel.getHotelName());
            }
            if (hotel.getLocation() != null) {
                update.setLocation(hotel.getLocation());
            }
            if (hotel.getRating() >= 0) {
                update.setRating(hotel.getRating());
            }
            hjr.save(update);
            return update;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteHotel(int hotelId) {
        try {
            hjr.deleteById(hotelId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @Override
    public List<Room> getHotelRooms(int hotelId) {
        try {
            Hotel hotel = hjr.findById(hotelId).get();
            return rjr.findByHotel(hotel);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
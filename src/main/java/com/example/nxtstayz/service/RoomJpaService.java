package com.example.nxtstayz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

import com.example.nxtstayz.model.*;
import com.example.nxtstayz.repository.*;

@Service
public class RoomJpaService implements RoomRepository {
    @Autowired
    private RoomJpaRepository rjr;

    @Autowired
    private HotelJpaRepository HJR;

    @Override
    public ArrayList<Room> allRooms() {
        List<Room> list = rjr.findAll();
        ArrayList<Room> all = new ArrayList<>(list);
        return all;
    }

    @Override
    public Room eachRooms(int roomId) {
        try {
            Room room = rjr.findById(roomId).get();
            return room;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Room addRoom(Room room) {
        Hotel hotel = room.getHotel();
        int pId = hotel.getHotelId();
        try {
            Hotel add = HJR.findById(pId).get();
            room.setHotel(add);
            rjr.save(room);
            return room;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Room updateRoom(int roomId, Room room) {
        try {
            Room update = rjr.findById(roomId).get();
            if (room.getRoomNumber() != null) {
                update.setRoomNumber(room.getRoomNumber());
            }
            if (room.getRoomType() != null) {
                update.setRoomType(room.getRoomType());
            }
            if (room.getPrice() >= 0.0) {
                update.setPrice(room.getPrice());
            }
            if (room.getHotel() != null) {
                Hotel hotel = room.getHotel();
                int pId = hotel.getHotelId();
                Hotel add = HJR.findById(pId).get();
                room.setHotel(add);
            }
            rjr.save(room);
            return room;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteRoom(int roomId) {
        try {
            rjr.deleteById(roomId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @Override
    public Hotel getRoomHotel(int roomId) {
        try {
            Room view = rjr.findById(roomId).get();
            return view.getHotel();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
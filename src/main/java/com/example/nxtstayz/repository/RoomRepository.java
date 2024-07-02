package com.example.nxtstayz.repository;

import java.util.*;
import org.springframework.stereotype.Repository;

import com.example.nxtstayz.model.*;

@Repository
public interface RoomRepository {
    ArrayList<Room> allRooms();

    Room eachRooms(int roomId);

    Room addRoom(Room room);

    Room updateRoom(int roomId, Room room);

    void deleteRoom(int roomId);

    Hotel getRoomHotel(int roomId);
}
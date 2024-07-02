package com.example.nxtstayz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

import com.example.nxtstayz.model.*;
import com.example.nxtstayz.service.*;

@RestController
public class RoomController {

    @Autowired
    private RoomJpaService RJS;

    @GetMapping("/hotels/rooms")
    public ArrayList<Room> allRooms() {
        return RJS.allRooms();
    }

    @GetMapping("/hotels/rooms/{roomId}")
    public Room eachRooms(@PathVariable("roomId") int roomId) {
        return RJS.eachRooms(roomId);
    }

    @PostMapping("/hotels/rooms")
    public Room addRoom(@RequestBody Room room) {
        return RJS.addRoom(room);
    }

    @PutMapping("/hotels/rooms/{roomId}")
    public Room updateRoom(@PathVariable("roomId") int roomId, @RequestBody Room room) {
        return RJS.updateRoom(roomId, room);
    }

    @DeleteMapping("/hotels/rooms/{roomId}")
    public void deleteRoom(@PathVariable("roomId") int roomId) {
        RJS.deleteRoom(roomId);
    }

    @GetMapping("/rooms/{roomId}/hotel")
    public Hotel getRoomHotel(@PathVariable("roomId") int roomId) {
        return RJS.getRoomHotel(roomId);
    }
}
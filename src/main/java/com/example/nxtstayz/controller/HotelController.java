package com.example.nxtstayz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.nxtstayz.model.*;
import com.example.nxtstayz.service.*;

@RestController
public class HotelController {

    @Autowired
    private HotelJpaService HJS;

    @GetMapping("/hotels")
    public ArrayList<Hotel> allHotels() {
        return HJS.allHotels();
    }

    @GetMapping("/hotels/{hotelId}")
    public Hotel eachHotels(@PathVariable("hotelId") int hotelId) {
        return HJS.eachHotels(hotelId);
    }

    @PostMapping("/hotels")
    public Hotel addHotel(@RequestBody Hotel hotel) {
        return HJS.addHotel(hotel);
    }

    @PutMapping("/hotels/{hotelId}")
    public Hotel updateHotel(@PathVariable("hotelId") int hotelId, @RequestBody Hotel hotel) {
        return HJS.updateHotel(hotelId, hotel);
    }

    @DeleteMapping("/hotels/{hotelId}")
    public void deleteHotel(@PathVariable("hotelId") int hotelId) {
        HJS.deleteHotel(hotelId);
    }

    @GetMapping("/hotels/{hotelId}/rooms")
    public List<Room> getHotelRooms(@PathVariable("hotelId") int hotelId) {
        return HJS.getHotelRooms(hotelId);
    }

}
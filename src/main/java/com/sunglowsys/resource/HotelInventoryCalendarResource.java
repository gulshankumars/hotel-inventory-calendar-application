package com.sunglowsys.resource;

import com.sunglowsys.domain.HotelInventoryCalendar;
import com.sunglowsys.service.HotelInventoryCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HotelInventoryCalendarResource {

    @Autowired
    private HotelInventoryCalendarService hotelInventoryCalendarService;

    @PostMapping("/hotel_inventory_calendar")
    public ResponseEntity<?> create(@RequestBody HotelInventoryCalendar hotelInventoryCalendar){
        HotelInventoryCalendar result = hotelInventoryCalendarService.create(hotelInventoryCalendar);
        return ResponseEntity.ok().body(" HotelInventoryCalendar is created successfully: " + result);
    }

    @GetMapping
    public List<HotelInventoryCalendar> getAll(){
        List<HotelInventoryCalendar> result1 = hotelInventoryCalendarService.findAll();
        return result1;
    }

    @GetMapping("find_hotel_inventory_calendar/{id}")
    public HotelInventoryCalendar getById(@PathVariable("id") Integer id){
        return hotelInventoryCalendarService.findById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody HotelInventoryCalendar hotelInventoryCalendar, @PathVariable("id") Integer id){
        hotelInventoryCalendarService.update(hotelInventoryCalendar, id);
        return ResponseEntity.ok().body(" HotelInventoryCalendar is updated successfully: " + id);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        hotelInventoryCalendarService.delete(id);
        return ResponseEntity.ok().body(" HotelInventoryCalendar is successfully Deleted on this ID: " + id);
    }
}

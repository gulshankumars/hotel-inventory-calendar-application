package com.sunglowsys.resource;

import com.sunglowsys.domain.HotelInventoryCalendar;
import com.sunglowsys.resource.util.BadRequestException;
import com.sunglowsys.service.HotelInventoryCalendarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HotelInventoryCalendarResource {

    private  final Logger log = LoggerFactory.getLogger(HotelInventoryCalendarResource.class);

    private final HotelInventoryCalendarService hotelInventoryCalendarService;

    public HotelInventoryCalendarResource(HotelInventoryCalendarService hotelInventoryCalendarService) {
        this.hotelInventoryCalendarService = hotelInventoryCalendarService;
    }

    @PostMapping("/hotel-inventory-calendars")
    public ResponseEntity<?> createHotelInventoryCalendars(@RequestBody HotelInventoryCalendar hotelInventoryCalendar) throws BadRequestException, URISyntaxException {
        log.debug("REST request to create HotelInventoryCalendars : {}", hotelInventoryCalendar);
        if (hotelInventoryCalendar.getId() != null){
            throw new BadRequestException("Id should be null in create api call");
        }
        HotelInventoryCalendar result = hotelInventoryCalendarService.create(hotelInventoryCalendar);
        return ResponseEntity
                .created(new URI("/api/HotelInventoryCalendars " +result.getId()))
                .body(result);
    }

    @GetMapping("/hotel-inventory-calendars")
    public ResponseEntity<List<HotelInventoryCalendar>> getAllHotelInventoryCalendars(@RequestBody Pageable pageable){
        log.debug("REST request to get HotelInventoryCalendar : {}", pageable.toString());
        Page<HotelInventoryCalendar> result = hotelInventoryCalendarService.findAll(pageable);
        return ResponseEntity
                .ok()
                .body(result.getContent());
    }

    @GetMapping("hotel-inventory-calendar/{id}")
    public ResponseEntity<HotelInventoryCalendar> getHotelInventoryCalendarById(@PathVariable("id") Long id){
        log.debug("REST request to get HotelInventoryCalendar : {}", id);
       Optional<HotelInventoryCalendar> result = hotelInventoryCalendarService.findById(id);
        return ResponseEntity
                .ok()
                .body(result.get());
    }

    @PutMapping("/hotel-inventory-calendar/{id}")
    public ResponseEntity<?> updateHotelInventoryCalendar(@RequestBody HotelInventoryCalendar hotelInventoryCalendar, @PathVariable("id") Long id) throws BadRequestException {
        log.debug("REST request to update HotelInventoryCalendar : {}", id);
        if (hotelInventoryCalendar.getId() == null){
            throw new BadRequestException("Id should not be null in update api call");
        }
        HotelInventoryCalendar result = hotelInventoryCalendarService.update(hotelInventoryCalendar, id);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @DeleteMapping("hotel-inventory-calendar/{id}")
    public ResponseEntity<?> deleteHotelInventoryCalendar(@PathVariable("id") Long id){
        log.debug("REST request to delete HotelInventoryCalendar : {}", id);
        hotelInventoryCalendarService.delete(id);
        return ResponseEntity.ok().body(id);
    }
}

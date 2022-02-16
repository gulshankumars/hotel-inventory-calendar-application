package com.sunglowsys.service;

import com.sunglowsys.domain.HotelInventoryCalendar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface HotelInventoryCalendarService {
    HotelInventoryCalendar create(HotelInventoryCalendar hotelInventoryCalendar);

    HotelInventoryCalendar update(HotelInventoryCalendar hotelInventoryCalendar, Long id);

    Page<HotelInventoryCalendar> findAll(Pageable pageable);

    Optional<HotelInventoryCalendar> findById(Long id);

    void delete(Long id);
}

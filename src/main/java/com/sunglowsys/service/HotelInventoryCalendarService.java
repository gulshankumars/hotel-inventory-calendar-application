package com.sunglowsys.service;

import com.sunglowsys.domain.HotelInventoryCalendar;

import java.util.List;

public interface HotelInventoryCalendarService {
    HotelInventoryCalendar create(HotelInventoryCalendar hotelInventoryCalendar);

    HotelInventoryCalendar update(HotelInventoryCalendar hotelInventoryCalendar, Integer id);

    List<HotelInventoryCalendar> findAll();

    HotelInventoryCalendar findById(Integer id);

    void delete(Integer id);
}

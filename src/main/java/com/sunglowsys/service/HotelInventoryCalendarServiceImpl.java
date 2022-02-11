package com.sunglowsys.service;

import com.sunglowsys.domain.HotelInventoryCalendar;
import com.sunglowsys.repository.HotelInventoryCalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelInventoryCalendarServiceImpl implements HotelInventoryCalendarService {

    @Autowired
    private HotelInventoryCalendarRepository hotelInventoryCalendarRepository;

    @Override
    public HotelInventoryCalendar create(HotelInventoryCalendar hotelInventoryCalendar) {
        return hotelInventoryCalendarRepository.save(hotelInventoryCalendar);
    }

    @Override
    public HotelInventoryCalendar update(HotelInventoryCalendar hotelInventoryCalendar, Integer id) {
        HotelInventoryCalendar hotelInventoryCalendar1 = hotelInventoryCalendarRepository.findById(id).get();
        hotelInventoryCalendar1.setAvailable(hotelInventoryCalendar1.getAvailable());
        hotelInventoryCalendar1.setSold(hotelInventoryCalendar1.getSold());
        hotelInventoryCalendar1.setBlock(hotelInventoryCalendar1.getBlock());
        return hotelInventoryCalendarRepository.save(hotelInventoryCalendar);
    }

    @Override
    public List<HotelInventoryCalendar> findAll() {
        return hotelInventoryCalendarRepository.findAll();
    }

    @Override
    public HotelInventoryCalendar findById(Integer id) {
        Optional<HotelInventoryCalendar> optional = hotelInventoryCalendarRepository.findById(id);
        HotelInventoryCalendar hotelInventoryCalendar = null;
        if (optional.isPresent()){
            hotelInventoryCalendar = optional.get();
        }
        else {
            throw new RuntimeException("Hotel-Inventory-Calendar not found for id:" +id);
        }
        return hotelInventoryCalendar;
    }

    @Override
    public void delete(Integer id) {
        hotelInventoryCalendarRepository.deleteById(id);
    }
}
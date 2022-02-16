package com.sunglowsys.service;

import com.sunglowsys.domain.HotelInventoryCalendar;
import com.sunglowsys.repository.HotelInventoryCalendarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class HotelInventoryCalendarServiceImpl implements HotelInventoryCalendarService {

    private final Logger log = LoggerFactory.getLogger(HotelInventoryCalendarServiceImpl.class);

    private final HotelInventoryCalendarRepository hotelInventoryCalendarRepository;

    public HotelInventoryCalendarServiceImpl(HotelInventoryCalendarRepository hotelInventoryCalendarRepository) {
        this.hotelInventoryCalendarRepository = hotelInventoryCalendarRepository;
    }

    @Override
    public HotelInventoryCalendar create(HotelInventoryCalendar hotelInventoryCalendar) {
        log.debug("Request to create HotelInventoryCalendar : {}", hotelInventoryCalendar);
        return hotelInventoryCalendarRepository.save(hotelInventoryCalendar);
    }

    @Override
    public HotelInventoryCalendar update(HotelInventoryCalendar hotelInventoryCalendar, Long id) {
        log.debug("Request to update HotelInventoryCalendar : {}", hotelInventoryCalendar);
        return hotelInventoryCalendarRepository.save(hotelInventoryCalendar);
    }

    @Override
    public Page<HotelInventoryCalendar> findAll(Pageable pageable) {
        log.debug("Request to getAll HotelInventoryCalendars : {}",pageable.toString());
        return hotelInventoryCalendarRepository.findAll(pageable);
    }

    @Override
    public Optional<HotelInventoryCalendar> findById(Long id) {
       log.debug("Request to get HotelInventoryCalendar : {}", id);
        return hotelInventoryCalendarRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete HotelInventoryCalendar : {}", id);
        hotelInventoryCalendarRepository.deleteById(id);
    }
}
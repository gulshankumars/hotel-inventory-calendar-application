package com.sunglowsys.repository;

import com.sunglowsys.domain.HotelInventoryCalendar;
import com.sunglowsys.service.HotelInventoryCalendarService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelInventoryCalendarRepository extends JpaRepository<HotelInventoryCalendar, Long > {


}

package com.sunglowsys.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "hotel_inventory_calendar")
public class HotelInventoryCalendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "Id")
    private Long id ;

    @Column(name = "Available")
    private Integer available ;

    @Column(name = "Sold")
    private Integer sold ;

    @Column(name = "Block")
    private Integer block ;

    public HotelInventoryCalendar(){
        System.out.println("HotelInventoryCalendar object is created :");
    }

    public HotelInventoryCalendar(Long id, Integer available, Integer sold, Integer block) {
        this.id = id;
        this.available = available;
        this.sold = sold;
        this.block = block;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public Integer getBlock() {
        return block;
    }

    public void setBlock(Integer block) {
        this.block = block;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelInventoryCalendar that = (HotelInventoryCalendar) o;
        return Objects.equals(id, that.id) && Objects.equals(available, that.available) && Objects.equals(sold, that.sold) && Objects.equals(block, that.block);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, available, sold, block);
    }

    @Override
    public String toString() {
        return "HotelInventoryCalendar{" +
                "id=" + id +
                ", available=" + available +
                ", sold=" + sold +
                ", block=" + block +
                '}';
    }
}

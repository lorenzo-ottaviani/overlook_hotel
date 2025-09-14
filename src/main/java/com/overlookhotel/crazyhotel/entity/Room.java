package com.overlookhotel.crazyhotel.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long id;

    @Column(name = "room_number", nullable = false)
    private int number;

    @Column(name = "floor_number", nullable = false)
    private int floor;

    @Column(name = "category", length = 50)
    private String category;

    @Column(name = "available", nullable = false)
    private boolean available;

    @ManyToMany(mappedBy = "rooms")
    private Set<Reservation> reservations;

    // Constructors
    public Room() {}

    public Room(int number, int floor, String category, boolean available) {
        this.number = number;
        this.floor = floor;
        this.category = category;
        this.available = available;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }
}

package com.Flight_ReservationApp1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Flight_ReservationApp1.Entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}

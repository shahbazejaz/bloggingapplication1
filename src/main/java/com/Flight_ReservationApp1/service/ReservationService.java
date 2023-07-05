package com.Flight_ReservationApp1.service;

import com.Flight_ReservationApp1.Entity.Reservation;
import com.Flight_ReservationApp1.dto.ReservationRequest;


public interface ReservationService {

	public Reservation bookFlight(ReservationRequest request);

}

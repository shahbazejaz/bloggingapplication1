package com.Flight_ReservationApp1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Flight_ReservationApp1.Entity.Flight;
import com.Flight_ReservationApp1.Entity.Passenger;
import com.Flight_ReservationApp1.Entity.Reservation;
import com.Flight_ReservationApp1.Repository.FlightRepository;
import com.Flight_ReservationApp1.Repository.PassengerRepository;
import com.Flight_ReservationApp1.Repository.ReservationRepository;
import com.Flight_ReservationApp1.dto.ReservationRequest;
import com.Flight_ReservationApp1.utilities.EmailUtil;
import com.Flight_ReservationApp1.utilities.PdfGenerator;
@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private PassengerRepository passengerRepo;
	
	@Autowired
	private FlightRepository flightRepo;
	
	@Autowired
	private ReservationRepository reservationRepo;
	
	@Autowired
	private PdfGenerator pdfGenerator;
	
	@Autowired
	private EmailUtil emailutil;

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		
		
		Passenger passenger=new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setLastName(request.getLastName());
		passenger.setMiddleName(request.getMiddleName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());
		passengerRepo.save(passenger);
		long flightId = request.getFlightId();
		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();
		
		Reservation reservation=new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(passenger);
		reservation.setCheckedIn(false);
		reservation.setNumberOfBags(0);
		String filePath="C:\\sts code\\FLIGHT_RESERVATION_APP_1\\Tickets\\reservation"+reservation.getId()+".pdf";
		reservationRepo.save(reservation);
		pdfGenerator.generateItinerary(reservation,filePath);
		emailutil.sendItinerary(passenger.getEmail(),filePath);
		return reservation;
	}

}

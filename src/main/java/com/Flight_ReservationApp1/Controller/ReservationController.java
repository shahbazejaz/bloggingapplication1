package com.Flight_ReservationApp1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Flight_ReservationApp1.Entity.Reservation;
import com.Flight_ReservationApp1.dto.ReservationRequest;
import com.Flight_ReservationApp1.service.ReservationService;


@Controller
public class ReservationController {
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping("/confirmReservation")
	public String confirmReservation(ReservationRequest request,ModelMap modelMap) {
		Reservation reservationId = reservationService.bookFlight(request);
		modelMap.addAttribute("reservationId", reservationId.getId());
		
		return "confirmReservation";
	}

}

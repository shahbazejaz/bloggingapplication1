package com.Flight_ReservationApp1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Flight_ReservationApp1.Entity.User;
import com.Flight_ReservationApp1.Repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepo;
	//localhost:8080/flight/ShowReg
	@RequestMapping("/ShowReg")
	public String showReg() {
		return "login/ShowReg";
	}
	@RequestMapping("/saveReg")
	public String saveReg(@ModelAttribute("user")User user) {
		userRepo.save(user);
		return "login/Login";
	}	
	@RequestMapping("/showLogInPage")
		public String showLogInPage() {
			return "login/Login";
		}
	@RequestMapping("/verifyLogin")
	public String verifyLogin(@RequestParam("emailId") String emailId ,@RequestParam("password")String password,ModelMap modelmap ){
		User user=userRepo.findByEmail(emailId);
		if(user!=null) {
		if(user.getEmail().equals(emailId)&& user.getPassword().equals(password)) {
			return "findFlights";
		}else {
			modelmap.addAttribute("error","invalid username/password!!");
			return "login/Login";
		}
		
	}else {
		modelmap.addAttribute("error","invalid username/password!!");
		return "login/Login";
	}
		
	}
}



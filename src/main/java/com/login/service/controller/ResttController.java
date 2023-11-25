package com.login.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.login.service.entity.User;
import com.login.service.payload.RegistrationRequest;


@RestController
public class ResttController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping("/registerUser")
	public String register(@RequestBody User user) {
		
		//RestTemplate restTemplate= new RestTemplate();
		
		String employeeUrlString= "http://localhost:7777/employeePage";
		String adminUrlString= "http://localhost:9999/adminHome";
		String loginUrlString="http://localhost:8888/";
		
		String user_name="mac";
		String user_password="mac";
		String admin_name="apple";
		String admin_password="apple";
		
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getUserLevel());
		
		if(user.getUserLevel().equals("Admin")) {
			if(user.getUsername().equals(admin_name) && user.getPassword().equals(admin_password)) {
				System.out.println("adminsss");
			return restTemplate.getForObject(adminUrlString, String.class);
				//return adminString.getBody();
				//return "adminHome";
			}
		}else {
			if(user.getUserLevel().equals("Employee")) {
				if(user.getUsername().equals(user_name) && user.getPassword().equals(user_password)) {
					System.out.println("new employeezzz");
					//return "employeePage";
					return restTemplate.getForObject(employeeUrlString, String.class);
					//return employeeString.getBody();
				}
			}
		}
		//return "index";
		return restTemplate.getForObject(loginUrlString, String.class);
		// return loginString.getBody();
	}
	
	@GetMapping("/employeeHome")
	public String employeeHome() {
		System.out.println("kheerr");
		return "employeePage";
	}
	
	@GetMapping("/behaviour")
	public String behaviouralAssessmentForm() {
		return "behavioural-test";
	}
	
	@PostMapping("/behaviour")
	public String behaviourTestReg(@RequestBody RegistrationRequest registrationRequest, Model model) {
		if(registrationRequest.isValid() &&registrationRequest !=null) {
	model.addAttribute("message", "registration successful");
	System.out.println("registered for behaviour test");
	return "success";
	
		}else {
			return "behavioural-test";
		}
	}
	

	
	@GetMapping("/registrations")
	public List<RegistrationRequest>  showRegistrations(@ModelAttribute("employee") RegistrationRequest registrationRequest) {
	List<RegistrationRequest> registrationRequests=	RegistrationRequest.registrations();
		return registrationRequests;
	}

}


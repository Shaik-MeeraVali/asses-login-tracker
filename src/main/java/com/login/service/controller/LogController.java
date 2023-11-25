package com.login.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.login.service.entity.User;
import com.login.service.payload.RegistrationRequest;



@Controller
//@RequestMapping("/login")
public class LogController {
	
	@Autowired
	RestTemplate restTemplate;
	String baseurlString="http://localhost:8888/";
	
	//@PostMapping("/register")
//	public String registerUser( User user) {
//		String urlString=baseurlString+"registerUser";
//		
//		ResponseEntity<String> pageString=restTemplate.postForEntity(urlString, user, String.class);
//		System.out.println("enter registry");
//		return pageString.getBody();
//		}
	@PostMapping("/register")
	@ResponseBody
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
		 ResponseEntity<String> adminString= restTemplate.getForEntity(adminUrlString, String.class);
				return adminString.getBody();
				//return "adminHome";
			}
		}else {
			if(user.getUserLevel().equals("Employee")) {
				if(user.getUsername().equals(user_name) && user.getPassword().equals(user_password)) {
					System.out.println("new employeezzz");
					//return "employeePage";
					ResponseEntity<String> employeeString= restTemplate.getForEntity(employeeUrlString, String.class);
					return employeeString.getBody();
				}
			}
		}
		//return "index";
		ResponseEntity<String> loginString= restTemplate.getForEntity(loginUrlString, String.class);
		return loginString.getBody();
	}
	

	@GetMapping("/employeeView")
	public String employeeView() {
		String urlString=baseurlString + "employeeHome";
		ResponseEntity<String> behaviourPage=restTemplate.getForEntity(urlString, String.class);
		return behaviourPage.getBody();
	}
	
	

	
	@GetMapping("/behavioural-test")
	public String behaviouralAssesmentPage() {
		String urlString=baseurlString + "behaviour";
		ResponseEntity<String> behaviourPage=restTemplate.getForEntity(urlString, String.class);
		return behaviourPage.getBody();
	}
	
	@PostMapping("/behavioural-test")
	public String behaviouralAssesmentReg(RegistrationRequest registrationRequest) {
		String urlString=baseurlString + "behaviour";
		ResponseEntity<String> behaviourPage=restTemplate.postForEntity(urlString, registrationRequest, String.class);
		return behaviourPage.getBody();
	}
	
	@GetMapping("/adminDataPage")
	public String getAllRegistrations(Model model) {
		String urlString=baseurlString+"registrations";
		
		ResponseEntity<String> dataPage=restTemplate.getForEntity(urlString, String.class);
		System.out.println(dataPage.getBody());
		model.addAttribute("adminDataPage", dataPage.getBody());
		return "adminDataPage";
	}
	
}

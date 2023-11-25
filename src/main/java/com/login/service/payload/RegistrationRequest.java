package com.login.service.payload;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {
	
	public String userId;
	public String assessment;
	public String date;

	public boolean isValid() {
	return	userId!= null && !userId.isEmpty() && 
				assessment !=null && !assessment.isEmpty() &&
				date!= null && !date.isEmpty();
	
	}
	@ModelAttribute("employee")
	public static List<RegistrationRequest> registrations(){
		List<RegistrationRequest> arr=new ArrayList<>();
		
		arr.add(new RegistrationRequest("1111", "Java", "10-10-2023"));
		arr.add(new RegistrationRequest("1112", "Python", "12-12-2023"));
		arr.add(new RegistrationRequest("1113","SQL", "13-11-2023"));
				
				return arr;
	}
	
//	RegistrationRequest registrationRequest= 
//			new RegistrationRequest("1111", "Java", "10-10-2023");
}

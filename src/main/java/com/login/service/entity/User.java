package com.login.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
	
	
	private String username;
	
	private String password;
	
	private String userLevel;
	
	
	

}

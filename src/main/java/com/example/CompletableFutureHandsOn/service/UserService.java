package com.example.CompletableFutureHandsOn.service;

import com.example.CompletableFutureHandsOn.dto.User;

public class UserService {
	
	public User getUserDetails(long userId) {
		if(userId == 1L) {
			return new User(1L,"Om","Mhatre");
		}
		if(userId == 2L) {
			return new User(2L,"Arnav","Mhatre");
		}
		if(userId == 3L) {
			return new User(3L,"Jack","Mhatre");
		}
		return new User();
	}
	
	public Double getCreditRating(User user) {
		if(user!=null) {
			if(user.getId()==1L || user.getId()==1L || user.getId()==1L) {
				return 456.90;
			}
		}
		return 0.00;
	}
	
	
}

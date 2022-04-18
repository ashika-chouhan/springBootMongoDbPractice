package com.springBootMongoDb.boot.mongo;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.springBootMongoDb.boot.mongo.repository.EmployeeRepository;
import com.springBootMongoDb.boot.mongo.repository.UsersRepository;

import service.CustomUserDetailsService;

@ExtendWith(MockitoExtension.class)
public class UserTest {
	
	@Mock private EmployeeRepository employeeRepository;
	@Mock private UsersRepository userRepo;
	
	@InjectMocks
	private CustomUserDetailsService customUserDetailsService;
	
	@Test
	void BasicTest2() {
		customUserDetailsService.loadUserByUsername("");
		
		//
		
		List<Users> list = new ArrayList<>();
		list.add(new Users("1", "ashika","ashika@gmail.com", "123"));
		list.add(new Users("2", "rohit","rohit@gmail.com", "123"));
		list.add(new Users("3", "rishi","rishi@gmail.com", "123"));
	
		when(userRepo.findByUsername("ashika")).thenReturn(new Users("1", "ashika","ashika@gmail.com", "123"));
		when(userRepo.findAll()).thenReturn(list);
		
		verify(userRepo).findAll();
	}

}

package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TestRepository;
import com.example.demo.model.RequestOrder;

@Service
public class TestService {

	@Autowired
	private TestRepository testRepository;

	public void addGreeting(RequestOrder request) {
		testRepository.save(request);
	}

	public String getGreeting(int id) {
		Optional<RequestOrder> request = testRepository.findById(id);
		String name = request.get().getName();
		return name;
	}

}

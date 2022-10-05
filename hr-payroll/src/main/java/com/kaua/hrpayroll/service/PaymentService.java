package com.kaua.hrpayroll.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kaua.hrpayroll.dto.WorkerResponse;
import com.kaua.hrpayroll.model.Payment;

@Service
public class PaymentService {

	@Value("${hr-worker.host}")
	private String workerHost;

	@Autowired
	private RestTemplate restTemplate;

	public Payment findPayment(Long workerId, Integer days) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", "" + workerId);

		WorkerResponse worker = restTemplate.getForObject(workerHost + "/worker/{id}", WorkerResponse.class,
				uriVariables);
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}

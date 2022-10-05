package com.kaua.hrpayroll.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaua.hrpayroll.model.Payment;
import com.kaua.hrpayroll.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentResource {

	@Autowired
	PaymentService service;
	
	@GetMapping("/{workerId}/days/{days}")
	public ResponseEntity<Payment> findPayment(@PathVariable Long workerId, @PathVariable Integer days) {
		return new ResponseEntity<>(service.findPayment(workerId, days), HttpStatus.OK);
	}
}

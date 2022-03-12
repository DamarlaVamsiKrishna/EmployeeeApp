package com.thoughtfocus.employee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtfocus.employee.dto.DetailsDTO;
import com.thoughtfocus.employee.exception.NullObjectRegisterException;
import com.thoughtfocus.employee.service.RegistrationService;


@RestController
public class RegisterController {

	static Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	RegistrationService registrationService;

	@PostMapping("/register")
	String register(@RequestBody DetailsDTO dto) {
		String saveStatus = null;
		try {
			if (dto != null) {
				saveStatus = registrationService.saveUser(dto);
			} else {
				logger.info("Details can't be null");
				throw new NullObjectRegisterException("Details can't be null");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		return saveStatus;
	}
}

package com.thoughtfocus.employee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtfocus.employee.dto.UpdateDOBDTO;
import com.thoughtfocus.employee.dto.UpdateDobByNameDTO;
import com.thoughtfocus.employee.entity.DetailsEntity;
import com.thoughtfocus.employee.exception.NullEmailAndPasswordException;
import com.thoughtfocus.employee.service.UpdateDobService;


@RestController
public class UpdateDobController {
	static Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	UpdateDobService updateDobService;

	@PostMapping("/update/dob")
	DetailsEntity updateDOB(@RequestBody UpdateDOBDTO dto) {
		DetailsEntity detailsEntity = null;
		try {
			if (dto.getEmail() != "") {
				detailsEntity = updateDobService.updateDobOfUser(dto);
			} else {
				throw new NullEmailAndPasswordException("Enter valid email");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return detailsEntity;
	}

	@PostMapping("updatedob/name")
	DetailsEntity updateDobByName(@RequestBody UpdateDobByNameDTO dto) {
		DetailsEntity detailsEntity = null;
		try {
			detailsEntity = updateDobService.updateDobOfUserByName(dto);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return detailsEntity;

	}
}

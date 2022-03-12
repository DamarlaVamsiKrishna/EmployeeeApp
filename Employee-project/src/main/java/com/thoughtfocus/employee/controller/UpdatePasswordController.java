package com.thoughtfocus.employee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtfocus.employee.dto.UpdatePasswordDTO;
import com.thoughtfocus.employee.entity.DetailsEntity;
import com.thoughtfocus.employee.exception.NullEmailAndPasswordException;
import com.thoughtfocus.employee.service.UpdatePasswordService;


@RestController
public class UpdatePasswordController {

	static Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	UpdatePasswordService updatePasswordService;

	@PostMapping("/update/password")
	DetailsEntity updatePassword(@RequestBody UpdatePasswordDTO dto) {
		DetailsEntity detailsEntity = null;

		try {
			if (dto.getPassword() != null && dto.getPassword() != "") {
				detailsEntity = updatePasswordService.UpdatePasswordByEmail(dto);

			} else {
				throw new NullEmailAndPasswordException("Password cant be null");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return detailsEntity;
	}
}

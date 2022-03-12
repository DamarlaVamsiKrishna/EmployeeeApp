package com.thoughtfocus.employee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtfocus.employee.dto.GenderContactDTO;
import com.thoughtfocus.employee.entity.DetailsEntity;
import com.thoughtfocus.employee.service.UpdateGenderService;


@RestController
public class UpdateGenderController {

	static Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	UpdateGenderService updateGenderService;

	@PostMapping("update/gender")
	DetailsEntity updateGender(@RequestBody GenderContactDTO dto) {
		DetailsEntity detailsEntity = null;
		try {
			detailsEntity = updateGenderService.updateGenderByContact(dto);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		return detailsEntity;
	}
}

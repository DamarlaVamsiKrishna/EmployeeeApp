package com.thoughtfocus.employee.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtfocus.employee.controller.RegisterController;
import com.thoughtfocus.employee.dto.GenderContactDTO;
import com.thoughtfocus.employee.entity.DetailsEntity;
import com.thoughtfocus.employee.exception.InvalidDetailsException;
import com.thoughtfocus.employee.repository.DetailsRepository;


@Service
public class UpdateGenderServiceImpl implements UpdateGenderService {

	static Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	DetailsRepository repository;

	@Override
	public DetailsEntity updateGenderByContact(GenderContactDTO dto) {
		try {
			DetailsEntity detailsEntity = repository.getByContact(dto.getContact());
			if (detailsEntity != null && dto.getGender() != "" && dto.getContact() > 99999) {
				detailsEntity.setGender(dto.getGender());
				repository.save(detailsEntity);
				return detailsEntity;
			} else {
				throw new InvalidDetailsException("enter valid details");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}

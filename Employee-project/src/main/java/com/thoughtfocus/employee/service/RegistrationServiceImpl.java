package com.thoughtfocus.employee.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtfocus.employee.controller.RegisterController;
import com.thoughtfocus.employee.dto.DetailsDTO;
import com.thoughtfocus.employee.entity.DetailsEntity;
import com.thoughtfocus.employee.exception.NullEmailAndPasswordException;
import com.thoughtfocus.employee.repository.DetailsRepository;



@Service
public class RegistrationServiceImpl implements RegistrationService {

	static Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	DetailsRepository repository;

	@Override
	public String saveUser(DetailsDTO dto) {
		try {
			if (dto.getEmail() != "" && dto.getPassword() != "" && dto.getEmail() != null) {
				DetailsEntity detailsEntity = new DetailsEntity();
				BeanUtils.copyProperties(dto, detailsEntity);
				repository.save(detailsEntity);
				return "your registration is successfull";
			} else {
				// logger.info("Email or password is mandatory");
				throw new NullEmailAndPasswordException("Email or password is mandatory");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		return "Registration failed";
	}

}

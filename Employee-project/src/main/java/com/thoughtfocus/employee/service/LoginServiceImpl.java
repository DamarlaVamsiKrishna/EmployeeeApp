package com.thoughtfocus.employee.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtfocus.employee.controller.RegisterController;
import com.thoughtfocus.employee.entity.DetailsEntity;
import com.thoughtfocus.employee.exception.InvalidLengthException;
import com.thoughtfocus.employee.exception.UnknownUserException;
import com.thoughtfocus.employee.repository.DetailsRepository;


@Service
public class LoginServiceImpl implements LoginService {

	static Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	DetailsRepository repository;

	@Override
	public DetailsEntity loginUser(String email, String password) {
		DetailsEntity detailsEntity;
		detailsEntity = repository.getByEmailAndPassword(email, password);
		try {
			if (detailsEntity != null) {
				if (detailsEntity.getEmail().equals(email) && detailsEntity.getPassword().equals(password)) {
					if (email.length() < 20 && email.length() > 6) {
						return detailsEntity;
					} else {
						throw new InvalidLengthException("Email length range should be b/w 6-15");
					}
				}
			} else {
				throw new UnknownUserException("Incorrect details");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
}

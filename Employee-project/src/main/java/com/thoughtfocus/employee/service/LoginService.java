package com.thoughtfocus.employee.service;

import com.thoughtfocus.employee.entity.DetailsEntity;

public interface LoginService {
	public DetailsEntity loginUser(String email, String password);
}

package com.thoughtfocus.employee.service;

import com.thoughtfocus.employee.dto.GenderContactDTO;
import com.thoughtfocus.employee.entity.DetailsEntity;

public interface UpdateGenderService {
	public DetailsEntity updateGenderByContact(GenderContactDTO dto);
}

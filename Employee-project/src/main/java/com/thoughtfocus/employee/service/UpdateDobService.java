package com.thoughtfocus.employee.service;

import com.thoughtfocus.employee.dto.UpdateDOBDTO;
import com.thoughtfocus.employee.dto.UpdateDobByNameDTO;
import com.thoughtfocus.employee.entity.DetailsEntity;

public interface UpdateDobService {
	public DetailsEntity updateDobOfUser(UpdateDOBDTO dto);

	public DetailsEntity updateDobOfUserByName(UpdateDobByNameDTO dto);
}

package com.thoughtfocus.employee.service;

import com.thoughtfocus.employee.dto.UpdatePasswordDTO;
import com.thoughtfocus.employee.entity.DetailsEntity;

public interface UpdatePasswordService {
	public DetailsEntity UpdatePasswordByEmail(UpdatePasswordDTO dto);
}

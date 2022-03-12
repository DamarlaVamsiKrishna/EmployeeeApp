package com.thoughtfocus.employee.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UpdatePasswordDTO {
	private String email;
	private String password;
}

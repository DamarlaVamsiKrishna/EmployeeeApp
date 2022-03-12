package com.thoughtfocus.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thoughtfocus.employee.entity.DetailsEntity;


public interface DetailsRepository extends JpaRepository<DetailsEntity, Integer> {
	public DetailsEntity getByEmail(String email);

	public DetailsEntity getByFirstName(String firstName);

	public DetailsEntity getByContact(long contact);

	public DetailsEntity getByEmailAndPassword(String email, String password);
}

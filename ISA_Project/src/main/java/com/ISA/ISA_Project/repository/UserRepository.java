package com.ISA.ISA_Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ISA.ISA_Project.domain.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	User findOneByEmail(String email);
	User findByConfirmationtoken(String confirmationToken);
	User findOneById(Long id);
}

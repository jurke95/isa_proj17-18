package com.ISA.ISA_Project.repository;

import com.ISA.ISA_Project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}

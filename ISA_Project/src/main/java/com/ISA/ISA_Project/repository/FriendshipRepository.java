package com.ISA.ISA_Project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ISA.ISA_Project.domain.Friendship;

@Repository
public interface FriendshipRepository  extends JpaRepository<Friendship,Long> {

Friendship findByIdEquals(Long id);
	
	List<Friendship> findByFirstfriend_idEquals(Long id);
	
	List<Friendship> findBySecondfriend_idEquals(Long id);
	
	
}

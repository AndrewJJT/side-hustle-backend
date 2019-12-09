package com.sidehustle.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sidehustle.beans.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	

}

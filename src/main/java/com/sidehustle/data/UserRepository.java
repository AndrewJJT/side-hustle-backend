package com.sidehustle.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sidehustle.beans.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findByUusernameAndUpassword(String uusername, String upassword);

}

package com.nt.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nt.entity.User;

public interface UserRepo extends CrudRepository<User, String> {
	@Query("SELECT COUNT(*) FROM User WHERE username=:un and password=:pwd")
	public int authenticate(@Param("un")  String username,@Param("pwd") String password);
}

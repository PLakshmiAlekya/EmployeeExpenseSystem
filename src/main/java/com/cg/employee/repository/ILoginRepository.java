package com.cg.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.employee.entity.LoginDetails;

public interface ILoginRepository extends JpaRepository<LoginDetails, Integer>{
	@Query(value = "select password from login_details where id=:id", nativeQuery = true)
	String checkpassword(@Param("id") int id);

	@Query(value = "select user_name from login_details where id=:id", nativeQuery = true)
	String checkusername(@Param("id") int id);

	@Query(value = "select id from login_details where user_name=:userName", nativeQuery = true)
	Integer userexist(@Param("userName") String userName);


}
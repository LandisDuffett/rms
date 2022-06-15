package com.reimburse.rms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reimburse.rms.entity.UserEntity;
import com.reimburse.rms.pojo.UserPojo;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer> {

	Optional<UserEntity> findByUserEmailAndUserPassword(String email, String password);
}
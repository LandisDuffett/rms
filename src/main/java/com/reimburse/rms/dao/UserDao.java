package com.reimburse.rms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reimburse.rms.entity.UserEntity;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer> {

}
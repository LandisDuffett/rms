package com.reimburse.rms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reimburse.rms.entity.RequestEntity;

@Repository
public interface RequestDao extends JpaRepository<RequestEntity, Integer> {

	List<RequestEntity> findByRequestUserId(int uid);
}


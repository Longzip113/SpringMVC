package com.longnguyen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.longnguyen.entity.NewEntity;

// JpaRepository<NewEntity, {Thoc tinh khoa chinh}>
public interface NewRepository extends JpaRepository<NewEntity, Long>{

}

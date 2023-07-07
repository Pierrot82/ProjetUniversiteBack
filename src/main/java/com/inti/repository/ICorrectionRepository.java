package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.model.Correction;

public interface ICorrectionRepository extends JpaRepository<Correction, Integer>{

}

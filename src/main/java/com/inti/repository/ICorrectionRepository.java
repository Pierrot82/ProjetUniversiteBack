package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Correction;

@Repository
public interface ICorrectionRepository extends JpaRepository<Correction, Integer>{

}

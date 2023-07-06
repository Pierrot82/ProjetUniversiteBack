package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inti.model.Administrateur;
import com.inti.model.Formation;

import lombok.Value;


@Repository
public interface IFormationRepository extends JpaRepository<Formation, Integer>{
	


}

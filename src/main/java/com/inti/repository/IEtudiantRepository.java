package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inti.model.Etudiant;

import lombok.Value;


@Repository
public interface IEtudiantRepository extends JpaRepository<Etudiant, Integer>{
	


}
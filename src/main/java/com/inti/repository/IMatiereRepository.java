package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Matiere;

@Repository
public interface IMatiereRepository extends JpaRepository<Matiere, Integer>{

}

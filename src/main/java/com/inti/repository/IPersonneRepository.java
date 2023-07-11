package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Enseignant;
import com.inti.model.Personne;

@Repository
public interface IPersonneRepository extends JpaRepository<Personne, Integer>{

}

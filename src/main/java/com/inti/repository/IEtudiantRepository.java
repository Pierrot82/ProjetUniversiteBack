package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inti.model.Enseignant;
import com.inti.model.Etudiant;

import lombok.Value;


@Repository
public interface IEtudiantRepository extends JpaRepository<Etudiant, Integer>{
	
	
	@Query(value = "select id from etudiant where login = :login AND mdp = :mdp ", nativeQuery = true)
	int loginEtudiant(@Param("login") String login, @Param("mdp") String mdp);
	

}

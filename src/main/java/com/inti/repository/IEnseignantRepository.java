package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inti.model.Enseignant;
import com.inti.model.Reponse;

@Repository
public interface IEnseignantRepository extends JpaRepository<Enseignant, Integer>{

	
	
	@Query(value = "select id from enseignant where login = :login AND mdp = :mdp ", nativeQuery = true)
	int loginEnseignant(@Param("login") String login, @Param("mdp") String mdp);
	
	
	
	
	@Query(value = "select * from enseignant e, personne p where e.id=p.id AND e.email = :email ", nativeQuery = true)
	Enseignant getEnseignantByEmail(@Param("email") String email);
	
	
}

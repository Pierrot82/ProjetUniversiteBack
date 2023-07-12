package com.inti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inti.model.Discussion;
import com.inti.model.Reponse;

@Repository
public interface IDiscussionRepository extends JpaRepository<Discussion, Integer>{

	@Query(value = "select * from discussion where id_etudiant = :id OR id_destinataire = :id OR "
			+ "(id_destinataire is null AND (select id from enseignant where id= :id) is not null);", nativeQuery = true)
	List<Discussion> findAllById1(@Param("id") int idDiscussion);

	
	

}

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

	@Query(value = "select d.* from discussion d where d.id_etudiant = :id OR d.id_destinataire = :id OR "
			+ " (d.id_destinataire is null AND (select id from enseignant where id= :id) is not null) "
			+ " ORDER BY GREATEST(COALESCE((SELECT MAX(r.date_time) FROM reponse r WHERE r.id_discussion = d.id_discussion ), '0000-00-00'), "
			+ " COALESCE(d.date_time, '0000-00-00')) DESC;", nativeQuery = true)
	List<Discussion> findAllById1(@Param("id") int idDiscussion);

	
	

}

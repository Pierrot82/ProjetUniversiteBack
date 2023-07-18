package com.inti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inti.model.Discussion;
import com.inti.model.Reponse;

public interface IReponseRepository extends JpaRepository<Reponse, Integer>{

	
//	@Query(value = "select r.* from role r, salarie s, salarie_role sr"
//			+ " where s.id = sr.id_salarie and r.id = sr.id_role and s.id = :id", nativeQuery = true)
//	List<Role> findAllByIdSalarie(@Param("id") int idSalarie);

	
	@Query(value = "select * from reponse where id_discussion = :id ", nativeQuery = true)
	List<Reponse> findAllByIdDiscussion(@Param("id") int idDiscussion);
	
	
	@Query(value = "select * from reponse where id_discussion = :id AND date_time = (select (max(date_time)) FROM reponse WHERE id_discussion = :id )", nativeQuery = true)
	Reponse findLastReponseByIdDiscussion(@Param("id") int idDiscussion);
	
	
	
	@Query(value = "select d.* from discussion d where d.id_etudiant = :id OR d.id_destinataire = :id OR "
			+ " (d.id_destinataire is null AND (select id from enseignant where id= :id) is not null) "
			+ " ORDER BY GREATEST(COALESCE((SELECT MAX(r.date_time) FROM reponse r WHERE r.id_discussion = d.id_discussion ), '0000-00-00'), "
			+ " COALESCE(d.date_time, '0000-00-00')) DESC;", nativeQuery = true)
	List<Discussion> findAllLastReponseByIdDiscussion(@Param("id") int idDiscussion);

	
	
	
	
	
	
	
	
	
}

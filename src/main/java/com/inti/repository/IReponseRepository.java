package com.inti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inti.model.Reponse;

public interface IReponseRepository extends JpaRepository<Reponse, Integer>{

	
//	@Query(value = "select r.* from role r, salarie s, salarie_role sr"
//			+ " where s.id = sr.id_salarie and r.id = sr.id_role and s.id = :id", nativeQuery = true)
//	List<Role> findAllByIdSalarie(@Param("id") int idSalarie);

	
	@Query(value = "select * from reponse where id_discussion = :id ", nativeQuery = true)
	List<Reponse> findAllByIdDiscussion(@Param("id") int idDiscussion);
	
	
	@Query(value = "select * from reponse where id_discussion = :id AND date_time = (select (max(date_time)) FROM reponse WHERE id_discussion = :id )", nativeQuery = true)
	Reponse findLastReponseByIdDiscussion(@Param("id") int idDiscussion);
	
}

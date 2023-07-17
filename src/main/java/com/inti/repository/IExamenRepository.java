package com.inti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inti.model.Examen;

@Repository
public interface IExamenRepository extends JpaRepository<Examen, Integer>{

	// ils marchent pas :(
	
	@Query(value = "select e.* from examen e, copie c where c.id != :id AND e.id_examen = c.id_examen "
			+ "AND e.id_matiere IN (select id_matiere from enseignant ens where ens.id "
			+ "IN ( select e_e.id_enseignant from etu_enseignant e_e where e_e.id_enseignant = ens.id AND e_e.id_etudiant = :id))", nativeQuery = true)
	List<Examen> listeExamenRestantByEtudiant(@Param("id") int id);
	
	@Query(value = "select e.* from examen e, copie c where c.id = :id AND e.id_examen = c.id_examen "
			+ "AND e.id_matiere IN (select id_matiere from enseignant ens where ens.id "
			+ "IN ( select e_e.id_enseignant from etu_enseignant e_e where e_e.id_enseignant = ens.id AND e_e.id_etudiant = :id))", nativeQuery = true)
	List<Examen> listeExamenEffectueByEtudiant(@Param("id") int id);
	
	
}

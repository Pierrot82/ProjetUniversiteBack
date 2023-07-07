package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.inti.model.Postulant;

@Repository
public interface IPostulantRepository extends JpaRepository<Postulant, Integer>{
	


}

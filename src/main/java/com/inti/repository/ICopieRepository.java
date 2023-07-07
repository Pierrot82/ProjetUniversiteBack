package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inti.model.Administrateur;
import com.inti.model.Copie;
import com.inti.model.CopieCompositeKey;

import lombok.Value;


@Repository
public interface ICopieRepository extends JpaRepository<Copie, CopieCompositeKey>{
	


}

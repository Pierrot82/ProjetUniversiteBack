package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Examen;

@Repository
public interface IExamenRepository extends JpaRepository<Examen, Integer>{



}

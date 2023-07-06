package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.model.Cours;

public interface ICoursRepository extends JpaRepository<Cours, Integer>{

}

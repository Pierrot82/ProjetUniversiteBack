package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.SupportCours;

@Repository
public interface ISupportCoursRepository extends JpaRepository<SupportCours, Integer>{

}

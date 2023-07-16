package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Correction;
import com.inti.model.QcmProposition;

@Repository
public interface IQcmPropositionRepository extends JpaRepository<QcmProposition, Integer>{

}

package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Correction;
import com.inti.model.QcmQuestion;

@Repository
public interface IQcmQuestionRepository extends JpaRepository<QcmQuestion, Integer>{

}

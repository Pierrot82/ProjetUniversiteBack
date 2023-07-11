package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.model.Discussion;

public interface IDiscussionRepository extends JpaRepository<Discussion, Integer>{

}

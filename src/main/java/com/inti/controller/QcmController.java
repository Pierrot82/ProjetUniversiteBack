package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.Reponse;
import com.inti.model.Etudiant;
import com.inti.model.Examen;
import com.inti.model.QcmProposition;
import com.inti.model.QcmQuestion;
import com.inti.repository.IQcmPropositionRepository;
import com.inti.repository.IQcmQuestionRepository;
import com.inti.repository.IReponseRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class QcmController {
	
	@Autowired
	IQcmPropositionRepository iqpr;
	
	@Autowired
	IQcmQuestionRepository iqqr;
	
	// à rajouter dans le répository
	@GetMapping("listeQuestionByIdExam")
	public List<QcmQuestion> listeQuestionByIdExam() {
		return iqqr.findAll();
	}
	// à rajouter dans le répository
	@GetMapping("listePropositionByIdQuestion")
	public List<QcmProposition> listePropositionByIdQuestion() {
		return iqpr.findAll();
	}
	
	@GetMapping("getQcmProposition/{id}")
	public QcmProposition getQcmProposition(@PathVariable("id") int id) {
		return iqpr.getReferenceById(id);
	}
	@GetMapping("getQcmQuestion/{id}")
	public QcmQuestion getQcmQuestion(@PathVariable("id") int id) {
		return iqqr.getReferenceById(id);
	}
	
	@PostMapping("saveQcmQuestion")
	public QcmQuestion saveQcmQuestion(@RequestBody QcmQuestion qq) {
	    return iqqr.save(qq);
	}
	@PostMapping("saveQcmProposition")
	public QcmProposition saveQcmProposition(@RequestBody QcmProposition qp) {
	    return iqpr.save(qp);
	}
	
	
//	@GetMapping("getReponsesDiscussion/{id}")
//	public List<Reponse> getReponsesDiscussion(@PathVariable("id") int id)
//	{
//		return ienr.findAllByIdDiscussion(id);
//	}
	
	
    }
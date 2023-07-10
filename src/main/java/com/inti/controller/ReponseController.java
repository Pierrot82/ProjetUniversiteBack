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
import com.inti.repository.IReponseRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ReponseController {
	
	@Autowired
	IReponseRepository ienr;
	
	
	@GetMapping("listeReponse")
	public List<Reponse> listeReponse() {
		return ienr.findAll();
	}

	@GetMapping("getReponse/{id}")
	public Reponse getReponse(@PathVariable("id") int id)
	{
		return ienr.getReferenceById(id);
	}
	
	@PostMapping("saveReponse")
	public Reponse saveReponse(@RequestBody Reponse r) {
	    return ienr.save(r);
	}

	@PutMapping("modifierReponse")
	public boolean modifienrReponse(@RequestBody Reponse r) {
	    Reponse existingReponse = ienr.getReferenceById(r.getIdReponse());
	    if (existingReponse != null) {
//	        en.setId(id);
	        ienr.save(r);
	        return true;
	    }
	    return false;
	}
	

	
	
	
	@DeleteMapping("deleteReponse/{id}")
	public boolean deleteReponse(@PathVariable("id") int id) {
	    Reponse r = ienr.getReferenceById(id);
	    if (r != null) {
	        ienr.delete(r);
	        return true;
	    }
	    return false;
	}
	

	
	@GetMapping("getReponsesDiscussion/{id}")
	public List<Reponse> getReponsesDiscussion(@PathVariable("id") int id)
	{
		return ienr.findAllByIdDiscussion(id);
	}
	
	
	
	
    }
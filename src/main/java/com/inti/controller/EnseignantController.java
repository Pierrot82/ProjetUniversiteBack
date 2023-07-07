package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.Enseignant;
import com.inti.model.Etudiant;
import com.inti.model.Examen;
import com.inti.repository.IEnseignantRepository;

@RestController
public class EnseignantController {
	
	@Autowired
	IEnseignantRepository ienr;
	
	
	@GetMapping("listeEnseignant")
	public List<Enseignant> listeEnseignant() {
		return ienr.findAll();
	}

	@GetMapping("getEnseignant/{id}")
	public Enseignant getEnseignant(@PathVariable("id") int id)
	{
		return ienr.getReferenceById(id);
	}
	
	@PostMapping("saveEnseignant")
	public Enseignant saveEnseignant(@RequestBody Enseignant en) {
	    return ienr.save(en);
	}

	@PutMapping("modifierEnseignant")
	public boolean modifienrEnseignant(@PathVariable("id") int id, @RequestBody Enseignant en) {
	    Enseignant existingEnseignant = ienr.getReferenceById(id);
	    if (existingEnseignant != null) {
	        en.setId(id);
	        ienr.save(en);
	        return true;
	    }
	    return false;
	}
	
	@DeleteMapping("deleteEnseignant/{id}")
	public boolean deleteEnseignant(@PathVariable("id") int id) {
	    Enseignant etudiant = ienr.getReferenceById(id);
	    if (etudiant != null) {
	        ienr.delete(etudiant);
	        return true;
	    }
	    return false;
	}
    }
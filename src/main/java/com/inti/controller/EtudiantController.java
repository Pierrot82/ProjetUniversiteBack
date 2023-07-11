package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.inti.model.Etudiant;
import com.inti.repository.IAdministrateurRepository;
import com.inti.repository.IEtudiantRepository;



@RestController

//@RequestMapping("Etudiant")

@CrossOrigin(origins = "http://localhost:4200")

public class EtudiantController {

	@Autowired
	IEtudiantRepository ier;
	
	
	@PostMapping("ajoutEtudiant")
	public Etudiant ajoutEtudiant(@RequestBody Etudiant etu ) {
		return ier.save(etu);
	}
	
	@GetMapping("getListeEtudiant")
	public List<Etudiant> getListeEtudiant(){
		return ier.findAll();
	}
	
	
	@GetMapping("getEtudiant/{id}")
	public Etudiant getEtudiant(@PathVariable("id") int id) {
		try {
			Etudiant etu = ier.getReferenceById(id);
			return etu;
		} catch (Exception e) {
			return null;
		}	
	}
	
	@DeleteMapping("deleteEtudiant/{id}")
	public boolean deleteEtudiant(@PathVariable("id") int id) {
		try {
			ier.delete(ier.getReferenceById(id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@PutMapping("updateEtudiant")
	public boolean updateEtudiant(@RequestBody Etudiant etu) {
		if (ier.getReferenceById(etu.getId()) != null) {
			ier.save(etu);
			return true;
		}
		return false;
			
	}
}

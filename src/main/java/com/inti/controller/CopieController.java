package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.inti.model.Copie;
import com.inti.model.CopieCompositeKey;
import com.inti.model.Etudiant;
import com.inti.model.Examen;
import com.inti.repository.ICopieRepository;
import com.inti.repository.IEtudiantRepository;
import com.inti.repository.IExamenRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CopieController {

	@Autowired
	ICopieRepository icr;
	
	@Autowired
	IEtudiantRepository iEtur;
	
	@Autowired
	IExamenRepository iExamr;
	
	
	@GetMapping("saveCopie/{id}/{idExamen}/{note}")
	public Copie saveCopie(@PathVariable ("id") int id, @PathVariable("idExamen") int idExamen, 
			@PathVariable("note") double note)  {
		Etudiant etu = iEtur.getReferenceById(id);
		Examen exam = iExamr.getReferenceById(idExamen);
		CopieCompositeKey idC = new CopieCompositeKey(etu, exam);
		Copie copie = new Copie(idC, note);
		return icr.save(copie);
	}
	
	
	@GetMapping("getListeCopie")
	public List<Copie> getListeCopie(){
		return icr.findAll();
	}
	
	////////////////////////////////////
	@GetMapping("getCopie/{idEtudiant}/{idExamen}")
	public Copie getCopie(@PathVariable("idEtudiant") int idEtudiant, @PathVariable("idExamen") int idExamen) {
		try {
			Etudiant etu = iEtur.getReferenceById(idEtudiant);
			Examen exam = iExamr.getReferenceById(idExamen);
			CopieCompositeKey id = new CopieCompositeKey(etu, exam);
			return icr.getReferenceById(id);
		} catch (Exception e) {
			return null;
		}	
	}
	
	////////////////////////////////////
	@DeleteMapping("deleteCopie/{idEtudiant}/{idExamen}")
	public boolean deleteCopie(@PathVariable("idEtudiant") int idEtudiant, @PathVariable("idExamen") int idExamen) {
		try {
			Etudiant etu = iEtur.getReferenceById(idEtudiant);
			Examen exam = iExamr.getReferenceById(idExamen);
			CopieCompositeKey id = new CopieCompositeKey(etu, exam);
			icr.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
	
	////////////////////////////////////
	@PostMapping("updateCopie")
	public boolean updateCopie(@RequestBody Copie c) {
		CopieCompositeKey id = c.getIdCopie();
		if (icr.findById(id).isPresent()) {
			icr.save(c);
			return true;
		}
		return false;
	}
}

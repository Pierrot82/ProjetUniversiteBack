package com.inti.controller;

import java.util.ArrayList;
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

import com.inti.model.Enseignant;
import com.inti.model.Etudiant;
import com.inti.repository.IAdministrateurRepository;
import com.inti.repository.IEnseignantRepository;
import com.inti.repository.IEtudiantRepository;



@RestController

//@RequestMapping("Etudiant")

@CrossOrigin(origins = "http://localhost:4200")

public class EtudiantController {

	@Autowired
	IEtudiantRepository ier;
	
	@Autowired
	IEnseignantRepository ienr;
	
	@PostMapping("ajoutEtudiant")
	public Etudiant ajoutEtudiant(@RequestBody Etudiant etu ) {
		System.out.println(etu);
		return ier.save(etu);
	}
	
	@PostMapping("ajoutEtudiantAffectee")
	public Etudiant ajoutEtudiantAffectee(@RequestBody EtudiantIntArray body ) {
		
		Etudiant etu = body.getEtudiant();
		List<Integer> listeIdEnseignant = body.getListeIdEnseignant();		
		List<Enseignant> listEnseignant = ienr.getListEnseignantById(listeIdEnseignant);
		etu.setListeEnseignant(listEnseignant);

		return ier.save(etu);
	}
	
	
	
	@GetMapping("getListeEtudiant")
	public List<Etudiant> getListeEtudiant(){
		return ier.findAll();
	}
	
	@GetMapping("getListeMoyEtudiant")
	public List<Double> getListeMoyEtudiant(){
		List<Double> listD = new ArrayList<>();
		for(Etudiant etu:ier.findAll()) {

			double moy = ier.getMoyEtudiant(etu.getId());
			if (moy == -1) {
				listD.add(null);
			} else {
				listD.add(moy);
			}
		
		}
		return listD;
	}
	
	
	
	@GetMapping("loginEtudiant/{login}/{mdp}")
	public int loginEtudiant(@PathVariable("login") String login, @PathVariable("mdp") String mdp) {
		
		try {
			return ier.loginEtudiant(login, mdp);
		} catch (Exception e) {
			return 0;
		}
		
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

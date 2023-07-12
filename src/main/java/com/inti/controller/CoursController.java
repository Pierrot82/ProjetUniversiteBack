package com.inti.controller;

import java.util.ArrayList;
import java.util.Iterator;
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

import com.inti.model.Cours;
import com.inti.model.Enseignant;
import com.inti.repository.ICoursRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CoursController {
	
	@Autowired
	ICoursRepository icr;
	
	@GetMapping("listeCours")
	public List<Cours> listeCours()
	{
		return icr.findAll();
	}
	
	
	@PostMapping("saveCours")
	public Cours saveCours(@RequestBody Cours Cours)
	{
		return icr.save(Cours);
	}
	
	@PostMapping("modifierNoteCours")
	public Cours modifierNoteCours(@RequestBody Cours Cours)
	{
		Cours coursAvecIdMatiere = icr.getReferenceById(Cours.getIdCours());
		Cours.setMatiere(coursAvecIdMatiere.getMatiere());
		return icr.save(Cours);
	}
	
	@GetMapping("getListeMoyennesNotesCours")
	public List<Double> getListeMoyennesNotesCours() {
		List<Double> listeMoyennes = new ArrayList<>();
		
		List<Cours> listeCours = listeCours();
		double moy = 0;
		int noteCinq;
		int noteQuatre;
		int noteTrois;
		int noteDeux;
		int noteUn;
		
		for( Cours cours : listeCours) {
			noteCinq = cours.getCinq()*5;
			noteQuatre = cours.getQuatre()*4;
			noteTrois = cours.getTrois()*3;
			noteDeux = cours.getDeux()*2;
			noteUn = cours.getUn()*1;
			
			if((noteUn + noteDeux + noteTrois + noteQuatre + noteCinq)>0) {
			moy = (noteUn + noteDeux + noteTrois + noteQuatre + noteCinq)/
					(cours.getUn() + cours.getDeux() + cours.getTrois() + cours.getQuatre() + cours.getCinq());
			listeMoyennes.add(moy);
			}
			else
				listeMoyennes.add(moy);
		}

		return listeMoyennes;
		
	}
	
	@PutMapping("modifierCours/{id}")
	public boolean modifierCours(@PathVariable("id") int id, @RequestBody Cours c) {
	    Cours existingCours = icr.getReferenceById(id);
	    if (existingCours != null) {
	        c.setIdCours(id);
	        icr.save(c);
	        return true;
	    }
	    return false;
	}
	
	@DeleteMapping("deleteCours/{id}")
	public boolean deleteCours(@PathVariable("id")int id)
	{
//		Cours c = icr.getReferenceById(id);
//		if(c != null)
//		{
//			icr.delete(c);
//			return true;
//		}
//		
//		return false;
		try {
			Cours c = icr.getReferenceById(id);
			System.out.println("Cours : " + c);
			icr.delete(c);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	@GetMapping("getCours/{id}")
	public Cours getCours(@PathVariable("id") int id)
	{
		return icr.getReferenceById(id);
	}

}

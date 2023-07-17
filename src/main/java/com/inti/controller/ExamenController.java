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

import com.inti.model.Examen;
import com.inti.repository.IExamenRepository;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ExamenController {
	
	@Autowired
	IExamenRepository iexr;
	
	
	@GetMapping("listeExamen")
	public List<Examen> listeExamen()
	{
		return iexr.findAll();
	}
	
	// les 2 ne marchent pas
	@GetMapping("listeExamenRestantByEtudiant/{id}")
	public List<Examen> listeExamenRestantByEtudiant(@PathVariable("id") int id){
		return iexr.listeExamenRestantByEtudiant(id);
	}
	@GetMapping("listeExamenEffectueByEtudiant/{id}")
	public List<Examen> listeExamenEffectueByEtudiant(@PathVariable("id") int id){
		return iexr.listeExamenEffectueByEtudiant(id);
	}
	
	
	@PostMapping("saveExamen")
	public Examen saveExamen(@RequestBody Examen Examen)
	{
		return iexr.save(Examen);
	}
	
	@PutMapping("modifierExamen")
	public boolean modifierExamen(@RequestBody Examen ex)
	{
		if(iexr.getReferenceById(ex.getIdExamen())!= null)
		{
			iexr.save(ex);
			return true;
		}
		
		return false;
		
	}
	
	@DeleteMapping("deleteExamen/{id}")
	public boolean deleteExamen(@PathVariable("id")int id)
	{
//		Examen cm = iexr.getReferenceById(id);
//		if(c != null)
//		{
//			iexr.delete(c);
//			return true;
//		}
//		
//		return false;
		try {
			Examen ex = iexr.getReferenceById(id);
			System.out.println("Examen : " + ex);
			iexr.delete(ex);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	@GetMapping("getExamen/{id}")
	public Examen getExamen(@PathVariable("id") int id)
	{
		return iexr.getReferenceById(id);
	}
	

	

}

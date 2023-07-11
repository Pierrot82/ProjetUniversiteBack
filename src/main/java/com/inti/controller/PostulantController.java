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

import com.inti.model.Postulant;
import com.inti.repository.IPostulantRepository;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PostulantController {
	
	@Autowired
	IPostulantRepository ipr;
	
	@GetMapping("listePostulant")
	public List<Postulant> listePostulant()
	{
		return ipr.findAll();
	}
	
	
	@PostMapping("savePostulant")
	public boolean savePostulant(@RequestBody Postulant postulant)
	{
		try {
			ipr.save(postulant);
			return true;	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@PostMapping("refuserPostulant")
	public boolean refuserPostulant(@RequestBody Postulant postulant) {
		
		if(postulant.getStatut().equalsIgnoreCase("En attente")){
			postulant.setStatut("Refusé");
			ipr.save(postulant);
			return true;
		}
		else return false;
	}
	
	@PostMapping("accepterPostulant")
	public boolean accepterPostulant(@RequestBody Postulant postulant) {
		if(postulant.getStatut().equalsIgnoreCase("En attente")){
			postulant.setStatut("Accepté");
			ipr.save(postulant);
			return true;
		}
		else return false;
	}
	
	@PutMapping("modifierPostulant")
	public boolean modifierPostulant(@RequestBody Postulant p)
	{
		if(ipr.getReferenceById(p.getId())!= null)
		{
			ipr.save(p);
			return true;
		}
		
		return false;
		
	}
	
	@DeleteMapping("deletePostulant/{id}")
	public boolean deletePostulant(@PathVariable("id")int id)
	{
//		Postulant cm = ipr.getReferenceById(id);
//		if(c != null)
//		{
//			ipr.delete(c);
//			return true;
//		}
//		
//		return false;
		try {
			Postulant p = ipr.getReferenceById(id);
			System.out.println("Postulant : " + p);
			ipr.delete(p);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	@GetMapping("getPostulant/{id}")
	public Postulant getPostulant(@PathVariable("id") int id)
	{
		return ipr.getReferenceById(id);
	}

}

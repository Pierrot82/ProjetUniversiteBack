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

import com.inti.model.Matiere;
import com.inti.repository.IMatiereRepository;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MatiereController {
	
	@Autowired
	IMatiereRepository imr;
	
	@GetMapping("listeMatiere")
	public List<Matiere> listeMatiere()
	{
		return imr.findAll();
	}
	
	
	@PostMapping("saveMatiere")
	public Matiere saveMatiere(@RequestBody Matiere Matiere)
	{
		return imr.save(Matiere);
	}
	
	@PutMapping("modifierMatiere")
	public boolean modifierMatiere(@RequestBody Matiere m)
	{
		if(imr.getReferenceById(m.getIdMatiere())!= null)
		{
			imr.save(m);
			return true;
		}
		
		return false;
		
	}
	
	@DeleteMapping("deleteMatiere/{idMatiere}")
	public boolean deleteMatiere(@PathVariable("idMatiere")int idMatiere)
	{
//		Matiere cm = imr.getReferenceById(id);
//		if(c != null)
//		{
//			imr.delete(c);
//			return true;
//		}
//		
//		return false;
		try {
			Matiere m = imr.getReferenceById(idMatiere);
			System.out.println("Matiere : " + m);
			imr.delete(m);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	@GetMapping("getMatiere/{idMatiere}")
	public Matiere getMatiere(@PathVariable("idMatiere") int idMatiere)
	{
		return imr.getReferenceById(idMatiere);
	}

}

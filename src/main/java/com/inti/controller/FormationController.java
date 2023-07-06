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

import com.inti.model.Formation;
import com.inti.repository.IFormationRepository;



@RestController

//@RequestMapping("formation")

@CrossOrigin(origins = "http://localhost:4200")

public class FormationController {

	@Autowired
	IFormationRepository ifr;
	
	
	@PostMapping("ajoutFormation")
	public Formation ajoutFormation(@RequestBody Formation f ) {
		return ifr.save(f);
	}
	
	@GetMapping("getListeFormation")
	public List<Formation> getListeFormation(){
		return ifr.findAll();
	}
	
	
	@GetMapping("getFormation/{id}")
	public Formation getFormation(@PathVariable("id") int id) {
		try {
			Formation f = ifr.getReferenceById(id);
			return f;
		} catch (Exception e) {
			return null;
		}	
	}
	
	@DeleteMapping("deleteFormation/{id}")
	public boolean deleteFormation(@PathVariable("id") int id) {
		try {
			ifr.delete(ifr.getReferenceById(id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@PostMapping("updateFormation")
	public boolean updateFormation(@RequestBody Formation f) {
		if (ifr.getReferenceById(f.getIdFormation()) != null) {
			ifr.save(f);
			return true;
		}
		return false;
			
	}
	
}

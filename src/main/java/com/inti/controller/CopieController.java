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

import com.inti.model.Copie;
import com.inti.repository.ICopieRepository;





@RestController

//@RequestMapping("Copie")

@CrossOrigin(origins = "http://localhost:4200")

public class CopieController {

	@Autowired
	ICopieRepository icr;
	
	
	@PostMapping("ajoutCopie")
	public Copie ajoutCopie(@RequestBody Copie c ) {
		return icr.save(c);
	}
	
	
	@GetMapping("getListeCopie")
	public List<Copie> getListeCopie(){
		return icr.findAll();
	}
	
	////////////////////////////////////
	@GetMapping("getCopie/{id}")
	public Copie getCopie(@PathVariable("id") int id) {
		try {
			Copie c = icr.getReferenceById(id);
			return c;
		} catch (Exception e) {
			return null;
		}	
	}
	
	////////////////////////////////////
	@DeleteMapping("deleteCopie/{id}")
	public boolean deleteCopie(@PathVariable("id") int id) {
		try {
			icr.delete(icr.getReferenceById(id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	////////////////////////////////////
	@PostMapping("updateCopie")
	public boolean updateCopie(@RequestBody Copie c) {
		if (icr.getReferenceById(c.get()) != null) {
			icr.save(c);
			return true;
		}
		return false;
			
	}
}

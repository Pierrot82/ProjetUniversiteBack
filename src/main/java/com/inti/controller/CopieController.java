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
	ICopieRepository iar;
	
	
	@PostMapping("ajoutCopie")
	public Copie ajoutCopie(@RequestBody Copie a ) {
		return iar.save(a);
	}
	
	@GetMapping("getListeCopie")
	public List<Copie> getListeCopie(){
		return iar.findAll();
	}
	
	
	@GetMapping("getCopie/{id}")
	public Copie getCopie(@PathVariable("id") int id) {
		try {
			Copie a = iar.getReferenceById(id);
			return a;
		} catch (Exception e) {
			return null;
		}	
	}
	
	@DeleteMapping("deleteCopie/{id}")
	public boolean deleteCopie(@PathVariable("id") int id) {
		try {
			iar.delete(iar.getReferenceById(id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@PostMapping("updateCopie")
	public boolean updateCopie(@RequestBody Copie a) {
		if (iar.getReferenceById(a.getId()) != null) {
			iar.save(a);
			return true;
		}
		return false;
			
	}
}

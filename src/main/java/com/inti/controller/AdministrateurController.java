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

import com.inti.model.Administrateur;
import com.inti.repository.IAdministrateurRepository;





@RestController

//@RequestMapping("Administrateur")

@CrossOrigin(origins = "http://localhost:4200")

public class AdministrateurController {

	@Autowired
	IAdministrateurRepository iar;
	
	
	@PostMapping("ajoutAdministrateur")
	public Administrateur ajoutAdministrateur(@RequestBody Administrateur a ) {
		return iar.save(a);
	}
	
	@GetMapping("getListeAdministrateur")
	public List<Administrateur> getListeAdministrateur(){
		return iar.findAll();
	}
	
	
	@GetMapping("getAdministrateur/{id}")
	public Administrateur getAdministrateur(@PathVariable("id") int id) {
		try {
			Administrateur a = iar.getReferenceById(id);
			return a;
		} catch (Exception e) {
			return null;
		}	
	}
	
	@DeleteMapping("deleteAdministrateur/{id}")
	public boolean deleteAdministrateur(@PathVariable("id") int id) {
		try {
			iar.delete(iar.getReferenceById(id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@PostMapping("updateAdministrateur")
	public boolean updateAdministrateur(@RequestBody Administrateur a) {
		if (iar.getReferenceById(a.getId()) != null) {
			iar.save(a);
			return true;
		}
		return false;
			
	}
}

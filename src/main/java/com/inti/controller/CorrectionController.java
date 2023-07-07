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

import com.inti.model.Correction;
import com.inti.repository.ICorrectionRepository;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CorrectionController {
	
	@Autowired
	ICorrectionRepository icrr;
	
	@GetMapping("listeCorrection")
	public List<Correction> listeCorrection()
	{
		return icrr.findAll();
	}
	
	
	@PostMapping("saveCorrection")
	public Correction saveCorrection(@RequestBody Correction Correction)
	{
		return icrr.save(Correction);
	}
	
	@PutMapping("modifierCorrection")
	public boolean modifierCorrection(@RequestBody Correction cr)
	{
		if(icrr.getReferenceById(cr.getIdCorrection())!= null)
		{
			icrr.save(cr);
			return true;
		}
		
		return false;
		
	}
	
	@DeleteMapping("deleteCorrection/{id}")
	public boolean deleteCorrection(@PathVariable("id")int id)
	{
//		Correction cm = icrr.getReferenceById(id);
//		if(c != null)
//		{
//			icrr.delete(c);
//			return true;
//		}
//		
//		return false;
		try {
			Correction cr = icrr.getReferenceById(id);
			System.out.println("Correction : " + cr);
			icrr.delete(cr);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	@GetMapping("getCorrection/{id}")
	public Correction getCorrection(@PathVariable("id") int id)
	{
		return icrr.getReferenceById(id);
	}

}

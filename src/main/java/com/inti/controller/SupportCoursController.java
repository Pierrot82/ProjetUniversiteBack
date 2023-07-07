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

import com.inti.model.SupportCours;
import com.inti.repository.ISupportCoursRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SupportCoursController {
	
	@Autowired
	ISupportCoursRepository iscr;
	
	@GetMapping("listeSupportCours")
	public List<SupportCours> listeSupportCours()
	{
		return iscr.findAll();
	}
	
	
	@PostMapping("saveSupportCours")
	public SupportCours saveSupportCours(@RequestBody SupportCours SupportCours)
	{
		return iscr.save(SupportCours);
	}
	
	@PutMapping("modifierSupportCours")
	public boolean modifierSupportCours(@RequestBody SupportCours cs)
	{
		if(iscr.getReferenceById(cs.getIdSupport())!= null)
		{
			iscr.save(cs);
			return true;
		}
		
		return false;
		
	}
	
	@DeleteMapping("deleteSupportCours/{id}")
	public boolean deleteSupportCours(@PathVariable("id")int id)
	{
//		SupportCours c = iscr.getReferenceById(idSupport);
//		if(c != null)
//		{
//			iscr.delete(c);
//			return true;
//		}
//		
//		return false;
		try {
			SupportCours cs = iscr.getReferenceById(id);
			System.out.println("SupportCours : " + cs);
			iscr.delete(cs);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	@GetMapping("getSupportCours/{id}")
	public SupportCours getSupportCours(@PathVariable("id") int id)
	{
		return iscr.getReferenceById(id);
	}

}

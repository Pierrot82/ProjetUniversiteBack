package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.repository.IStatistiquesRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StatistiquesController {
	
	@Autowired
	IStatistiquesRepository isr;

	@GetMapping("/moyenne_notes")
	public Double calculerMoyenneNotesEtudiants() {
		return isr.calculerMoyenneNotesEtudiants();
	}
	@GetMapping("/notelaplusbasse")
	public Double notelaplusbasse() {
		return isr.notelaplusbasse();
	}
	@GetMapping("/notelaplushaute")
	public Double notelaplushaute() {
		return isr.notelaplushaute();
	}
	
	@GetMapping("/nombreetu")
	public Double nombreetu() {
		return isr.nombreetu();
	}
	
	@GetMapping("/nombrenseignants")
	public Double nombrenseignants() {
		return isr.nombrenseignants();
	}
	
	@GetMapping("/nombrepostulants")
	public Double nombrepostulants() {
		return isr.nombrepostulants();
	}
	
	@GetMapping("/jeanmich")
	public Double jeanmich() {
		return isr.jeanmich();
	}
	
	@GetMapping("/totalmessages")
	public Double totalmessages() {
		return isr.totalmessages();
	}
}

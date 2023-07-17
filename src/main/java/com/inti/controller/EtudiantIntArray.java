package com.inti.controller;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.inti.model.Copie;
import com.inti.model.Discussion;
import com.inti.model.Enseignant;
import com.inti.model.Etudiant;
import com.inti.model.Formation;
import com.inti.model.Reponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class EtudiantIntArray {

	
	 private Etudiant etudiant;
	 private List<Integer> listeIdEnseignant;
	
	
}

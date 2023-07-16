package com.inti.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString.Exclude;

@Entity @Table
@Data @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Matiere {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMatiere;
	@Column(nullable = false, length = 50)
	private String nom;
	
	@JsonIgnore
	@OneToMany(mappedBy = "matiere")
	@Exclude
	private List<Cours> listeCours;
	
	@JsonIgnore
	@OneToMany(mappedBy = "matiere")
	@Exclude
	private List<Examen> listeExam;
	
	@JsonIgnore
	@Exclude
	@OneToMany(mappedBy = "matiere")
	private List<Enseignant> listeEnseignant;
	
	@JsonIgnore
	@Exclude
	@OneToMany(mappedBy = "matiere")
	private List<Postulant> listePostulant;

}

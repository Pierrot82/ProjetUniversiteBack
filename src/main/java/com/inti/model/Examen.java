package com.inti.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString.Exclude;

@Entity @Table
@Data @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Examen {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idExamen;
	@Column(nullable = false, length = 50)
	private String intitule;
	@Column(nullable = false)
	private double coef;
	@Column(nullable = false)
	private LocalDate date;
	@Column(nullable = false)
	private double duree;

	
	@Exclude
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "id_correction")
	private Correction correction;
	
	@Exclude
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_matiere")
	private Matiere matiere;
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "idCopie.examen")
	@Exclude
	private List<Copie> copie;
	
	
}
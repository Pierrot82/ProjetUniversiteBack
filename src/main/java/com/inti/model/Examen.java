package com.inti.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
	
	@OneToOne
	@JoinColumn(name = "id_correction")
	private Correction correction;
	
	@ManyToOne
	@JoinColumn(name = "id_matiere")
	private Matiere matiere;
	
	
	
	
}
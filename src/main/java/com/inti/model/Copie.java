package com.inti.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table

@Data @NoArgsConstructor @AllArgsConstructor



public class Copie {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id_Copie;
	
	private double note;
	
	
	@Id
	@ManyToOne
	@JoinColumn(name="id")
	private Etudiant etudiant;

	@Id
	@ManyToOne
	@JoinColumn(name="id_examen")
	private Examen examen;
	
}

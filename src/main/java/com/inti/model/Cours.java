package com.inti.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString.Exclude;

@Entity @Table
@Data @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Cours {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCours;
	@Column(unique = true, nullable = false, length = 50)
	private String nom;
	
	
	
	
	public Cours(String nom) {
		super();
		this.nom = nom;
	}

	@OneToMany(mappedBy = "cours")
	@Exclude
	List<SupportCours> ListeSup;
	
	@ManyToOne
	@JoinColumn(name = "id_matiere")
	private Matiere matiere;


}

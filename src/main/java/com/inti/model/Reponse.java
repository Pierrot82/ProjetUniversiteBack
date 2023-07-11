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
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString.Exclude;

@Entity @Table
@Data @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Reponse {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReponse;
	
	@Column(unique = true, nullable = false, length = 50)
	private String reponse;
	
	private LocalDate date;

	public Reponse(String reponse) {
		super();
		this.reponse = reponse;
	}


	@Exclude
//	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_discussion")
	private Discussion discussion;

	
	
//	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_etudiant")
	@Exclude
	private Etudiant etudiant;
	
//	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_enseignant")
	@Exclude
	private Enseignant enseignant;
	

}

package com.inti.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString.Exclude;

@Entity
@Table
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@NoArgsConstructor @AllArgsConstructor 
@PrimaryKeyJoinColumn(name = "id")
public class Postulant extends Personne {
	
	@Column(nullable = false, length = 10)
	private String statut;
	@Column(nullable = false)
	private String cv;
	@Column(nullable = false)
	private String fichiers;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	
	@Exclude
//	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_matiere")
	private Matiere matiere;

}

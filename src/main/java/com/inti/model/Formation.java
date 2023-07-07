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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString.Exclude;




@Entity
@Table
@Data @NoArgsConstructor @AllArgsConstructor

@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Formation {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFormation;
	// bac+5 comptabilité , licence 2 gestion, ...
	@Column(unique = true, nullable = false, length = 50)
	private String intitule;
	@Column(length = 50)
	private String diplome;
	//   5 si bac+5 , 2 si licence 2, ...
	private int niveauEtude;
	//  cette licence porte sur ...
	@Column(length = 360)
	private String description;
	
	@JsonIgnore
	@ManyToMany
	@Exclude
	@JoinTable(name = "Etu_formation",
	joinColumns = @JoinColumn(name = "id_formation"),
	inverseJoinColumns = @JoinColumn(name = "id_etudiant"))
	private List<Etudiant> listeEtu;
	


	

	
	
	
}

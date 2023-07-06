package com.inti.model;
import java.time.LocalDate;
import java.util.List;


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




@Entity
@Table
@Data @NoArgsConstructor @AllArgsConstructor

@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Formation {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)

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


	

	
	
	
}

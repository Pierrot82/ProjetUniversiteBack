package com.inti.model;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
public class Etudiant extends Personne{

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)

	
	private LocalDate dateInscription;
	

	
	
	
}

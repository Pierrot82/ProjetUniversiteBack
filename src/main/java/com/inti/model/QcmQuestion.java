package com.inti.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
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
public class QcmQuestion {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idQcmQuestion;
	
	private String intituleQuestion;
	
	private int bonChoix;

	
//	@Exclude
//	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_examin")
	private Examen examen;
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "qcmQuestion", cascade = CascadeType.ALL)
	@Exclude
	private List<QcmProposition> listeQcmProposition;	
	
	

	
	
}

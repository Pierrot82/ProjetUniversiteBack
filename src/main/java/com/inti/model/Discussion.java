package com.inti.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
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
public class Discussion {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDiscussion;
	
	@Column(unique = true, nullable = false, length = 50)
	private String question;
	
	private LocalDate date;

	private LocalDateTime dateTime;
	
	

	public Discussion(String question, LocalDate date) {
		this.question = question;
		this.date = date;
	}

	@JsonIgnore
	@OneToMany(mappedBy = "discussion", cascade = CascadeType.ALL)
	@Exclude
	private List<Reponse> listeReponse;
	
	
	
//	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_etudiant")
//	@Exclude
	private Etudiant etudiant;
	
	
//	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_destinataire")
//	@Exclude
	private Enseignant enseignant;
	

}

package com.inti.model;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString.Exclude;


@Entity
@Table
@Data @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@PrimaryKeyJoinColumn(name = "id")
public class Etudiant extends Personne{

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private LocalDate dateInscription;
	
	
	@Column(unique = true)
	private String login;
	
	private String mdp;
	
	@JsonIgnore
	@ManyToMany
	@Exclude
	@JoinTable(name = "Etu_formation",
	joinColumns = @JoinColumn(name = "id_etudiant"),
	inverseJoinColumns = @JoinColumn(name = "id_formation"))
	private List<Formation> listeFormation;
	
	@JsonIgnore
	@ManyToMany
	//@Exclude
	@JoinTable(name = "Etu_enseignant",
	joinColumns = @JoinColumn(name = "id_etudiant"),
	inverseJoinColumns = @JoinColumn(name = "id_enseignant"))
	private List<Enseignant> listeEnseignant;
	
	@JsonIgnore
	@OneToMany(mappedBy = "idCopie.etudiant", cascade = CascadeType.ALL)
	@Exclude
	private List<Copie> copie;
	
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL)
	@Exclude
	private List<Discussion> listeDiscussion;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL)
	@Exclude
	private List<Reponse> listeReponse;	
	
	
	
	
	
}

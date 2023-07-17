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
import jakarta.persistence.ManyToOne;
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
public class Enseignant extends Personne{

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private LocalDate dateEmbauche;
	
	@Column(unique = true)
	private String email;
	
	@Column(unique = true)
	private String login;
	
	private String mdp;
	
	
	@JsonIgnore
	@ManyToMany
	@Exclude
	@JoinTable(name = "Etu_enseignant",
	joinColumns = @JoinColumn(name = "id_enseignant"),
	inverseJoinColumns = @JoinColumn(name = "id_etudiant"))
	private List<Etudiant> listeEtu;
	
	@Exclude
//	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_matiere")
	private Matiere matiere;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "enseignant")
	@Exclude
	private List<Reponse> listeReponse;	
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "enseignant")
	@Exclude
	private List<Discussion> listeDiscussion;

}

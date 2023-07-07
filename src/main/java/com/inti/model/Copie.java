package com.inti.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table

@Data @NoArgsConstructor @AllArgsConstructor


//@PrimaryKeyJoinColumn(name = "id", name = "id_examen")
//@PrimaryKeyJoinColumn(name = "id_examen")

public class Copie {
	
	
	
	private double note;
	
	
	@Id
	@ManyToOne
	@JoinColumn(name="id")
	private Etudiant etudiant;

	@Id
	@ManyToOne
	@JoinColumn(name="id_examen")
	private Examen examen;
	
	
}

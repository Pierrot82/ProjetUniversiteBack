package com.inti.model;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data @NoArgsConstructor @AllArgsConstructor
public class Copie {
	
	@EmbeddedId
	private CopieCompositeKey idCopie;
	
	private double note;

	@Id
	@ManyToOne
	@JoinColumn(name="id_examen")
	private Examen examen;

}

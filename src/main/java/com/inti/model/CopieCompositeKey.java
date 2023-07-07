package com.inti.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString.Exclude;

@Embeddable
@Data @NoArgsConstructor @AllArgsConstructor
public class CopieCompositeKey implements Serializable {
	

	@ManyToOne
	@JoinColumn(name="id")
	private Etudiant etudiant;


	@ManyToOne
	@JoinColumn(name="id_examen")
	private Examen examen;

}

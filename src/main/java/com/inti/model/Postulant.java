package com.inti.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor @AllArgsConstructor 
@PrimaryKeyJoinColumn(name = "id")
public class Postulant extends Personne {
	
	@Column(nullable = false, length = 10)
	private String statut;
	@Column(nullable = false)
	private String cv;
	@Column(nullable = false)
	private String fichiers;

}

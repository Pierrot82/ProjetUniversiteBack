package com.inti.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Entity
@Table
@Data
@NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Personne {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	@NonNull
	@Column(nullable = false, length = 20)
	protected String nom;
	@NonNull
	@Column(nullable = false, length = 20)
	protected String prenom;
	@NonNull
	@Column(nullable = true, length = 20)
	protected LocalDate dateNaissance;
	
//	@NonNull
//	@Column(unique = true)
//	protected String email;

}

package com.inti.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString.Exclude;

@Entity @Table
@Data @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class SupportCours {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSupport;
	
	@Exclude
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_cours")
	private Cours cours;
}

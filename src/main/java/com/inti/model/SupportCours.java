package com.inti.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
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
	@Column
	private String imageFile;
	
	@Exclude
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_cours")
	private Cours cours;


	public void setImageData(byte[] bytes) {
		// TODO Auto-generated method stub
		
	}
}

package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inti.model.Statistiques;

public interface IStatistiquesRepository extends JpaRepository<Statistiques, Integer> {

	@Query("SELECT ROUND(AVG(note), 2) FROM Copie")
	Double calculerMoyenneNotesEtudiants();
    
    @Query("SELECT MIN(note) FROM Copie")
    Double notelaplusbasse();

    @Query("SELECT MAX(note) FROM Copie")
    Double notelaplushaute();
    
    @Query("SELECT COUNT(*) FROM Etudiant")
    Double nombreetu();
    
    @Query("SELECT COUNT(*) FROM Enseignant")
    Double nombrenseignants();
    
    @Query("SELECT COUNT(*) FROM Postulant")
    Double nombrepostulants();
    
    @Query("SELECT COUNT(*) FROM Personne WHERE nom='Michel' AND prenom='Jean'")
    Double jeanmich();
    
    @Query("SELECT COUNT(*) AS total\n"
    		+ "    FROM (\n"
    		+ "      SELECT idReponse AS id FROM Reponse\n"
    		+ "      UNION ALL\n"
    		+ "      SELECT idDiscussion AS id FROM Discussion\n"
    		+ "    ) AS combined")
    Double totalmessages(); 
}

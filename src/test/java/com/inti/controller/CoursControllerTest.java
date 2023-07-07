package com.inti.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inti.model.Cours;
import com.inti.repository.ICoursRepository;

@WebMvcTest(controllers = CoursController.class)
@AutoConfigureMockMvc
public class CoursControllerTest {
	
	 @Autowired
	    private MockMvc mockMvc;
	 
	 @MockBean
		private ICoursRepository icr;
	 
	 
	 @Test
	    public void testListeCours() throws Exception {
	        mockMvc.perform(MockMvcRequestBuilders.get("/listeCours"))
	                .andExpect(MockMvcResultMatchers.status().isOk())
	                .andDo(print());
	    }
	 
	 @Test
	    public void testListeCoursCompare() throws Exception {
	        
	        List<Cours> coursListeReference = Arrays.asList(
	                new Cours("Cours 1"),
	                new Cours("Cours 2"),
	                new Cours("Cours 3")
	        );
	       
	        when(icr.findAll()).thenReturn(coursListeReference);

	        mockMvc.perform(get("/listeCours"))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.length()").value(coursListeReference.size()))
	                .andExpect(jsonPath("$[0].nom").value("Cours 1"))
	                .andExpect(jsonPath("$[1].nom").value("Cours 2"))
	                .andExpect(jsonPath("$[2].nom").value("Cours 3"))
	                .andDo(print());
	       
	    }
	 
	 @Test
	 public void testSaveCours() throws Exception {
	     Cours c = new Cours();
	     
	     when(icr.save(c)).thenReturn(c);
	     
	     mockMvc.perform(MockMvcRequestBuilders.post("/saveCours")
	             .content(new ObjectMapper().writeValueAsString(c))
	             .contentType(MediaType.APPLICATION_JSON_VALUE)) // Use contentType(String)
	             .andExpect(MockMvcResultMatchers.status().isOk())
	             .andExpect(MockMvcResultMatchers.jsonPath("$.idCours").exists());
	 }
	 
	 @Test
	    public void testGetCours() throws Exception {
	        int id = 1; 
	        Cours cours = new Cours();
	        cours.setIdCours(id);
	        cours.setNom("Cours 1");

	        Mockito.when(icr.getReferenceById(id)).thenReturn(cours);

	        mockMvc.perform(MockMvcRequestBuilders.get("/getCours/{id}", id))
	                .andExpect(MockMvcResultMatchers.status().isOk())
	                .andExpect(MockMvcResultMatchers.jsonPath("$.idCours").value(id))
	                .andExpect(MockMvcResultMatchers.jsonPath("$.nom").value("Cours 1"));
	    }
	 
	 
	 @Test
	    public void testModifierCours() throws Exception {
	        int idCours = 1;
	        String nomCours = "Cours de test";
	        Cours cours = new Cours();
	        cours.setIdCours(idCours);
	        cours.setNom(nomCours);
	        
	        Cours existingCours = new Cours();
	        existingCours.setIdCours(idCours);

	       
	        when(icr.getReferenceById(idCours)).thenReturn(existingCours);
	        when(icr.save(Mockito.any(Cours.class))).thenReturn(cours);

	        
	        mockMvc.perform(put("/modifierCours/{id}", idCours)
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(asJsonString(cours)))
	                .andExpect(status().isOk())
	                .andExpect(content().string("true"));

	        
	        verify(icr, Mockito.times(1)).getReferenceById(idCours);
	        verify(icr, Mockito.times(1)).save(Mockito.any(Cours.class));
	    }

	 private static String asJsonString(final Object obj) {
	        try {
	            final ObjectMapper mapper = new ObjectMapper();
	            final String jsonContent = mapper.writeValueAsString(obj);
	            return jsonContent;
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
	 
	 @Test
	    public void testDeleteCours() throws Exception {
	        Cours cours = new Cours();
	        cours.setIdCours(1);
	        cours.setNom("Mathématiques");

	        Mockito.when(icr.findById(Mockito.anyInt())).thenReturn(Optional.of(cours));

	        mockMvc.perform(delete("/deleteCours/{id}", 1))
	                .andExpect(status().isOk());
	 }
	 
	 
	 


}

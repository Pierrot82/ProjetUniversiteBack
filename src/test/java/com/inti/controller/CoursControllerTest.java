package com.inti.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.inti.model.Client;
import com.inti.model.Cours;
import com.inti.repository.ICoursRepository;

@WebMvcTest(controllers = CoursController.class)
@AutoConfigureMockMvc
public class CoursControllerTest {
	
	 @Autowired
	    private MockMvc mockMvc;
	 
	 @MockBean
		private ICoursRepository icr;
	 
	 @InjectMocks
	    private CoursController cc;
	 
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
		public void saveCoursPost() throws Exception
		{
			mockMvc.perform(post("/creerClient").sessionAttr("client", new Client("dupont", "louis", "test@test.fr")))
			.andExpect(status().is3xxRedirection())
			.andExpect(redirectedUrl("/listeClient"))
			.andDo(print());
		}
	 


}

package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.Discussion;
import com.inti.model.Etudiant;
import com.inti.model.Examen;
import com.inti.repository.IDiscussionRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DiscussionController {
	
	@Autowired
	IDiscussionRepository idr;
	
	
	@GetMapping("listeDiscussion")
	public List<Discussion> listeDiscussion() {
		return idr.findAll();
	}

	@GetMapping("getDiscussion/{id}")
	public Discussion getDiscussion(@PathVariable("id") int id)
	{
		return idr.getReferenceById(id);
	}
	
	@PostMapping("saveDiscussion")
	public Discussion saveDiscussion(@RequestBody Discussion d) {
	    return idr.save(d);
	}

	@PutMapping("modifierDiscussion")

	public boolean modifienrDiscussion(@RequestBody Discussion d) {
	    Discussion existingDiscussion = idr.getReferenceById(d.getIdDiscussion());
	    if (existingDiscussion != null) {
//	        en.setId(id);
	        idr.save(d);
	        return true;
	    }
	    return false;
	}
	

	
	
	
	@DeleteMapping("deleteDiscussion/{id}")
	public boolean deleteDiscussion(@PathVariable("id") int id) {
	    Discussion discussion = idr.getReferenceById(id);
	    if (discussion != null) {
	        idr.delete(discussion);
	        return true;
	    }
	    return false;
	}
	

	
	@GetMapping("listeDiscussionbyId1/{id}")
	public List<Discussion> listeDiscussionbyId1(@PathVariable("id") int id) {
		return idr.findAllById1(id);
	}
	
	
	
	
    }
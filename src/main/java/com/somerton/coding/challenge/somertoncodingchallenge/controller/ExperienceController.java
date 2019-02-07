package com.somerton.coding.challenge.somertoncodingchallenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.somerton.coding.challenge.somertoncodingchallenge.model.Experiences;
import com.somerton.coding.challenge.somertoncodingchallenge.response.ExperienceRequest;
import com.somerton.coding.challenge.somertoncodingchallenge.service.ExperienceServiceImpl;

@RestController
public class ExperienceController {
	
	@Autowired
	private ExperienceServiceImpl experienceService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping(path = "experiences")
	public void addExperience(@RequestBody ExperienceRequest experience) {
		 experienceService.saveExperience(experience);		
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path = "experiences/{email}")
	public List<Experiences> getExperiencesFilterByEmail(@PathVariable String email) {
		return experienceService.findByEmail(email);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path = "all-experiences")
	public List<Experiences> getAllExperiences(){
		return experienceService.findAllExperiences();
	}
}

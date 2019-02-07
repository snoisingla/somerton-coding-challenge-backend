package com.somerton.coding.challenge.somertoncodingchallenge.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.somerton.coding.challenge.somertoncodingchallenge.model.Experiences;
import com.somerton.coding.challenge.somertoncodingchallenge.model.Members;
import com.somerton.coding.challenge.somertoncodingchallenge.repository.ExperienceRepository;
import com.somerton.coding.challenge.somertoncodingchallenge.response.ExperienceRequest;

@Service
@Repository
@Transactional
public class ExperienceServiceImpl {
	
	@Autowired
	private ExperienceRepository experienceRepository;
	@Autowired
	private MemberServiceImpl memberService;
	
	public void saveExperience(ExperienceRequest experience) {
		Experiences exp = new Experiences();
		Members member = memberService.fetchMember(experience.getEmail());
		exp.setMember(member);
		exp.setName(experience.getName());
		exp.setLocation(experience.getLocation());
		exp.setPhotoUrl(experience.getPhotoUrl());
		experienceRepository.save(exp);
	}
	
	public List<Experiences> findByEmail(String email) {
		Members member = memberService.fetchMember(email);
		return member.getExperiences();
	}
	
	public List<Experiences> findAllExperiences(){
		return experienceRepository.findAll();
	}

}

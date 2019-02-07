package com.somerton.coding.challenge.somertoncodingchallenge.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.somerton.coding.challenge.somertoncodingchallenge.model.Members;
import com.somerton.coding.challenge.somertoncodingchallenge.repository.MemberRepository;

@Service
@Repository
@Transactional
public class MemberServiceImpl {
	
	@Autowired
	private MemberRepository memberRepository;
		
	public boolean isEmailAlreadyRegistered(String email) {
		return memberRepository.existsById(email);
	}
	
	public void saveMember(Members member) {
		memberRepository.save(member);
	}
	
	public ResponseEntity<Object> loginMember(String email, String password) {
		boolean isEmailAlreadyExists = memberRepository.existsById(email);
		if(isEmailAlreadyExists == false) {
			return new ResponseEntity<>("Email not found. Please register", HttpStatus.NOT_FOUND);
		}
		
		Members member = memberRepository.findById(email).get();
		return (member.getPassword().equals(password)) ? 
				new ResponseEntity<>(member, HttpStatus.OK) : 
					new ResponseEntity<>("Incorrect password. Please try again", HttpStatus.CONFLICT);
	}
	
	public Members fetchMember(String email) {
		return memberRepository.findById(email).get();
	}
	
}

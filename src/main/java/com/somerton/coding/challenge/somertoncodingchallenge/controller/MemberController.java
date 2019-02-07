package com.somerton.coding.challenge.somertoncodingchallenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.somerton.coding.challenge.somertoncodingchallenge.model.Members;
import com.somerton.coding.challenge.somertoncodingchallenge.service.MemberServiceImpl;


@RestController
public class MemberController {
	
	@Autowired
	private MemberServiceImpl memberService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping(path = "members")
	public ResponseEntity<Object> addMember(@RequestBody Members member) { //Sign Up
		if(memberService.isEmailAlreadyRegistered(member.getEmail())) {
			return new ResponseEntity<>("Email already registered",HttpStatus.CONFLICT);
		}
		memberService.saveMember(member);
		Members member1 = memberService.fetchMember(member.getEmail());
		return new ResponseEntity<>(member1,HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path = "members/{email}/{password}")
	public ResponseEntity<Object> loginMember(@PathVariable String email,@PathVariable String password){
		return memberService.loginMember(email, password);
	}
	
}

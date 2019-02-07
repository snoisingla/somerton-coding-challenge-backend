package com.somerton.coding.challenge.somertoncodingchallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.somerton.coding.challenge.somertoncodingchallenge.model.Members;

public interface MemberRepository extends JpaRepository<Members, String>{

}

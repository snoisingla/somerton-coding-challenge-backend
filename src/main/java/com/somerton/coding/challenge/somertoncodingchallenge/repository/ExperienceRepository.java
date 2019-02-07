package com.somerton.coding.challenge.somertoncodingchallenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.somerton.coding.challenge.somertoncodingchallenge.model.Experiences;
import com.somerton.coding.challenge.somertoncodingchallenge.model.Members;

public interface ExperienceRepository extends JpaRepository<Experiences,Integer>{



}

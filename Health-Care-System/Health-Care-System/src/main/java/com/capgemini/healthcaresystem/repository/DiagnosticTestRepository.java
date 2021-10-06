package com.capgemini.healthcaresystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.healthcaresystem.dao.DiagnosticTest;

public interface DiagnosticTestRepository extends JpaRepository<DiagnosticTest, Integer> {
	public List<DiagnosticTest> findAllById(int id);

	public DiagnosticTest findById(int id);
	public DiagnosticTest findByTestName(String testName);
}

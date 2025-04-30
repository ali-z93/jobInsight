package com.ali.jobInsight.company;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class CompanyController {

	private CompanyService companyService;

	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}

	@GetMapping
	public ResponseEntity<List<Company>> getAllCompany() {
		return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
		Company company = companyService.getCompanyById(id);
		if (company != null) {
			return new ResponseEntity<>(company, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping
	public ResponseEntity<String> addCompany(@RequestBody Company company) {
		companyService.createCompany(company);
		return new ResponseEntity<>("Company ADDED successfully", HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateCompany(@RequestBody Company company, @PathVariable Long id) {

		companyService.updateCompany(company, id);
		return new ResponseEntity<>("Company UPDATED successfully", HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
		boolean isDeleted = companyService.deleteCompanyById(id);

		if (isDeleted) {
			return new ResponseEntity<>("comapny DELETED successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("comapny NOT FOUND", HttpStatus.NOT_FOUND);
		}
	}

}

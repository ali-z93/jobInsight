package com.ali.jobInsight.company.companyServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ali.jobInsight.company.Company;
import com.ali.jobInsight.company.CompanyRepository;
import com.ali.jobInsight.company.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	private CompanyRepository companyRepository;

	public CompanyServiceImpl(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	@Override
	public List<Company> getAllCompanies() {
		return companyRepository.findAll();
	}

}

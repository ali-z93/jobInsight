package com.ali.jobInsight.company.companyServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ali.jobInsight.company.Company;
import com.ali.jobInsight.company.CompanyRepository;
import com.ali.jobInsight.company.CompanyService;
import com.ali.jobInsight.job.Job;

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

	@Override
	public void createCompany(Company company) {
		companyRepository.save(company);

	}

	@Override
	public boolean updateCompany(Company company, Long id) {
		// TODO Auto-generated method stub
		Optional<Company> companyOptional = companyRepository.findById(id);
		if (companyOptional.isPresent()) {
			Company companyToUpdate = companyOptional.get();
			companyToUpdate.setName(company.getName());
			companyToUpdate.setDescription(company.getDescription());
			companyToUpdate.setJobs(company.getJobs());
			companyRepository.save(companyToUpdate);
			return true;
		}

		return false;
	}

	@Override
	public boolean deleteCompanyById(Long id) {
		// TODO Auto-generated method stub
		if (companyRepository.existsById(id)) {
			companyRepository.deleteById(id);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public Company getCompanyById(Long id) {
		
		return companyRepository.findById(id).orElse(null);
	}

}

package org.redeemerlives.firstjobapp.company.Impl;

import org.redeemerlives.firstjobapp.company.Company;
import org.redeemerlives.firstjobapp.company.CompanyRepository;
import org.redeemerlives.firstjobapp.company.CompanyService;
import org.redeemerlives.firstjobapp.job.Job;
import org.redeemerlives.firstjobapp.job.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final JobRepository jobRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository, JobRepository jobRepository) {
        this.companyRepository = companyRepository;
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> getCompanyById(int id) {
        return companyRepository.findById(id);
    }

    @Override
    public void createCompany(Company company) {
        Company newCompany = new Company(company.getName(), company.getDescription());
        companyRepository.save(newCompany);
    }

    @Override
    public boolean updatedCompany(Company companyUpdate, int companyId) {
        Optional<Company> company = companyRepository.findById(companyId);
        if (company.isPresent()) {
            company.get().setName(companyUpdate.getName());
            company.get().setDescription(companyUpdate.getDescription());
            companyRepository.save(company.get());
            return true;
        }

        return false;
    }

    @Override
    public boolean deleteCompany(int id) {
        Optional<Company> company = companyRepository.findById(id);

        if (company.isPresent()) {
            List<Job> jobs = company.get().getJobs();
            jobRepository.deleteAll(jobs);
            companyRepository.delete(company.get());
            return true;
        }
        return false;
    }
}

package org.redeemerlives.firstjobapp.company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    List<Company> getAllCompanies();

    void createCompany(Company company);

    boolean updatedCompany(Company company, int companyId);

    boolean deleteCompany(int id);

    Optional<Company> getCompanyById(int id);
}

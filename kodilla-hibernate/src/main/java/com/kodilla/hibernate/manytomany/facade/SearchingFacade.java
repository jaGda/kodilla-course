package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchingFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchingFacade.class);
    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;

    @Autowired
    public SearchingFacade(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public void searchEmployeesAndCompanies(final String textFragment) throws FindEngineException {
        String fragment = "%" + textFragment + "%";
        List<Company> companies = companyDao.retrieveCompanyViaAnyTextFragment(fragment);
        List<Employee> employees = employeeDao.retrieveEmployeesViaAnyTextFragment(fragment);

        if (companies.size() < 1) {
            LOGGER.error(FindEngineException.ERR_COMPANY_NOT_FOUND);
            throw new FindEngineException(FindEngineException.ERR_COMPANY_NOT_FOUND);
        } else {
            companies.forEach(company -> System.out.println(company.getCompanyName()));
        }

        if (employees.size() < 1) {
            LOGGER.error(FindEngineException.ERR_EMPLOYEE_NOT_FOUND);
            throw new FindEngineException(FindEngineException.ERR_EMPLOYEE_NOT_FOUND);
        } else {
            employees.forEach(employee -> System.out.println(
                    employee.getFirstName() + " " + employee.getLastName()
            ));
        }
    }
}

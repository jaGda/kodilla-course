package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SearchingFacadeTestSuit {

    @Autowired
    private SearchingFacade searchingFacade;

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testSearchingFacade() {
        //Given
        Company company1 = new Company("ABC Poland");
        company1.getEmployees().add(new Employee("Jan", "Wola"));
        Company company2 = new Company("ABC Norway");
        company2.getEmployees().add(new Employee("Jan", "Kowalski"));
        Company company3 = new Company("Apple");
        company3.getEmployees().add(new Employee("Igor", "Olaf"));
        Company company4 = new Company("The Cola");
        company4.getEmployees().add(new Employee("Igor", "Kolak"));

        //When
        companyDao.save(company1);
        int company1Id = company1.getId();
        companyDao.save(company2);
        int company2Id = company2.getId();
        companyDao.save(company3);
        int company3Id = company3.getId();
        companyDao.save(company4);
        int company4Id = company4.getId();

        //Then
        try {
            searchingFacade.searchEmployeesAndCompanies("ola");
        } catch (FindEngineException e) {
            // should be handled in real app
        } finally {
            companyDao.deleteById(company1Id);
            companyDao.deleteById(company2Id);
            companyDao.deleteById(company3Id);
            companyDao.deleteById(company4Id);
        }
    }
}
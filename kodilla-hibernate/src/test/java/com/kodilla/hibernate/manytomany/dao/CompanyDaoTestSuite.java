package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testNamedQueries() {
        //Given
        Employee janKowalski = new Employee("Jan", "Kowalski");
        Employee marekKowalski = new Employee("Marek", "Kowalski");
        Employee janNowak = new Employee("Jan", "Nowak");

        Company abcPoland = new Company("ABC Poland");
        Company abcNorway = new Company("ABC Norway");
        Company apple = new Company("Apple");

        abcPoland.getEmployees().add(janKowalski);
        abcNorway.getEmployees().add(marekKowalski);
        apple.getEmployees().add(janNowak);

        janKowalski.getCompanies().add(abcPoland);
        marekKowalski.getCompanies().add(abcNorway);
        janNowak.getCompanies().add(apple);

        //When
        companyDao.save(abcPoland);
        int abcPolandId = abcPoland.getId();
        companyDao.save(abcNorway);
        int abcNorwayId = abcNorway.getId();
        companyDao.save(apple);
        int appleId = apple.getId();

        List<Employee> employees = employeeDao.retrieveEmployeesWithMatchingLastName("kowALskI");
        List<Company> companies = companyDao.retrieveCompanyNameStartWith("aBc");

        //Then
        try {
            assertEquals(2, employees.size());
            assertEquals(2, companies.size());
        } finally {
            //CleanUp
            companyDao.deleteById(abcPolandId);
            companyDao.deleteById(abcNorwayId);
            companyDao.deleteById(appleId);
        }
    }

    @Test
    void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMasters = new Company("Data Masters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(johnSmith);
        dataMasters.getEmployees().add(stephanieClarckson);
        dataMasters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMasters);
        lindaKovalsky.getCompanies().add(dataMasters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();
        companyDao.save(dataMasters);
        int dataMastersId = dataMasters.getId();

        //Then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMastersId);
        assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMastersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            // do nothing
        }
    }
}
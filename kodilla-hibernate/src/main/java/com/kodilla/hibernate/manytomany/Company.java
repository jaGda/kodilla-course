package com.kodilla.hibernate.manytomany;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Company.retrieveCompanyNameStartWith",
                query = "SELECT * FROM COMPANY " +
                        "WHERE UPPER(LEFT(COMPANY_NAME,3)) = UPPER(:COMPANY) ",
                resultClass = Company.class
        ),
        @NamedNativeQuery(
                name = "Company.retrieveCompanyViaAnyTextFragment",
                query = "SELECT * FROM COMPANY " +
                        "WHERE UPPER(COMPANY_NAME) LIKE UPPER(:ARG)",
                resultClass = Company.class
        )
})

@Entity
@Table(name = "COMPANY")
public class Company {

    private int id;
    private String companyName;
    private List<Employee> employees = new ArrayList<>();

    public Company() {
    }

    public Company(String companyName) {
        this.companyName = companyName;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "COMPANY_NAME")
    public String getCompanyName() {
        return companyName;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "companies")
    public List<Employee> getEmployees() {
        return employees;
    }

    private void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}

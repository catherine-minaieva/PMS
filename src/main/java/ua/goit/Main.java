package ua.goit;

import ua.goit.model.Company;
import ua.goit.repositoty.*;
import ua.goit.service.SqlExecutor;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DeveloperRepositoryImpl developerRepository = new DeveloperRepositoryImpl();
        CompanyRepositoryImpl companyRepository = new CompanyRepositoryImpl();
        CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();
        ProjectRepositoryImpl projectRepository = new ProjectRepositoryImpl();
        SkillRepositoryImpl skillRepository = new SkillRepositoryImpl();


        System.out.println(developerRepository.findAll());
        System.out.println(companyRepository.findAll());
        System.out.println(customerRepository.findAll());
        System.out.println(projectRepository.findAll());
        System.out.println(skillRepository.findAll());
        System.out.println("------------------------------------------------------------------------------");

        System.out.println(developerRepository.findById(2L));
        System.out.println(companyRepository.findById(2L));
        System.out.println(customerRepository.findById(2L));
        System.out.println(projectRepository.findById(2L));
        System.out.println(skillRepository.findById(2L));

        companyRepository.create(new Company(6L,  "Sigma","Lviv"));
    }
}


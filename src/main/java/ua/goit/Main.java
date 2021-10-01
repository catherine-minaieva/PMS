package ua.goit;

import ua.goit.model.*;
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
        System.out.println("------------------------------------------------------------------------------");

//        companyRepository.deleteById(2L);
//        System.out.println(companyRepository.findAll());
//
//        developerRepository.deleteById(1l);
//        System.out.println(developerRepository.findAll());
//
//        customerRepository.deleteById(10l);
//        System.out.println(customerRepository.findAll());
//
//        projectRepository.deleteById(1l);
//        System.out.println(projectRepository.findAll());
//
//        skillRepository.deleteById(1l);
//        System.out.println("------------------------------------------------------------------------------");

//        System.out.println(companyRepository.create(new Company(2L,  "Nova","Helsinki")));
//        companyRepository.update(2L,  new Company(2L, "Nova", "Poltava"));
//
//        System.out.println(developerRepository.create(new Developer(1L,"Dana", 48, "women", 2000D)));
//        developerRepository.update(12L, new Developer(12l, "Lera", 26, "women", 2000D));

        //System.out.println(customerRepository.create(new Customer(7L, "Buildery", "3543215441", "London" )));
        customerRepository.update(7L, new Customer(7L, "Integrity", "3543215441", "London"));
        //System.out.println(projectRepository.create(new Project()));


        //System.out.println(developerRepository.getDevelopersByLevel("junior"));
    }
}


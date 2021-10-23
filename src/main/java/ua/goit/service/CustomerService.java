package ua.goit.service;

import ua.goit.View.InputString;
import ua.goit.model.Customer;
import ua.goit.repositoty.CustomerRepositoryImpl;

import java.util.Collection;
import java.util.List;

public class CustomerService implements BaseService<Customer> {

    private final CustomerRepositoryImpl repository;

    public CustomerService(CustomerRepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public Customer findByID(Long id) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        Collection<Customer> all = repository.findAll();
        return (List<Customer>) all;
    }

    @Override
    public void create(Customer customer) {
        repository.create(customer);
    }

    @Override
    public void update(long ID, Customer customer) {
        repository.update(ID, customer);
    }

    @Override
    public void delete(Long ID) {
        repository.deleteById(ID);
    }

    public Customer mapCustomer(InputString input) {
        String[] parameters = input.getParameters();

        Long id = Long.parseLong(parameters[1]);
        String name = parameters[2];
        String taxCode = (parameters[3]);
        String headOffice = (parameters[3]);

        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setTaxCode(taxCode);
        customer.setHeadOffice(headOffice);

        return customer;
    }
}

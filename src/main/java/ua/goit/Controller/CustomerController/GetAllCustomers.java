package ua.goit.Controller.CustomerController;

import ua.goit.Controller.Command;
import ua.goit.View.Commands;
import ua.goit.View.InputString;
import ua.goit.View.View;
import ua.goit.service.CustomerService;

public class GetAllCustomers implements Command {

    private View view;
    private CustomerService service;

    public GetAllCustomers(View view, CustomerService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public String command() {
        return Commands.GET_ALL_CUSTOMERS;
    }

    @Override
    public void process(InputString input) {
        service.findAll().forEach(System.out::println);
    }
}

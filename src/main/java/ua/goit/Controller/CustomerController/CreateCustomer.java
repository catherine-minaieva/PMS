package ua.goit.Controller.CustomerController;

import ua.goit.Controller.Command;
import ua.goit.View.Commands;
import ua.goit.View.InputString;
import ua.goit.View.View;
import ua.goit.service.CompanyService;
import ua.goit.service.CustomerService;

public class CreateCustomer implements Command {

    private View view;
    private CustomerService service;

    public CreateCustomer(View view, CustomerService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public String command() {
        return Commands.CREATE_CUSTOMER;
    }

    @Override
    public void process(InputString input) {

    }
}

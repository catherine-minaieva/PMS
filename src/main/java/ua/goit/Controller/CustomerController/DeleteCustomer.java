package ua.goit.Controller.CustomerController;

import ua.goit.Controller.Command;
import ua.goit.View.Commands;
import ua.goit.View.InputString;
import ua.goit.View.View;
import ua.goit.service.CustomerService;

public class DeleteCustomer implements Command {

    private View view;
    private CustomerService service;

    public DeleteCustomer(View view, CustomerService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public String command() {
        return Commands.DELETE_CUSTOMER;
    }

    @Override
    public void process(InputString input) {
        int idPosition = 1;
        String id = input.getParameters()[idPosition];
        Long customerId = Long.parseLong(id);
        service.delete(customerId);
        view.write("Customer deleted");
    }
}

package ua.goit.Controller.CustomerController;

import ua.goit.Controller.Command;
import ua.goit.View.Commands;
import ua.goit.View.InputString;
import ua.goit.View.View;
import ua.goit.model.Customer;
import ua.goit.service.CustomerService;

public class GetCustomer implements Command {

    private View view;
    private CustomerService service;

    public GetCustomer(View view, CustomerService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public String command() {
        return Commands.GET_CUSTOMER;
    }

    @Override
    public void process(InputString input) {
        int idPosition = 1;
        String id = input.getParameters()[idPosition];
        Long customerID = Long.parseLong(id);
        Customer customer = service.findByID(customerID);

        if (customer.getID() == null)
            throw new IllegalArgumentException(String.format("Company with id %d not exist", customerID));

        view.write(customer.toString());
    }
}

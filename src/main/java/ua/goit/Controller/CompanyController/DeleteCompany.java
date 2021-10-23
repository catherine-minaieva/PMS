package ua.goit.Controller.CompanyController;

import ua.goit.Controller.Command;
import ua.goit.View.Commands;
import ua.goit.View.InputString;
import ua.goit.View.View;
import ua.goit.service.CompanyService;

public class DeleteCompany implements Command {

    private final View view;
    private final CompanyService service;

    public DeleteCompany(View view, CompanyService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public String command() {
        return Commands.DELETE_COMPANY;
    }

    @Override
    public void process(InputString input) {
        int idPosition = 1;
        String id = input.getParameters()[idPosition];
        Long companyID = Long.parseLong(id);

        //if (!company.isPresent())
          //  throw new IllegalArgumentException(String.format("Company with id %d not exist", companyID));

        service.delete(companyID);
        view.write("Company deleted");
    }
}

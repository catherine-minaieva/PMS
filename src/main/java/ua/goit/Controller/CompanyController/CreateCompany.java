package ua.goit.Controller.CompanyController;

import ua.goit.Controller.Command;
import ua.goit.View.Commands;
import ua.goit.View.InputString;
import ua.goit.View.View;
import ua.goit.model.Company;
import ua.goit.service.CompanyService;

public class CreateCompany implements Command {

    private View view;
    private CompanyService service;

    public CreateCompany(View view, CompanyService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public String command() {
        return Commands.CREATE_COMPANY;
    }

    @Override
    public void process(InputString input) {
        Company company = service.
                mapCompany(input);
        service.create(company);
        view.write(String.format("Company created with name - %s", company.getName()));
    }
}

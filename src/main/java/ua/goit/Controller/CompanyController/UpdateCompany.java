package ua.goit.Controller.CompanyController;

import ua.goit.Controller.Command;
import ua.goit.View.InputString;
import ua.goit.View.View;
import ua.goit.service.CompanyService;

public class UpdateCompany implements Command {

    private View view;
    private CompanyService service;

    public UpdateCompany(View view, CompanyService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public String command() {
        return null;
    }

    @Override
    public void process(InputString input) {

    }
}

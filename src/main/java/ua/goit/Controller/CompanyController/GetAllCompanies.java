package ua.goit.Controller.CompanyController;

import ua.goit.Controller.Command;
import ua.goit.View.Commands;
import ua.goit.View.InputString;
import ua.goit.View.View;
import ua.goit.service.CompanyService;

public class GetAllCompanies implements Command {

    private View view;
    private CompanyService service;

    public GetAllCompanies(View view, CompanyService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public String command() {
        return Commands.GET_ALL_COMPANIES;
    }

    @Override
    public void process(InputString input) {
        service.findAll().forEach(System.out::println);
    }
}

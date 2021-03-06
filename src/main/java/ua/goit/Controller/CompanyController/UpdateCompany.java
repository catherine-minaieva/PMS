package ua.goit.Controller.CompanyController;

import ua.goit.Controller.Command;
import ua.goit.View.Commands;
import ua.goit.View.InputString;
import ua.goit.View.View;
import ua.goit.model.Company;
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
        return Commands.UPDATE_COMPANY;
    }

    @Override
    public void process(InputString input) {
        int idPosition = 1;
        String id = input.getParameters()[idPosition];
        Long companyId = Long.parseLong(id);
        Company company = service.findByID(companyId);

        if (company.getID() == null)
            throw new IllegalArgumentException(String.format("Company with id %d not exist", companyId));

        Company companyForUpdate = service.mapCompany(input);
        service.update(companyId, companyForUpdate);
        view.write(String.format("Company with name - %s updated", company.getName()));
    }
}

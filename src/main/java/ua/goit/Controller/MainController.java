package ua.goit.Controller;

import ua.goit.Controller.CompanyController.*;
import ua.goit.Controller.CustomerController.*;
import ua.goit.Controller.DeveloperController.*;
import ua.goit.Controller.ProjectController.*;
import ua.goit.Controller.QueryController.*;
import ua.goit.Controller.SkillContoller.*;
import ua.goit.View.InputString;
import ua.goit.View.View;
import ua.goit.exeption.ExitException;
import ua.goit.repositoty.*;
import ua.goit.service.*;

import java.util.Arrays;
import java.util.List;

public class MainController {
    private final View view;
    private List<Command> commands;

    public MainController(View view) {
        this.view = view;
        DeveloperServiceImpl developerService = new DeveloperServiceImpl(new DeveloperRepositoryImpl());
        CompanyService companyService = new CompanyService(new CompanyRepositoryImpl());
        CustomerService customerService = new CustomerService(new CustomerRepositoryImpl());
        ProjectService projectService = new ProjectService(new ProjectRepositoryImpl());
        SkillService skillService = new SkillService(new SkillRepositoryImpl());
        QueryServiceImpl queryService = new QueryServiceImpl(new QueryRepositotyImpl());
        this.commands = Arrays.asList(

                new CreateDeveloper(view, developerService),
                new DeleteDeveloper(view, developerService),
                new GetDeveloper(view, developerService),
                new GetAllDevelopers(view, developerService),
                new UpdateDeveloper(view, developerService),

                new CreateCompany(view, companyService),
                new DeleteCompany(view, companyService),
                new GetAllCompanies(view, companyService),
                new UpdateCompany(view, companyService),
                new GetCompany(view, companyService),

                new CreateCustomer(view, customerService),
                new DeleteCustomer(view, customerService),
                new UpdateCustomer(view, customerService),
                new GetCustomer(view, customerService),
                new GetAllCustomers(view, customerService),

                new CreateProject(view, projectService),
                new DeleteProject(view, projectService),
                new UpdateProject(view, projectService),
                new GetProject(view, projectService),
                new GetAllProjects(view, projectService),

                new CreateSkill(view, skillService),
                new DeleteSkill(view, skillService),
                new UpdateSkill(view, skillService),
                new GetSkill(view, skillService),
                new GetAllSkills(view, skillService),

                new GetSumOfSalariesForProject(view, queryService),
                new GetDevelopersByLanguage(view,queryService),
                new GetDevelopersByLevel(view, queryService),
                new GetDevelopersOfProject(view, queryService),
                new GetProjectsWithDate(view, queryService),

                new Exit(view)
        );
    }

    public void read() {
        view.write("""
                Hello! This is the Project Management System

                For create or update an object you can use commands create|update with the same arguments in such way:
                create_developer|id|name|age|gender|salary
                create_project|id|name|base_technology|creation_date|cost
                create_customer|id|name|tax_code|head_office
                create_skill|id|language|level
                create_company|id|name|head_office

                get_all_developers   or  (projects|customers|companies|skills)
                get_developer|id     or  (project|customer|company|skill)
                delete_developer|id  or (project|customer|company|skill)

                You can also use commands:
                get_sum_of_project|id
                get_projects_with_date
                get_developers_level|level
                get_developers_language|language
                get_developers_project|id
                """);

        view.write("Enter a command:");
        try {
            doCommand();
        } catch (ExitException e) {
            e.printStackTrace();
        }
    }

    private void doCommand() {
        while (true) {
            InputString entry = new InputString(view.read());
            for (Command command : commands) {
                try {
                    if (command.canProcess(entry)) {
                        entry.validateParameters(command.command());
                        command.process(entry);
                        break;
                    }
                } catch (Exception e) {
                    if (e instanceof ExitException) {
                        throw e;
                    }
                    printError(e);
                    break;
                }
            }
        }
    }

    private void printError(Exception e) {
        String message = e.getMessage();
        view.write("Error because of " + message);
        view.write("Please try again");
    }
}

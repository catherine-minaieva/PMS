package ua.goit.Controller;

import ua.goit.View.Commands;
import ua.goit.View.InputString;
import ua.goit.View.View;

public class Help implements Command{

    private View view;

    public Help(View view) {
        this.view = view;
    }
    @Override
    public String command() {
        return Commands.HELP;
    }

    @Override
    public void process(InputString input) {
        view.write("For create or update an object you can use commands create|update with the same arguments in such way:\n" +
                "create_developer|id|name|age|gender|salary\n" +
                "create_project|id|name|base_technology|creation_date|cost\n" +
                "create_customer|id|name|tax_code|head_office\n" +
                "create_skill|id|language|level\n" +
                "create_company|id|name|head_office\n" +
                "\n" +
                "get_all_developers   or  (projects|customers|companies|skills)\n" +
                "get_developer|id     or  (project|customer|company|skill)\n" +
                "delete_developer|id  or (project|customer|company|skill)\n" +
                "\n" +
                "You can also use commands:\n" +
                "get_sum_of_project|id\n" +
                "get_projects_with_date\n" +
                "get_developers_level|level\n" +
                "get_developers_language|language\n" +
                "get_developers_project|id\n" +
                "" +
                "\n" +
                "Enter a command");
    }
}

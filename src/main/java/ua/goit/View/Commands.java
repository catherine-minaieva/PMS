package ua.goit.View;

public class Commands {
    public static final String CREATE_DEVELOPER = "create_developer|id|name|age|gender|salary";
    public static final String CREATE_PROJECT = "create_project|id|name|base_technology|creation_date|cost";
    public static final String CREATE_CUSTOMER = "create_customer|id|name|tax_code|head_office";
    public static final String CREATE_SKILL = "create_skill|id|language|level";
    public static final String CREATE_COMPANY = "create_company|id|name|head_office";

    public static final String GET_ALL_DEVELOPERS = "get_all_developers";
    public static final String GET_ALL_PROJECTS = "get_all_projects";
    public static final String GET_ALL_CUSTOMERS = "get_all_customers";
    public static final String GET_ALL_SKILLS = "get_all_skills";
    public static final String GET_ALL_COMPANIES = "get_all_companies";

    public static final String DELETE_DEVELOPER = "delete_developer|id";
    public static final String DELETE_PROJECT = "delete_project|id";
    public static final String DELETE_SKILL = "delete_skill|id";
    public static final String DELETE_CUSTOMER = "delete_customer|id";
    public static final String DELETE_COMPANY = "delete_company|id";

    public static final String GET_DEVELOPER = "get_developer|id";
    public static final String GET_PROJECT = "get_project|id";
    public static final String GET_SKILL = "get_skill|id";
    public static final String GET_CUSTOMER = "get_customer|id";
    public static final String GET_COMPANY = "get_company|id";

    public static final String UPDATE_DEVELOPER = "update_developer|id";
    public static final String UPDATE_PROJECT = "update_project|id";
    public static final String UPDATE_SKILL = "update_skill|id";
    public static final String UPDATE_CUSTOMER = "update_customer|id";
    public static final String UPDATE_COMPANY = "update_company|id";

    public static final String GET_SUM_OF_PROJECT = "get_sum_of_project|id";
    public static final String GET_PROJECTS_DATE = "get_projects_with_date";
    public static final String GET_DEVELOPERS_LEVEL = "get_developers_level|level";
    public static final String GET_DEVELOPERS_LANGUAGE = "get_developers_language|language";
    public static final String GET_DEVELOPERS_PROJECT = "get_developers_project|id";

    public static final String EXIT = "exit";


}

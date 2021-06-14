package com.cg.employee.constants;

public class Constants {
	
	//Expense & Project
	public static final String NAME_PATTERN = "^[a-zA-Z0-9_ ]*$";
	public static final String DATE_PATTERN = "\\d{4}-\\d{2}-\\d{2}";
	public static final String DESCRIPTION_PATTERN = "^[a-zA-Z0-9_ ]*$";
	
	//login & employee
	public static final String USERNAME_PATTERN = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=_])(?=\\S+$).{8,}$";
	public static final String PASSWORD_PATTERN = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=_])(?=\\S+$).{8,}$";
	public static final String ROLE_PATTERN = "([A-Za-z])|([a-zA-Z]+)";	
	
	//login
	public static final String USER_ADDED = "User added successfully!";
	public static final String USER_DELETED = "User details with id is deleted successfully!";
	public static final String USER_VALIDATION = "User details met all the contraints!";
	public static final String NAME_CANNOT_BE_EMPTY = "User name should be atleast 8 characters, including special characters!";
	public static final String PASSWORD_CANNOT_BE_EMPTY = "Use atleast 8 characters, including special characters!";
	public static final String ROLE_CANNOT_BE_EMPTY = "Role invalid!";
	public static final String USER_ID_EXISTS = "This userId already exist!";
	public static final String USER_NAME_EXISTS = "This user name already exist!";
	public static final String USER_ID_DOES_NOT_EXISTS = "This userId doesn't exist!";
	public static final String LOGOUT_FAILED = "logout failed!";
	
	//Employee
	public static final String EMAILID_PATTERN = "^[a-z0-9]+@[a-z]+\\.[a-z]{2,4}$";
	public static final String EMAIL_CANNOT_BE_EMPTY = "Emailid cannot be empty!";	
	public static final String EMP_PAN_PATTERN = "([A-Z]{5}[0-9]{4}[A-Z]{1})";
	public static final String PAN_CANNOT_BE_EMPTY = "Employee Pan cannot be empty!";
	public static final String DESIGNATION_PATTERN = "([A-Za-z])|([a-zA-Z]+)";
	public static final String DESIGNATION_CANNOT_BE_EMPTY = "Employee designation cannot be empty!";
	public static final String DOMAIN_PATTERN = "([A-Za-z])|([a-zA-Z]+)";
	public static final String DOMAIN_CANNOT_BE_EMPTY = "Domain cannot be empty!";
	public static final String INVALID_DATE_FORMAT = "Please follow yyyy-mm-dd";
	public static final String SALARY_PATTERN = "[0-9]+(\\.{1})[0-9]+{2}";
	public static final String SALARY_CANNOT_BE_EMPTY = "Employee salary cannot be empty";
	public static final String EMPLOYEE_DOES_NOT_EXISTS = "Employee with this id doesn't exist!";
	public static final String NO_EMPLOYEES = "Employees doesn't exist!";
	public static final String EMPLOYEE_ADDED = "Employee added successfully!";
	public static final String EMPLOYEE_UPDATED = "Employee updated successfully!";
	public static final String EMPLOYEE_DELETED = "Employee deleted successfully!";	
	
	//ExpenseClaim
	public static final String EXPENSECLAIM_NOT_FOUND = "Expense claim is not found!";
	public static final String WRONG_DATE_INPUT = "Please check your start date!";
	public static final String NO_EXPENSECLAIMS = "There are no expenseclaimes found!";
	
	//Expense
	public static final String EXPENSE_DESCRIPTION_CANNOT_BE_EMPTY = "Expense description cannot be empty!";
	public static final String EXPENSE_TYPE_CANNOT_BE_EMPTY = "Expense type cannot be empty!";
	public static final String EXPENSE_NOT_FOUND = "Expense for project is not found!";
	public static final String EXPENSE_ADDED = "Expense added successfully!";
	public static final String EXPENSE_UPDATED = "Expense updated successfully!";
	public static final String EXPENSE_DELETED = "Expense by this id is deleted successfully!";
	public static final String DELETE_ALLEXPENSES = "All the expenses are deleted successfully!";
	public static final String NO_EXPENSE_RECORDS_FOUND = "No record is found to delete!";
	
	//Project
	public static final String START_DATE_CANNOT_BE_EMPTY = "Start date cannot be empty!";
	public static final String END_DATE_CANNOT_BE_EMPTY = "End date cannot be empty!";
	public static final String PROJECT_DESCRIPTION_CANNOT_BE_EMPTY = "Project description cannot be empty!";
	public static final String PROJECT_ADDED = "Project added successfully!";
	public static final String PROJECT_UPDATED = "Project updated successfully!";
	public static final String PROJECT_DELETED = "Project deleted successfully!";
	public static final String PROJECT_NOT_FOUND = "Project not found!";
	public static final String NO_PROJECTS_IDS = "There are no project ids to display!";
	public static final String NO_PROJECTS = "There are no projects to display!";
}



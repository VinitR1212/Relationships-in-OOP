import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  private ArrayList<Employee> employees = new ArrayList<>();

  public void addEmployee(Employee employee) {
    employees.add(employee);
  }

  public double calculatePay(int id) {
    for (Employee employee : employees) {
      if (employee.getId() == id) {
        return employee.getSalary();
      }
    }
    return 0.0;
  }

  public void displayEmployeeDetails(int id) {
    for (Employee employee : employees) {
      if (employee.getId() == id) {
        System.out.println("Employee Details:");
        System.out.println("ID: " + employee.getId());
        System.out.println("Name: " + employee.getName());
        System.out.println("Salary: $" + employee.getSalary());
        employee.displayAdditionalInfo();
        break;
      }
    }
  }

  public static void main(String[] args) {
    Main company = new Main();
    Scanner scanner = new Scanner(System.in);

    System.out.println("Welcome to the Employee Management System!");

    while (true) {
      System.out.println("\nSelect an option:");
      System.out.println("1. Add Employee");
      System.out.println("2. Display Employee Details");
      System.out.println("3. Exit");
      int option = scanner.nextInt();

      switch (option) {
        case 1:
          addEmployeeMenu(company, scanner);
          break;
        case 2:
          displayEmployeeDetailsMenu(company, scanner);
          break;
        case 3:
          System.out.println("Exiting the program...");
          scanner.close();
          return;
        default:
          System.out.println("Invalid option. Please try again.");
      }
    }
  }

  private static void addEmployeeMenu(Main company, Scanner scanner) {
    System.out.println("\nSelect Employee Type:");
    System.out.println("1. Manager");
    System.out.println("2. Supervisor");
    System.out.println("3. Worker");
    System.out.println("4. CEO");

    int employeeType = scanner.nextInt();

    System.out.println("Enter Employee ID:");
    int id = scanner.nextInt();

    System.out.println("Enter Employee Name:");
    String name = scanner.next();

    System.out.println("Enter Employee Salary:");
    double salary = scanner.nextDouble();

    switch (employeeType) {
      case 1:
        System.out.println("Enter Department:");
        String department = scanner.next();
        company.addEmployee(new Manager(id, name, salary, department));
        break;
      case 2:
        System.out.println("Enter Team Size:");
        int teamSize = scanner.nextInt();
        company.addEmployee(new Supervisor(id, name, salary, teamSize));
        break;
      case 3:
        System.out.println("Enter Hours Worked:");
        int hoursWorked = scanner.nextInt();
        company.addEmployee(new Worker(id, name, salary, hoursWorked));
        break;
      case 4:
        System.out.println("Enter Company Owned:");
        String companyOwned = scanner.next();
        company.addEmployee(new CEO(id, name, salary, companyOwned));
        break;
      default:
        System.out.println("Invalid employee type.");
    }

    System.out.println("Employee added successfully!");
  }

  private static void displayEmployeeDetailsMenu(Main company, Scanner scanner) {
    System.out.println("Enter employee ID to display details:");
    int id = scanner.nextInt();
    company.displayEmployeeDetails(id);
  }
}

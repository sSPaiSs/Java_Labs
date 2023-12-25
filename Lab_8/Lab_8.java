package Lab8;

import java.util.*;

class Employee {
    private String firstName;
    private String lastName;
    private double salary;

    public Employee(String firstName, String lastName, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }
}

class Department implements Iterable<Employee> {
    private String name;
    private String manager;
    private Set<Employee> employees;

    public Department(String name, String manager) {
        this.name = name;
        this.manager = manager;
        this.employees = new HashSet<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public Iterator<Employee> iterator() {
        return employees.iterator();
    }

    public double getManagerSalary() {
        return 0.0;
    }

    public String getName() {
        return name;
    }

    // Getter для employees
    public Set<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", manager='" + manager + '\'' +
                ", employees=" + employees +
                '}';
    }
}

class Company implements Iterable<Employee> {
    private String name;
    private String director;
    private Set<Department> departments;

    public Company(String name, String director) {
        this.name = name;
        this.director = director;
        this.departments = new HashSet<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    @Override
    public Iterator<Employee> iterator() {
        List<Employee> allEmployees = new ArrayList<>();
        for (Department department : departments) {
            Iterator<Employee> iterator = department.iterator();
            while (iterator.hasNext()) {
                allEmployees.add(iterator.next());
            }
        }
        return allEmployees.iterator();
    }

    public Set<Employee> getAllEmployeesSet() {
        Set<Employee> allEmployees = new HashSet<>();
        for (Department department : departments) {
            allEmployees.addAll(department.getEmployees());
        }
        return allEmployees;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public String getDirector() {
        return director;
    }

    public void addEmployeeToDepartment(Employee employee, Department department) {
        department.addEmployee(employee);
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", departments=" + departments +
                '}';
    }
}

public class Lab8 {
    public static void main(String[] args) {
        Company company = new Company("XYZ Corp", "John Doe");

        Department hrDepartment = new Department("HR", "HR Manager");
        hrDepartment.addEmployee(new Employee("Alice", "Johnson", 50000));
        hrDepartment.addEmployee(new Employee("Bob", "Smith", 60000));
        company.addDepartment(hrDepartment);

        Department itDepartment = new Department("IT", "IT Manager");
        itDepartment.addEmployee(new Employee("Charlie", "Brown", 70000));
        itDepartment.addEmployee(new Employee("David", "Williams", 80000));
        company.addDepartment(itDepartment);

        double maxSalary = Double.MIN_VALUE;
        for (Employee employee : company) {
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
            }
        }
        System.out.println("Максимальна заробітна платня: " + maxSalary);

        for (Department department : company.getDepartments()) {
            Iterator<Employee> iterator = department.iterator();
            while (iterator.hasNext()) {
                Employee employee = iterator.next();
                if (employee.getSalary() > department.getManagerSalary()) {
                    System.out.println("Відділ, де співробітник отримує більше, ніж начальник: " + department.getName());
                    break;
                }
            }
        }

        for (Employee employee : company.getAllEmployeesSet()) {
            System.out.println("Ім'я: " + employee.getFirstName() + ", Прізвище: " + employee.getLastName() + ", Зарплата: " + employee.getSalary());
        }

        System.out.println("Директор компанії: " + company.getDirector());

        Employee newEmployee = new Employee("Eva", "Green", 90000);
        company.addEmployeeToDepartment(newEmployee, itDepartment);

        System.out.println(company);
    }
}


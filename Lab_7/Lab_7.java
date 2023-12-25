package Lab_7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
}

class Department implements Iterable<Employee> {
    private String name;
    private String manager;
    private List<Employee> employees;

    public Department(String name, String manager) {
        this.name = name;
        this.manager = manager;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Iterator<Employee> iterator() {
        return employees.iterator();
    }

    public double getManagerSalary() {
        // Логіка для отримання заробітної платні начальника
        return 0.0;
    }

    public String getName() {
        return name;
    }
}

class Company implements Iterable<Employee> {
    private String name;
    private String director;
    private List<Department> departments;

    public Company(String name, String director) {
        this.name = name;
        this.director = director;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

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

    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees = new ArrayList<>();
        for (Department department : departments) {
            Iterator<Employee> iterator = department.iterator();
            while (iterator.hasNext()) {
                allEmployees.add(iterator.next());
            }
        }
        return allEmployees;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public String getDirector() {
        return director;
    }
}

public class Lab_7 {
    public static void main(String[] args) {
        Company company = new Company("XYZ Corp", "John Doe");

        // Додавання департаментів та працівників до фірми
        Department hrDepartment = new Department("HR", "HR Manager");
        hrDepartment.addEmployee(new Employee("Alice", "Johnson", 50000));
        hrDepartment.addEmployee(new Employee("Bob", "Smith", 60000));
        company.addDepartment(hrDepartment);

        Department itDepartment = new Department("IT", "IT Manager");
        itDepartment.addEmployee(new Employee("Charlie", "Brown", 70000));
        itDepartment.addEmployee(new Employee("David", "Williams", 80000));
        company.addDepartment(itDepartment);

        // 1) Знайти значення максимальної заробітної платні з усіх працівників, включаючи начальників та директора - типізований цикл «for-each»:
        double maxSalary = Double.MIN_VALUE;
        for (Employee employee : company) {
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
            }
        }
        System.out.println("Максимальна заробітна платня: " + maxSalary);

        // 2) Визначити, в якому відділі хоча б один з співробітників отримує заробітну платню вищу за платню свого начальника - типізований ітератор:
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

        // 3) Скласти список усіх співробітників фірми, включаючи начальників та директора - нетипізований ітератор:
        for (Employee employee : company.getAllEmployees()) {
            System.out.println("Ім'я: " + employee.getFirstName() + ", Прізвище: " + employee.getLastName() + ", Зарплата: " + employee.getSalary());
        }

        // Додатково:
        System.out.println("Директор компанії: " + company.getDirector());
    }
}

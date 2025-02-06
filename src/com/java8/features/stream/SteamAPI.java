package com.java8.features.stream;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class SteamAPI {
    Logger logger = Logger.getLogger("SteamAPI");
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "HR", 55000, 28),
                new Employee(2, "Bob", "IT", 70000, 32),
                new Employee(3, "Charlie", "Finance", 80000, 45),
                new Employee(4, "David", "IT", 65000, 26),
                new Employee(5, "Eve", "HR", 72000, 41)
        );

        // Filter employees with salary greater than 60000
        filteringEmployeeBasedOnCondition(employees);
        sortEmployeeBasedOnSalaryNAge(employees);
        getListOfEmployeeName(employees);
        calculatingSumAverageMinAndMax(employees);
        groupingEmployeesByDepartment(employees);
        partitioningEmployeesBasedOnSalary(employees);
        countingEmployeesInEachDepartment(employees);
        checkingAllAnyOrNoneConditions(employees);
        findingSumOrCustomAggregation(employees);
        creatingCustomCollectors(employees);
        findingTheOldestAndYoungestEmployee(employees);

    }

    private static void findingTheOldestAndYoungestEmployee(List<Employee> employees) {
        Employee employeeYoungest = employees.stream().min(Comparator.comparing(Employee::getAge)).get();
        out.println(employeeYoungest);
        int youngestAge = employees.stream().mapToInt(Employee::getAge).min().getAsInt();
        out.println(youngestAge);

        Employee employeeOldest = employees.stream().max(Comparator.comparing(Employee::getAge)).get();
        out.println(employeeOldest);
        int oldestAge = employees.stream().mapToInt(Employee::getAge).max().getAsInt();
        out.println(oldestAge);
    }

    private static void creatingCustomCollectors(List<Employee> employees) {
        // Concatenate all employee names into a single string
        String concatenatedNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", "));
        out.println("Concatenated Names: " + concatenatedNames);
    }

    private static void findingSumOrCustomAggregation(List<Employee> employees) {
        // Sum of salaries using reduce
        double sumSalaries = employees.stream()
                .map(Employee::getSalary)
                .reduce(0, Integer::sum);
        out.println("Sum of Salaries (reduce): " + sumSalaries);
    }

    private static void checkingAllAnyOrNoneConditions(List<Employee> employees) {
        boolean isHighSalary = employees.stream().allMatch(employee -> employee.getSalary() > 65000);
        out.println(isHighSalary);
        boolean isAverageSalary = employees.stream().anyMatch(employee -> employee.getSalary() > 50000);
        out.println(isAverageSalary);

        boolean isAnyHR = employees.stream().anyMatch(employee -> employee.getDepartment() == "HR");
        out.println(isAnyHR);


    }

    private static void countingEmployeesInEachDepartment(List<Employee> employees) {
        Map<String, Long> employeeCtByDepartment = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        out.println(employeeCtByDepartment);
    }

    private static void partitioningEmployeesBasedOnSalary(List<Employee> employees) {
        employees.stream().filter(employee -> employee.getSalary() > 65000).collect(Collectors.toList()).forEach(employee -> {
            out.println(employee);
        });
    }

    private static void groupingEmployeesByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> groupedByDepartment = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        out.println(groupedByDepartment);
    }

    private static void calculatingSumAverageMinAndMax(List<Employee> employees) {
        List<Integer> salaries = employees.stream().map(Employee::getSalary).sorted().collect(Collectors.toList());
        int salarySum = employees.stream().mapToInt(Employee::getSalary).sum();
        int salaryMin = employees.stream().mapToInt(Employee::getSalary).min().getAsInt();
        int salaryMax = employees.stream().mapToInt(Employee::getSalary).max().getAsInt();
        int salaryAvg = (int)employees.stream().mapToInt(Employee::getSalary).average().getAsDouble();
        out.println(salaries);
        out.println(salarySum);
        out.println(salaryMin);
        out.println(salaryMax);
        out.println(salaryAvg);
    }

    private static void getListOfEmployeeName(List<Employee> employees) {
        List<String> employeeNames = employees.stream().map(Employee::getName).toList();
        out.println(employeeNames);
        List<String> employeeList = employees.stream().map(Employee::getName).collect(Collectors.toList());

    }

    private static void sortEmployeeBasedOnSalaryNAge(List<Employee> employees) {
        out.println(employees.stream().sorted(Comparator.comparing(Employee::getSalary)).toList());
        employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).toList().forEach(out::println);
        employees.stream().sorted(Comparator.comparing(Employee::getAge)).toList().forEach(employee -> out.println(employee.getName() +", " +employee.getAge()));

    }

    private static void filteringEmployeeBasedOnCondition(List<Employee> employees) {
        List<Employee> highEarners = employees.stream().filter(employee -> employee.salary> 60000).toList();
        highEarners.forEach(employee -> {
            out.println(employee.getName());
        });

        employees.stream().filter(employee -> employee.salary > 60000).forEach(employee ->
                out.println(employee.getName()));

        //get count
        out.println(employees.stream().filter(employee -> employee.getSalary() > 65000).count());
    }
}

class Employee {
    private int id;
    private String name;
    private int age;
    public int salary;
    private String department;
    public Employee(int id, String name, String department, int salary, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}
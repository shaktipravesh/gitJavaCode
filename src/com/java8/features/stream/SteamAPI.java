package com.java8.features.stream;

import java.util.*;
import java.util.stream.Collectors;

public class SteamAPI {
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
        System.out.println(employeeYoungest);
        int youngestAge = employees.stream().mapToInt(Employee::getAge).min().getAsInt();
        System.out.println(youngestAge);

        Employee employeeOldest = employees.stream().max(Comparator.comparing(Employee::getAge)).get();
        System.out.println(employeeOldest);
        int oldestAge = employees.stream().mapToInt(Employee::getAge).max().getAsInt();
        System.out.println(oldestAge);
    }

    private static void creatingCustomCollectors(List<Employee> employees) {
        // Concatenate all employee names into a single string
        String concatenatedNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", "));
        System.out.println("Concatenated Names: " + concatenatedNames);
    }

    private static void findingSumOrCustomAggregation(List<Employee> employees) {
        //double sumSalaries = employees.stream().map(Employee::getSalary).reduce(0.0, Double::sum);
        // Sum of salaries using reduce
        double sumSalaries = employees.stream()
                .map(Employee::getSalary)
                .reduce(0, Integer::sum);
        System.out.println("Sum of Salaries (reduce): " + sumSalaries);
    }

    private static void checkingAllAnyOrNoneConditions(List<Employee> employees) {
        boolean isHighSalary = employees.stream().allMatch(employee -> employee.getSalary() > 65000);
        System.out.println(isHighSalary);
        boolean isAverageSalary = employees.stream().anyMatch(employee -> employee.getSalary() > 50000);
        System.out.println(isAverageSalary);

        boolean isAnyHR = employees.stream().anyMatch(employee -> employee.getDepartment() == "HR");
        System.out.println(isAnyHR);


    }

    private static void countingEmployeesInEachDepartment(List<Employee> employees) {
        Map<String, Long> employeeCtByDepartment = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(employeeCtByDepartment);
    }

    private static void partitioningEmployeesBasedOnSalary(List<Employee> employees) {
        employees.stream().filter(employee -> employee.getSalary() > 65000).collect(Collectors.toList()).forEach(employee -> {
            System.out.println(employee);
        });
    }

    private static void groupingEmployeesByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> groupedByDepartment = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(groupedByDepartment);
    }

    private static void calculatingSumAverageMinAndMax(List<Employee> employees) {
        List<Integer> salaries = employees.stream().map(Employee::getSalary).sorted().collect(Collectors.toList());
        int salarySum = employees.stream().mapToInt(Employee::getSalary).sum();
        int salaryMin = employees.stream().mapToInt(Employee::getSalary).min().getAsInt();
        int salaryMax = employees.stream().mapToInt(Employee::getSalary).max().getAsInt();
        int salaryAvg = (int)employees.stream().mapToInt(Employee::getSalary).average().getAsDouble();
        System.out.println(salaries);
        System.out.println(salarySum);
        System.out.println(salaryMin);
        System.out.println(salaryMax);
        System.out.println(salaryAvg);
    }

    private static void getListOfEmployeeName(List<Employee> employees) {
        List<String> employeeNames = employees.stream().map(Employee::getName).toList();
        System.out.println(employeeNames);
        List<String> employeeList = employees.stream().map(Employee::getName).collect(Collectors.toList());
    }

    private static void sortEmployeeBasedOnSalaryNAge(List<Employee> employees) {
        System.out.println(employees.stream().sorted(Comparator.comparing(Employee::getSalary)).toList());
        employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).toList().forEach(System.out::println);
        employees.stream().sorted(Comparator.comparing(Employee::getAge)).toList().forEach(employee -> System.out.println(employee.getName() +", " +employee.getAge()));

    }

    private static void filteringEmployeeBasedOnCondition(List<Employee> employees) {
        List<Employee> highEarners = employees.stream().filter(employee -> employee.salary> 60000).toList();
        highEarners.forEach(employee -> {
            System.out.println(employee.getName());
        });

        employees.stream().filter(employee -> employee.salary > 60000).forEach(employee ->
                System.out.println(employee.getName()));

        //get count
        System.out.println(employees.stream().filter(employee -> employee.getSalary() > 65000).count());
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
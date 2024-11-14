package com.java.designpatterns.creational.builder.personaldetail;

public class PersonalDetail {
    String firstName;
    String lastName;
    int age;

    @Override
    public String toString() {
        return "PersonalDetail{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    public PersonalDetail(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

}

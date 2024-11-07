package com.java.designpatterns.builder.personaldetail;

public class PersonalDetailBuilder {
    String firstName;
    String lastName;
    int age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    PersonalDetail getPersonalDetail() {
        return new PersonalDetail(firstName, lastName, age);
    }
}

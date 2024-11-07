package com.java.designpatterns.builder.personaldetail;

public class PersonalDetailBuilder {
    String firstName;
    String lastName;
    int age;

    public String getFirstName() {
        return firstName;
    }

    public PersonalDetailBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public PersonalDetailBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public int getAge() {
        return age;
    }

    public PersonalDetailBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    PersonalDetail getPersonalDetail() {
        return new PersonalDetail(firstName, lastName, age);
    }
}

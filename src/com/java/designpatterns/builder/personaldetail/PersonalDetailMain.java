package com.java.designpatterns.builder.personaldetail;

public class PersonalDetailMain {
    public static void main(String[] args) {
        PersonalDetailBuilder builder = new PersonalDetailBuilder();
        builder.setFirstName("John");
        builder.setLastName("Doe");
        builder.setAge(23);
        builder.getPersonalDetail();
        System.out.println(builder.getPersonalDetail());

        PersonalDetail personalDetail = new PersonalDetailBuilder().setAge(42).setFirstName("Shakti").setLastName("Pravesh").getPersonalDetail();
        System.out.println(personalDetail);
    }
}

package com.java.problems.code360;

import java.util.Scanner;

public class TotalSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalSalary = 0;
        int roundOff = 0;
        int gradePay = 0;
        int basic = sc.nextInt();
        String grade = sc.next();
        char cGrade = grade.charAt(0);
        gradePay = (cGrade == 'A'? 1700 : (cGrade == 'B' ? 1500 : 1300));
        totalSalary += basic + gradePay;
        float variablePercent = 5.9f;
        float variable =basic*variablePercent;

        roundOff = (int)(variable);
        if(roundOff % 10 >=5) {
            roundOff =roundOff/10 + 1;
        } else {
            roundOff =roundOff/10;
        }

        totalSalary +=roundOff;
        System.out.println(totalSalary);
    }
}

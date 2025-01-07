package com.java.problems.code360;

import java.util.Scanner;

class ComplexNumbers {
    int real;
    int complex;
    ComplexNumbers(int real, int complex) {
        this.real = real;
        this.complex = complex;
    }

    public ComplexNumbers() {
    }

    void plus(ComplexNumbers complexNumbers1, ComplexNumbers complexNumbers2) {
        this.real = complexNumbers2.real + complexNumbers1.real;
        this.complex = complexNumbers2.complex + complexNumbers1.complex;
        print();
    }

    void multiply(ComplexNumbers complexNumbers1, ComplexNumbers complexNumbers2) {
        this.real = complexNumbers2.real * complexNumbers1.real - complexNumbers2.complex * complexNumbers1.complex;
        this.complex = complexNumbers2.real * complexNumbers1.complex + complexNumbers2.complex*complexNumbers1.real;
        print();
    }

    void print() {
        System.out.println(this.real + " + i" + this.complex);
    }

}

public class ComplexNumberClass {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        ComplexNumbers complexNumber1 = new ComplexNumbers(sc.nextInt(), sc.nextInt());
        ComplexNumbers complexNumber2 = new ComplexNumbers(sc.nextInt(), sc.nextInt());
        int operation = sc.nextInt();
        ComplexNumbers result = new ComplexNumbers();
        if (operation == 1) {
            result.plus(complexNumber1, complexNumber2);
        } else if (operation == 2) {
            result.multiply(complexNumber1, complexNumber2);
        }

    }
}
		
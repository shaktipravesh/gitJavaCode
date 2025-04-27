package com.java.theory.inheritence;

import static java.lang.System.*;

public class StaticInInheritence {
    public static void main(String[] args) {
        out.println(Parent.name);
        out.println(Child.name);

        Parent p = new Child();
        Parent p2 = new Parent();
        Parent.show();
        Child.show();
        p.NonStaticShow();
        p2.NonStaticShow();
    }

}

class Parent {
    static String name = "Hello Parent.";
    static void show() {
        out.println("Static Show Parent.");
    }

    void NonStaticShow() {
        out.println("Non Static Show Parent.");
    }

    static {
        out.println("Static Init Parent.");
    }
}

class Child extends Parent {
    static String name = "Hello Child";
    static void show() {
        out.println("Static Show Child.");
    }
    void NonStaticShow() {
        out.println("Non Static Show Child.");
    }

    static {
        out.println("Static Init Child.");
    }
}

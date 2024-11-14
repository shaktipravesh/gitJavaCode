package com.java.designpatterns.creational.prototype;

public class PrototypeMain {
    public static void main(String[] args) {
        BookShop bookShop = new BookShop();
        bookShop.setShopName("Prototype Shop");
        bookShop.getBookList();
        System.out.println(bookShop);

        BookShop bookShop1 = new BookShop();
        bookShop1.setShopName("Prototype Shop 1");
        System.out.println(bookShop1);

        BookShop bookShop2 = new BookShop();
        bookShop2.setShopName("Prototype Shop 2");
        bookShop2.getBookList();
        System.out.println(bookShop2);

        BookShop bookShop3 = null;
        try {
            bookShop3 = (BookShop) bookShop.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        bookShop3.setShopName("Prototype Shop 3");
        System.out.println(bookShop3);

        System.out.println();
        bookShop.books.remove(2);
        System.out.println(bookShop);
        System.out.println(bookShop2);
        System.out.println(bookShop3);

    }
}

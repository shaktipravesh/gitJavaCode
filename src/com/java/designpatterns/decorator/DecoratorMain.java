package com.java.designpatterns.decorator;

abstract class BasePizza {
    public abstract int pricePizza();
}

class FarmHouse extends BasePizza {
    @Override
    public int pricePizza() {
        return 20;
    }
}

class CountryDelight extends BasePizza {
    @Override
    public int pricePizza() {
        return 25;
    }
}

class FarmFeast extends BasePizza {
    @Override
    public int pricePizza() {
        return 30;
    }
}

abstract class ToppingDecorator extends BasePizza {
}

class ExtraCheese extends ToppingDecorator {
    BasePizza basePizza;
    public ExtraCheese(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int pricePizza() {
        return this.basePizza.pricePizza() + 5;
    }
}

class Mushroom extends ToppingDecorator {
    BasePizza basePizza;
    Mushroom(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int pricePizza() {
        return this.basePizza.pricePizza() + 6;
    }
}
public class DecoratorMain {
    public static void main(String[] args) {
        //CountryDelight + ExtraCheese
        BasePizza basePizza = new CountryDelight();
        System.out.println(basePizza.pricePizza());
        basePizza = new ExtraCheese(basePizza);
        System.out.println(basePizza.pricePizza());
        basePizza = new Mushroom(basePizza);
        System.out.println(basePizza.pricePizza());

    }
}

package com.java.designpatterns.decorator;
 
interface BaseBike {
    public abstract int priceBike();
}

class MountainBike implements BaseBike {
    @Override
    public int priceBike() {
        return 5000;
    }
}

class RaceBike implements BaseBike {
    @Override
    public int priceBike() {
        return 4000;
    }
}

class FarmBike implements BaseBike {
    @Override
    public int priceBike() {
        return 3000;
    }
}

class BikeStands implements BaseBike {
    BaseBike baseBike;
    public BikeStands(BaseBike baseBike) {
        this.baseBike = baseBike;
    }

    @Override
    public int priceBike() {
        return this.baseBike.priceBike() + 300;
    }
}

interface PeripheralDecorator extends BaseBike {
}

class BikeLight implements PeripheralDecorator {
    BaseBike baseBike;
    public BikeLight(BaseBike baseBike) {
        this.baseBike = baseBike;
    }

    @Override
    public int priceBike() {
        return this.baseBike.priceBike() + 500;
    }
}

class BikeDiskBreak implements PeripheralDecorator {
    BaseBike baseBike;
    public BikeDiskBreak(BaseBike baseBike) {
        this.baseBike = baseBike;
    }

    @Override
    public int priceBike() {
        return this.baseBike.priceBike() + 1500;
    }
}

class BikeHelmet implements PeripheralDecorator {
    BaseBike baseBike;
    BikeHelmet(BaseBike baseBike) {
        this.baseBike = baseBike;
    }

    @Override
    public int priceBike() {
        return this.baseBike.priceBike() + 600;
    }
}
public class DecoratorBikeMain {
    public static void main(String[] args) {
        //CountryDelight + ExtraCheese
        BaseBike baseBike = new MountainBike();
        System.out.println(baseBike.priceBike());
        baseBike = new BikeLight(baseBike);
        System.out.println(baseBike.priceBike());
        baseBike = new BikeDiskBreak(baseBike);
        System.out.println(baseBike.priceBike());

        baseBike = new BikeStands(baseBike);
        System.out.println(baseBike.priceBike());
    }
}

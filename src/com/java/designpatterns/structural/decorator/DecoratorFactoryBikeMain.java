package com.java.designpatterns.structural.decorator;
 
abstract class BaseBikeClass {
    protected int bikeRate = 0;
    public abstract int priceBike();
}

class MountainBikeClass extends BaseBikeClass {
    @Override
    public int priceBike() {
        bikeRate = 5000;
        return bikeRate;
    }
}

class RaceBikeClass extends BaseBikeClass {
    @Override
    public int priceBike() {
        bikeRate = 4000;
        return bikeRate;
    }
}

class FarmBikeClass extends BaseBikeClass {
    @Override
    public int priceBike() {
        bikeRate = 3000;
        return bikeRate;
    }
}

class BikeStandsClass extends BaseBikeClass {
    BaseBikeClass baseBike;
    public BikeStandsClass(BaseBikeClass baseBike) {
        this.baseBike = baseBike;
    }

    @Override
    public int priceBike() {
        return this.baseBike.priceBike() + 300;
    }
}

abstract class PeripheralDecoratorInterface extends BaseBikeClass {
}

class BikeLightClass extends PeripheralDecoratorInterface {
    BaseBikeClass baseBike;
    public BikeLightClass(BaseBikeClass baseBike) {
        this.baseBike = baseBike;
    }

    @Override
    public int priceBike() {
        return this.baseBike.priceBike() + 500;
    }
}

class BikeDiskBreakClass extends PeripheralDecoratorInterface {
    BaseBikeClass baseBike;
    public BikeDiskBreakClass(BaseBikeClass baseBike) {
        this.baseBike = baseBike;
    }

    @Override
    public int priceBike() {
        return this.baseBike.priceBike() + 1500;
    }
}

class BikeHelmetClass extends PeripheralDecoratorInterface {
    BaseBikeClass baseBike;
    BikeHelmetClass(BaseBikeClass baseBike) {
        this.baseBike = baseBike;
    }

    @Override
    public int priceBike() {
        return this.baseBike.priceBike() + 600;
    }
}

class GetBikeFactory{
    public BaseBikeClass getBike(String bikeType) {
        if (bikeType == null) {
            return null;
        }
        if (bikeType.equalsIgnoreCase("Mountain")) {
            return new MountainBikeClass();
        } else if (bikeType.equalsIgnoreCase("Race")) {
            return new RaceBikeClass();
        } else if (bikeType.equalsIgnoreCase("Farm")) {
            return new FarmBikeClass();
        }
        return null;
    }
}

public class DecoratorFactoryBikeMain {
    public static void main(String[] args) {

        GetBikeFactory getBikeFactory = new GetBikeFactory();

        BaseBikeClass baseBike = getBikeFactory.getBike("Mountain");
        System.out.println(baseBike.priceBike());
        baseBike = new BikeLightClass(baseBike);
        System.out.println(baseBike.priceBike());
        baseBike = new BikeDiskBreakClass(baseBike);
        System.out.println(baseBike.priceBike());

        baseBike = new BikeStandsClass(baseBike);
        System.out.println(baseBike.priceBike());
    }
}

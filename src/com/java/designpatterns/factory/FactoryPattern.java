package com.java.designpatterns.factory;

import java.util.Scanner;

abstract class RechargePlan {
    protected Integer amountRate;
    abstract void getRechargePlan();

    public int getRechargeAmount(int quantity) {
        System.out.println("Recharge Amount: " + this.amountRate*quantity);
        return this.amountRate*quantity;
    }
}

class PersonalPlan extends RechargePlan {
    @Override
    public void getRechargePlan() {
        amountRate = 100;
    }
}

class CorporatePlan extends RechargePlan {
    @Override
    public void getRechargePlan() {
        amountRate = 150;
    }
}

class ComboPlan extends RechargePlan {
    @Override
    public void getRechargePlan() {
        amountRate = 200;
    }
}

class GetRechargePlanFactory {

    public RechargePlan getRechargePlan(String planType) {
        if(planType == null) {
            return null;
        }

        if(planType.equalsIgnoreCase("PersonalPlan")) {
            return new PersonalPlan();
        } else if(planType.equalsIgnoreCase("CorporatePlan")) {
            return new CorporatePlan();
        } else if(planType.equalsIgnoreCase("ComboPlan")) {
            return new ComboPlan();
        }
        return null;
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GetRechargePlanFactory rechargePlanFactory = new GetRechargePlanFactory();
        System.out.println("Enter the Recharge Plan Type: ");

        String planType = sc.nextLine();
        System.out.println("Enter the Recharge Amount: ");
        int amount = sc.nextByte();

        RechargePlan rechargePlan = rechargePlanFactory.getRechargePlan(planType);

        System.out.print("Bill amount for "+planType+" of  "+amount+" units is: ");
        rechargePlan.getRechargePlan();
        rechargePlan.getRechargeAmount(amount);
        System.out.println("Recharge Amount: "+rechargePlan.getRechargeAmount(amount));


    }
}

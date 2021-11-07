package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Double[] Prices = new Double[3];
        Prices[0] = 7.99;
        Prices[1] = 10.99;
        Prices[2] = 13.99;
        double priceTot = 0;
        boolean valid = false;
        String size = "";
        while (!valid) {
            System.out.println("what size pizza do you want? : small, medium, large");
            try {
                size = input.next();
                String lowerSize = size.toLowerCase();
                if (lowerSize.equals("small")){
                    priceTot = Prices[0];
                    break;
                }else if (lowerSize.equals("medium")){
                    priceTot = Prices[1];
                    break;
                }else if (lowerSize.equals("large")){
                    priceTot = Prices[2];
                    break;
                } else {
                    System.out.println("this is not an option");
                }
            } catch (InputMismatchException e) {
                System.out.println("this is a number not an option "+ e );
                input.next();
            }
        }
        System.out.println(priceTot);
        int noToppings = 0;
        ArrayList<String> toppings = new ArrayList<>();
        System.out.println("How many toppings do you want?");
        valid = false;
        while (!valid) {
            noToppings = input.nextInt();
            try{
                for (int i = 0; i < noToppings; i++) {
                    System.out.println("enter your topping:");
                    String toppingChoice = input.next();
                    String lowerToppingC = toppingChoice.toLowerCase();
                    if (lowerToppingC.equals("end")){
                        noToppings = i;
                        break;
                    }else {
                        toppings.add(toppingChoice);
                    }
                }
            }catch (InputMismatchException e){
                System.out.println("this is not a number "+ e );
                input.next();
            }
            int extraToppings = noToppings - 2;
            if (extraToppings > 0) {
                priceTot = (double)Math.round((priceTot + (extraToppings * 1.25))*100)/100;
            }
            System.out.println("you wanted a "+size+" pizza with these toppings:");
            System.out.println(Arrays.toString(toppings.toArray()));
            System.out.println("the price of that will be "+priceTot);
            break;
        }
    }
}

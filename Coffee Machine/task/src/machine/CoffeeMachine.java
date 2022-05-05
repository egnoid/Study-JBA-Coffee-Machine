package machine;
import java.util.Scanner;

public class CoffeeMachine {
    //private static String money;
    //initialize resources
    private static final int initMoney = 550;
    private static final int initWater = 400;
    private static final int initMilk = 540;
    private static final int initCoffeeBeans = 120;
    private static final int initDisposableCups = 9;

    private static int money = initMoney;
    private static int water = initWater;
    private static int milk = initMilk;
    private static int coffeeBeans = initCoffeeBeans;
    private static int disposableCups = initDisposableCups;

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        //Coffee machine ver.3

        final String commandBuy = "buy";
        final String commandFill = "fill";
        final String commandTake = "take";
        final String commandRemaining = "remaining";
        final String commandExit = "exit";


        //Welcome text & read command

        String inputCommand = "";

        while (!inputCommand.equals(commandExit)) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            inputCommand = scanner.nextLine();
            switch (inputCommand) {
                case commandBuy:
                    makeCoffee();
                    break;
                case commandFill:
                    refilment();
                    break;
                case commandTake:
                    cashOut();
                    break;
                case commandRemaining:
                    statusDisplay(water, milk, coffeeBeans, disposableCups, money);
                    break;
                case commandExit:
                    break;
                default:
                    System.out.println("Unknown command");
                    break;

            }
        }

    }

    public static void makeCoffee () {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        Scanner scanType = new Scanner(System.in);
        String requestedCoffee = scanType.nextLine();
        switch (requestedCoffee) {
            case "1":
                if (water < 250) {
                    System.out.println("Sorry, not enough water!");
                    break;
                }
                else if (coffeeBeans < 16) {
                    System.out.println("Sorry, not enough coffee beans!");
                    break;
                }
                else if (disposableCups < 1) {
                    System.out.println("Sorry, not enough water!");
                    break;
                }
                else {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 250;
                    coffeeBeans -= 16;
                    disposableCups -= 1;
                    money += 4;
                    break;
                }
            case "2":
                if (water < 350) {
                    System.out.println("Sorry, not enough water!");
                    break;
                }
                else if (coffeeBeans < 20) {
                    System.out.println("Sorry, not enough coffee beans!");
                    break;
                }
                else if (milk < 75) {
                    System.out.println("Sorry, not enough milk!");
                    break;
                }
                else if (disposableCups < 1) {
                    System.out.println("Sorry, not enough water!");
                    break;
                }

                else {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 350;
                    milk -= 75;
                    coffeeBeans -= 20;
                    disposableCups -= 1;
                    money += 7;
                    break;
                }
            case "3":
                if (water < 200) {
                    System.out.println("Sorry, not enough water!");
                    break;
                }
                else if (coffeeBeans < 12) {
                    System.out.println("Sorry, not enough coffee beans!");
                    break;
                }
                else if (milk < 100) {
                    System.out.println("Sorry, not enough milk!");
                    break;
                }
                else if (disposableCups < 1) {
                    System.out.println("Sorry, not enough water!");
                    break;
                }
                else {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 200;
                    milk -= 100;
                    coffeeBeans -= 12;
                    disposableCups -= 1;
                    money += 6;
                    break;
                }
            case "back":
                break;
            default:
                System.out.println("Wrong input");
                break;
        }
    }

    public static void refilment() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        water += scan.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += scan.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeans += scan.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        disposableCups += scan.nextInt();

    }

    public static void cashOut () {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    public static void statusDisplay (int wat, int mil, int bea, int cup, int mon) {
        System.out.println("The coffee machine has:");
        System.out.println(wat + " ml of water");
        System.out.println(mil + " ml of milk");
        System.out.println(bea + " g of coffee beans");
        System.out.println(cup + " disposable cups");
        System.out.println("$" + mon + " of money");

    }
}

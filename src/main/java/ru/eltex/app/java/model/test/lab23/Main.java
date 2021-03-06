package ru.eltex.app.java.model.test.lab23;


import ru.eltex.app.java.model.products.Devices;
import ru.eltex.app.java.model.products.Phones;
import ru.eltex.app.java.model.products.Smartphones;
import ru.eltex.app.java.model.products.Tablets;
import ru.eltex.app.java.model.shop.Credentials;
import ru.eltex.app.java.model.shop.Order;
import ru.eltex.app.java.model.shop.Orders;
import ru.eltex.app.java.model.shop.ShoppingCart;

import java.util.LinkedList;
import java.util.Random;

public class Main {

    private static LinkedList<Devices> DevicesArray = null;

    public static void main(String[] args) {

        GenerateInput(args);
        TestShop();
    }

    public static void RunningInput(String[] _args) {
        int countObject = 0;
        int counter = 0;
        String typeObject;
        if (_args.length != 2) {
            System.out.println("-----------------------Ошибка требуется терминальный ввод вида!---------------------------");
            System.out.println("java code.java {количество вводимых объектов} {вид представления}");
            return;
        }
        countObject = Integer.parseInt(_args[0]);
        typeObject = _args[1];
        DevicesArray = new LinkedList<Devices>();

        switch (typeObject) {
            case "Phones": {

                for (int i = 0; i < countObject; i++) {
                    DevicesArray.add(new Phones());
                    System.out.println("Ввод объекта: " + ++counter);
                    ((Phones) DevicesArray.get(i)).update();
                }
                break;
            }
            case "Smartphones": {
                for (int i = 0; i < countObject; i++) {
                    DevicesArray.add(new Smartphones());
                    System.out.println("Ввод объекта: " + ++counter);
                    ((Smartphones) DevicesArray.get(i)).update();
                }
                break;
            }
            case "Tablets": {
                for (int i = 0; i < countObject; i++) {
                    DevicesArray.add(new Tablets());
                    System.out.println("Ввод объекта: " + ++counter);
                    ((Tablets) DevicesArray.get(i)).update();
                }
                break;
            }
            default: {
                System.out.println("-----------------------Ошибка требуется терминальный ввод вида!---------------------------");
                System.out.println("java code.java {количество вводимых объектов} {phones/smartphones/tablets}");
            }

        }
    }


    private static void TestShop() {
        ShoppingCart<Smartphones> shoppingCart;
        Credentials credentials = new Credentials();
        Orders<Order> orders;
        credentials.Input();
        if (DevicesArray != null) {
            shoppingCart = new ShoppingCart(credentials, DevicesArray);

            orders = new Orders();
            orders.Checkout(shoppingCart, 1000 + (long) (new Random().nextDouble() * (100000 - 1000)));
            orders.OrdersCheck();
            orders.showAllOrders();
        }

    }

    public static void GenerateInput(String[] _args) {
        int countObject = 0;
        int counter = 0;
        String typeObject;
        if (_args.length != 2) {
            System.out.println("-----------------------Ошибка требуется терминальный ввод вида!---------------------------");
            System.out.println("java code.java {количество вводимых объектов} {вид представления}");
            return;
        }
        countObject = Integer.parseInt(_args[0]);
        typeObject = _args[1];
        DevicesArray = new LinkedList<Devices>();

        switch (typeObject) {
            case "Phones": {

                for (int i = 0; i < countObject; i++) {
                    DevicesArray.add(new Phones());
                    ((Phones) DevicesArray.get(i)).create();
                }
                break;
            }
            case "Smartphones": {
                for (int i = 0; i < countObject; i++) {
                    DevicesArray.add(new Smartphones());
                    ((Smartphones) DevicesArray.get(i)).create();
                }
                break;
            }
            case "Tablets": {
                for (int i = 0; i < countObject; i++) {
                    DevicesArray.add(new Tablets());
                    ((Tablets) DevicesArray.get(i)).create();
                }
                break;
            }
            default: {
                System.out.println("-----------------------Ошибка требуется терминальный ввод вида!---------------------------");
                System.out.println("java code.java {количество вводимых объектов} {phones/smartphones/tablets}");
            }

        }
        //  printDevicesArray();
    }

}

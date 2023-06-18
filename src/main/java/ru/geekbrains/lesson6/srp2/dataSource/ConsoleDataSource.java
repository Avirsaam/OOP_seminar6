package ru.geekbrains.lesson6.srp2.dataSource;

import ru.geekbrains.lesson6.srp2.Order;

import java.util.Scanner;

public class ConsoleDataSource extends OrderDataSource{
    private Scanner scanner;
    Order order;

    public ConsoleDataSource(){
        scanner = new Scanner(System.in);
        order = new Order();
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Order getNextOrder() {
        order.setClientName(prompt("Имя клиента: "));
        order.setProduct(prompt("Продукт: "));
        order.setQnt(Integer.parseInt(prompt("Кол-во: ")));
        order.setPrice(Integer.parseInt(prompt("Цена: ")));
        return order;
    }

    private String prompt(String message){
        System.out.println(message);
        return scanner.nextLine();
    }
}

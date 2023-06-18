package ru.geekbrains.lesson6.srp2;

import ru.geekbrains.lesson6.srp2.FileFormats.JsonFormat;
import ru.geekbrains.lesson6.srp2.FileFormats.TextFormat;
import ru.geekbrains.lesson6.srp2.dataSource.ConsoleDataSource;
import ru.geekbrains.lesson6.srp2.dataSource.JsonDataSource;
import ru.geekbrains.lesson6.srp2.dataSource.OrderDataSource;

import java.util.ArrayList;
import java.util.List;

public class Program {


    /**
     * Переработать структуру приложения Order, приложение должно соответствовать
     *  принципу SRP.
     * @param args
     */
    public static void main(String[] args) {

        String fileName = "order.json";

        List<Order> orders = new ArrayList<Order>();

        OrderDataSource consoleInput = new ConsoleDataSource();
        OrderDataSource jsonData = new JsonDataSource(fileName);
        TextFormat orderFileSaver = new JsonFormat();

        orders.add(consoleInput.getNextOrder());
        while (jsonData.hasNext()) {
            orders.add(jsonData.getNextOrder());
        }

        for (Order order: orders) {
            System.out.println(order);
        }

        orderFileSaver.save(orders, fileName);


    }
}

package ru.geekbrains.lesson6.srp2.FileFormats;

import ru.geekbrains.lesson6.srp2.Interface.Savable;
import ru.geekbrains.lesson6.srp2.Order;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class JsonFormat extends TextFormat {
    @Override
    public void save(Collection<Order> listOfOrders, String filename) {

        try (FileWriter writer = new FileWriter(filename, false)) {
            for (Order order: listOfOrders) {
                writer.write("{\n");
                writer.write("\"clientName\":\"" + order.getClientName() + "\",\n");
                writer.write("\"product\":\"" + order.getProduct() + "\",\n");
                writer.write("\"qnt\":" + order.getQnt() + ",\n");
                writer.write("\"price\":" + order.getPrice() + "\n");
                writer.write("}\n");
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

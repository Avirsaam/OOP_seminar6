package ru.geekbrains.lesson6.srp2.dataSource;

import ru.geekbrains.lesson6.srp2.Order;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JsonDataSource  extends OrderDataSource {

    List<Order> orders;
    int currentOrder;

    public JsonDataSource(String fileName){
        try{
            Scanner scanner = new Scanner(new File(fileName));
            orders = new ArrayList<>();
            //TODO: reading file, de-serializing orders, adding orders to list
            String jsonLine = "";

            while (scanner.hasNextLine()){
                String thisLine = scanner.nextLine();
                jsonLine += thisLine;
                if (thisLine.equals("}")){
                    orders.add(parseOrderFromJson(jsonLine));
                    jsonLine = "";
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            //throw new RuntimeException(e);
        }
        currentOrder = 0;
    }
    
    private Order parseOrderFromJson(String json){
        Order result = new Order();
        json = json.substring(1, json.length() - 1);
        json = json.replace("\n", "");
        json = json.replace("\"", "");
        json = json.replace(" ", "");
        String [] kvPairs = json.split(",");
        for (String kvPair: kvPairs) {
            String key = kvPair.split(":")[0];
            String value = kvPair.split(":")[1];
            switch (key){
                case "clientName":
                    result.setClientName(value);
                    break;
                case "product":
                    result.setProduct(value);
                    break;
                case "qnt":
                    result.setQnt(Integer.parseInt(value));
                    break;
                case "price":
                    result.setPrice(Integer.parseInt(value));
                    break;
            }
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        return currentOrder < orders.size();
    }

    @Override
    public Order getNextOrder() {
        if (hasNext()) return orders.get(currentOrder++);
        else return null;
    }
}

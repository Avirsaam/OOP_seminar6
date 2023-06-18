package ru.geekbrains.lesson6.srp2.Interface;

import ru.geekbrains.lesson6.srp2.Order;

import java.io.File;
import java.util.Collection;

public interface Savable {
    void save(Collection<Order> listOfOrders, String filename);
}

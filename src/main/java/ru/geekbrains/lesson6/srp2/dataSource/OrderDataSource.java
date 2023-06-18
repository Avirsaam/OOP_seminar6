package ru.geekbrains.lesson6.srp2.dataSource;
import ru.geekbrains.lesson6.srp2.Order;

abstract public class OrderDataSource {

    abstract public boolean hasNext();
    public abstract Order getNextOrder();
}

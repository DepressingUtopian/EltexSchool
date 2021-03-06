package ru.eltex.app.java.model.shop;

import java.util.ArrayList;
import java.util.List;

public abstract class ACheck extends Thread {

    protected Orders orders;
    protected long IntervalTime = 0;

    public ACheck(Orders _orders, long _IntervalTime) {
        this.orders = _orders;
        this.IntervalTime = _IntervalTime;
    }

    public ACheck(String nameThread, Orders _orders, long _IntervalTime) {
        super(nameThread);
        this.orders = _orders;
        this.IntervalTime = _IntervalTime;
    }

    public ACheck() {

    }

    public void setArrayListToOrders(ArrayList list) {
        orders.setOrdersArrayList(list);
    }
    public Orders getOrders() {
        return orders;
    }

    public long getIntervalTime() {
        return IntervalTime;
    }

    public void setOrders(Orders _orders) {
        this.orders = _orders;
    }

    public void setIntervalTime(long _intervalTime) {
        IntervalTime = _intervalTime;
    }

    public void OrdersCheck() {
        orders.OrdersCheck();
    }

    ACheck(String name) {
        super(name);
    }

    public void run() {

    }

    public boolean checkState(Order.stateWork _state, Order _order) {
        return _order.getState().equals(_state);
    }

    public Orders get_orders() {
        return orders;
    }
}

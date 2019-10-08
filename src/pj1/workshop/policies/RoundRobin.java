package pj1.workshop.policies;

import pj1.workshop.orders.PaintOrder;

import java.util.LinkedList;

public class RoundRobin extends Policy implements OrderManager{
    private LinkedList<PaintOrder> list;


    @Override
    public void add(PaintOrder order) {

    }

    @Override
    public PaintOrder remove() {
        return null;
    }

    @Override
    public PaintOrder next() {
        return null;
    }
}

package pj1.workshop.policies;

import pj1.workshop.orders.PaintOrder;

import java.util.Stack;

public class LastComeFirstServed extends Policy implements OrderManager {
    private Stack<PaintOrder> stack;



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

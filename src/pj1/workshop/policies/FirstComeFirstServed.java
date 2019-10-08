package pj1.workshop.policies;

import pj1.workshop.orders.PaintOrder;

import java.util.concurrent.ConcurrentLinkedQueue;

public class FirstComeFirstServed extends Policy implements OrderManager{
    private ConcurrentLinkedQueue<PaintOrder> queue;
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

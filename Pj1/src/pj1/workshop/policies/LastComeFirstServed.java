/*LastComeFirstServed.java*/
/**
 ** Hecho por: Jose Del Vecchio
 ** Carnet: 15000451
 ** Sección: BN
 **/

package pj1.workshop.policies;

import pj1.workshop.orders.PaintOrder;

import java.util.LinkedList;
import java.util.Stack;

public class LastComeFirstServed extends Policy implements OrderManager {
    private Stack<PaintOrder> stack;


    public LastComeFirstServed() { this.stack = new Stack<PaintOrder>();}

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

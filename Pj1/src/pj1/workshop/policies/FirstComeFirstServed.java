/*FirstComeFirstServed.java*/
/**
 ** Hecho por: Jose Del Vecchio
 ** Carnet: 15000451
 ** Sección: BN
 **/

/**
 ** Hecho por: Jose Del Vecchio
 ** Carnet: 15000451
 ** Sección: BN
 **/
/**
 ** FirstComeFirstServed es la tipica cola que se genera conforma las ordenes se van creando
 * en esta clase se utilizo queue por lo que realiza y lo que el proyecto requiere.
 *
 * En esta clase, las ordenes se generan y entran a esta clase para formar la cola de ordenes que estan en espera.
 **/

package pj1.workshop.policies;
/**Se importa desde Paint Orders*/
import pj1.workshop.orders.PaintOrder;

import java.util.concurrent.ConcurrentLinkedQueue;

/**Se declara la clase. Esta hereda de Policy e implementa los metodos de OrderManager*/
public class FirstComeFirstServed extends Policy implements OrderManager{
    private ConcurrentLinkedQueue<PaintOrder> queue;
    /**Se declara la Lista encadenada**/
    public FirstComeFirstServed() {
        this.queue = new ConcurrentLinkedQueue<PaintOrder>();
    }


    @Override
    public void add(PaintOrder order) {
        queue.add(order);
    }

    @Override
    public PaintOrder remove() {
        return null;
    }

    @Override
    public PaintOrder next() {
        PaintOrder order =  queue.poll();
        if (order == null){
            return null;
        }



        System.out.println("Actualmente se atiende a: " + order.getVehiculo() + ", " + order.getPiezasTotal() + " pieza"
        +"Correlativo (#" + order.getOrder() + ").\n" +
              "Ordenes Pendientes: " + getOrdenesPendites()
        );

        try {
            int sleepingTime = (int)order.getTime() * order.getPiezasTotal();
            System.out.println("Sleeping thread: " + sleepingTime + " seconds.");
            Thread.sleep(sleepingTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Orden completa! Se completo " + order.getType() + " que neceistaba " + order.getPiezasTotal() + " pieza ( correlativo # "
            + order.getOrder() + ")\n" + "Precio: " + order.getPrice()  + "."
        );
        return order;
    }

    private String getOrdenesPendites(){
        String resultado = "";

        for(PaintOrder order:  queue){
            resultado = resultado + order.getVehiculo() + " " +order.getPiezasTotal() + " piezas (Q" + order.getOrder() + ") |";
        }
        return resultado;

    }
}

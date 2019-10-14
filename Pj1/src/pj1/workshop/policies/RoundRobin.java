/*RoundRobin.java*/
/**
 ** Hecho por: Jose Del Vecchio
 ** Carnet: 15000451
 ** Sección: BN
 **/

/**RoundRobin Class
 * Debido a la funcionalidad de Round Robin, esta es la que controla la entrada y la salida de cada pieza
 * en el tiempo que se le impuso.
 * Esta clase se trabajo con Linked List, debido a que es necesario poseer ambos nodos disponibles de la cadena para
 * poder accesar a ella y trabajar las piezas en base a lo requerido.
 *
 */


package pj1.workshop.policies;

import pj1.workshop.orders.PaintOrder;

import java.util.LinkedList;


public class RoundRobin extends Policy implements OrderManager{
    private LinkedList<PaintOrder> list;


    public RoundRobin() {
        this.list = new LinkedList<PaintOrder>();
    }

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

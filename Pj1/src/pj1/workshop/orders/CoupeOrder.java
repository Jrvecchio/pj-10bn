/*CoupeOrder.java*/
/**
 ** Hecho por: Jose Del Vecchio
 ** Carnet: 15000451
 ** Sección: BN
 **/

package pj1.workshop.orders;

public class CoupeOrder extends PaintOrder {

    /**
     * Falta ver que poner aqui.
     *
     * @param number número de orden
     * @param plate  número de placa
     * @param total  número total de piezas a pintar
     * @param time   cantidad de tiempo por pieza
     */
    public CoupeOrder(int number, String plate, int total, double time,  int piezasTotal) {
        super(number, plate, total, time, piezasTotal, "Coupe");
        System.out.println("Nuevo Ingreso! Se ingreso un " +vehiculo + ", que necesita " + piezasTotal + " piezas. Correlativo (# " + number);
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public String getPrice() {
        return (total * piezasTotal) + "";
    }

    @Override
    public void end() {

    }
}

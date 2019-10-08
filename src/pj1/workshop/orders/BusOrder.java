package pj1.workshop.orders;

public class BusOrder extends PaintOrder {


    /**
     * Falta ver que poner aqui.
     *
     * @param number número de orden
     * @param plate  número de placa
     * @param total  número total de piezas a pintar
     * @param time   cantidad de tiempo por pieza
     */

    protected BusOrder(int number, String plate, int total, double time) {
        super(number, plate, total, time);
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public String getPrice() {
        return null;
    }

    @Override
    public void end() {

    }
}

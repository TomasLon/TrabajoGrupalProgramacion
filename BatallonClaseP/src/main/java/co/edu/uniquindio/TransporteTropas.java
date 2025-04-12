package co.edu.uniquindio;

public class TransporteTropas extends Vehiculo {
private int capacidadSoldados;
    public TransporteTropas(String id, String modelo, int fechaFabricacion, double kilometraje, int misionesCompletadas, EstadoOperativo estado, int capacidadSoldados) {
        super(id, modelo, fechaFabricacion, kilometraje, misionesCompletadas, estado);
        this.capacidadSoldados = 0;
    }

    public int getCapacidadSoldados() {
        return capacidadSoldados;
    }

    public void setCapacidadSoldados(int capacidadSoldados) {
        this.capacidadSoldados = capacidadSoldados;
    }

    @Override
    public void desplazamiento() {
        System.out.println("El vehiculo de tropas se esta moviendo");
    }

}

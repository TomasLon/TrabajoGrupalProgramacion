package co.edu.uniquindio;

public class VehiculoBlindado extends Vehiculo {
private int nivelBlindaje;
    public VehiculoBlindado(String id, String modelo, int fechaFabricacion, double kilometraje, int misionesCompletadas, EstadoOperativo estado, int nivelBlindaje) {
        super(id, modelo, fechaFabricacion, kilometraje, misionesCompletadas, estado);
    this.nivelBlindaje = nivelBlindaje;
    }

    public int getNivelBlindaje() {
        return nivelBlindaje;
    }

    public void setNivelBlindaje(int nivelBlindaje) {
        this.nivelBlindaje = nivelBlindaje;
    }

    @Override
    public void desplazamiento() {
        System.out.println("El vehiculo de tropas se esta moviendo");
    }
}

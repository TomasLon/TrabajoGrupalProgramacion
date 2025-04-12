package co.edu.uniquindio;

public class VehiculoApoyo extends Vehiculo {
public TipoFuncion tipoFuncion;
    public VehiculoApoyo(String id, String modelo, int fechaFabricacion, double kilometraje, int misionesCompletadas, EstadoOperativo estado, TipoFuncion tipoFuncion) {
        super(id, modelo, fechaFabricacion, kilometraje, misionesCompletadas, estado);
        this.tipoFuncion = tipoFuncion;
    }

    public TipoFuncion getTipoFuncion() {
        return tipoFuncion;
    }

    public void setTipoFuncion(TipoFuncion tipoFuncion) {
        this.tipoFuncion = tipoFuncion;
    }

    @Override
    public void desplazamiento() {

    }
}

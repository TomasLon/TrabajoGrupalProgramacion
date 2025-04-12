package co.edu.uniquindio;

import java.util.LinkedList;

public abstract class Vehiculo {

    protected String id;
    protected String modelo;
    protected int fechaFabricacion;
    protected double kilometraje;
    protected static int misionesCompletadas;
    protected EstadoOperativo estadoOperativo;
    protected LinkedList<Mision> listMisiones;

    public Vehiculo(String id, String modelo, int fechaFabricacion, double kilometraje, int misionesCompletadas, EstadoOperativo estadoOperativo) {
        this.id = id;
        this.modelo = modelo;
        this.fechaFabricacion = fechaFabricacion;
        this.kilometraje = kilometraje;
        this.misionesCompletadas = misionesCompletadas;
        this.estadoOperativo = estadoOperativo;
        this.listMisiones = new LinkedList<>();
    }

    public abstract void desplazamiento();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(int fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }

    public static int getMisionesCompletadas() {
        return misionesCompletadas;
    }

    public void setMisionesCompletadas(int misionesCompletadas) {
        this.misionesCompletadas = misionesCompletadas;
    }

    public EstadoOperativo getEstadoOperativo() {
        return estadoOperativo;
    }
    public void setEstadoOperativo(EstadoOperativo estadoOperativo) {
        this.estadoOperativo = estadoOperativo;
    }


}

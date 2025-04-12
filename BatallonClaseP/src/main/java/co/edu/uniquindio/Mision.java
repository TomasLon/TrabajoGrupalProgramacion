package co.edu.uniquindio;

import java.time.LocalDate;
import java.util.LinkedList;

public class Mision {

    private String id;
    private LocalDate fecha;
    private LinkedList<Soldado> personal;
    private String ubicacion;
    private Vehiculo vehiculo;

    // Constructor principal (sin personal)
    public Mision(String id, LocalDate fecha, String ubicacion) {
        this.id = id;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.personal = new LinkedList<>();
    }

    // Constructor alternativo (con personal)
    public Mision(String id, LocalDate fecha, String ubicacion, LinkedList<Soldado> personal) {
        this(id, fecha, ubicacion);
        this.personal = personal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LinkedList<Soldado> getPersonal() {
        if (personal == null) {
            personal = new LinkedList<>();
        }
        return personal;
    }

    public void setPersonal(LinkedList<Soldado> personal) {
        this.personal = personal;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}

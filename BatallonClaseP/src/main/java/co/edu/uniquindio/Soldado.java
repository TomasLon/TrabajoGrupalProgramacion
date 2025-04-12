package co.edu.uniquindio;

public class Soldado {
    private String id;
    private String nombreCompleto;
    private RangoMilitar rangoMilitar;
    private AreaEspecializacion areaEspecializacion;
    private int edad;
    private boolean estaEnMision;

    //Constructor Soldado
    public Soldado(String id, String nombreCompleto, RangoMilitar rangoMilitar, AreaEspecializacion areaEspecializacion, int edad, boolean estaEnMision) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.rangoMilitar = rangoMilitar;
        this.areaEspecializacion = areaEspecializacion;
        this.edad = edad;
        this.estaEnMision = estaEnMision;
    }

    //Getter's and setter's

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public RangoMilitar getRangoMilitar() {
        return rangoMilitar;
    }

    public void setRangoMilitar(RangoMilitar rangoMilitar) {
        this.rangoMilitar = rangoMilitar;
    }

    public AreaEspecializacion getAreaEspecializacion() {
        return areaEspecializacion;
    }

    public void setAreaEspecializacion(AreaEspecializacion areaEspecializacion) {
        this.areaEspecializacion = areaEspecializacion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isEstaEnMision() {
        return estaEnMision;
    }

    public void setEstaEnMision(boolean estaEnMision) {
        this.estaEnMision = estaEnMision;
    }
}

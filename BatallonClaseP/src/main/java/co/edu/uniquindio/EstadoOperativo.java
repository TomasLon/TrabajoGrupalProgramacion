package co.edu.uniquindio;

public enum EstadoOperativo {
    DISPONIBLE("Disponible"),
    MISION("En una misión"),
    MANTENIMIENTO("En mantenimiento");

    public final String estado;

    EstadoOperativo(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return estado;
    }
}

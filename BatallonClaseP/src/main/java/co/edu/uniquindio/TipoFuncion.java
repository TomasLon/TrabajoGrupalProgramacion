package co.edu.uniquindio;

public enum TipoFuncion {
    LOGISTICA ("Logística"),
    COMUNICACIONES ("Comunicativa"),
    MEDICO("Primeros Auxilios");

    public final String funcion;

    TipoFuncion(String funcion) {
        this.funcion = funcion;
    }

    @Override
    public String toString() {
        return funcion;
    }
}

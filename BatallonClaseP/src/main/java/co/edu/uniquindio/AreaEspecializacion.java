package co.edu.uniquindio;

public enum AreaEspecializacion {
    MEDICO("Médico"),
    COMUNICACIONES("Comunicaciones"),
    LOGISTICA("Logística");

    public final String especializacion;

    AreaEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }

    @Override
    public String toString() {
        return especializacion;
    }
}

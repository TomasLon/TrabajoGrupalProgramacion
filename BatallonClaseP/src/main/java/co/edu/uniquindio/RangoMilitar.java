package co.edu.uniquindio;

public enum RangoMilitar {
    SOLDADO("Soldado"),
    CABO("Cabo"),
    SARGENTO("Sargento");

    public final String rango;

    RangoMilitar(String rango) {
        this.rango = rango;
    }

    @Override
    public String toString() {
        return rango;
    }
}

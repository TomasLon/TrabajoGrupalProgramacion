import co.edu.uniquindio.AreaEspecializacion;
import co.edu.uniquindio.Batallon;
import co.edu.uniquindio.RangoMilitar;
import co.edu.uniquindio.Soldado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class testbatallon {

    private static final Logger LOG = Logger.getLogger(testbatallon.class.getName());

    private Batallon batallon;

    @BeforeEach
    void setUp() {
        LOG.info("Configurando batallón con soldados de prueba");
        batallon = new Batallon("AltaMontaña", "10099");
        batallon.getSoldados().add(new Soldado("001", "Carlos", RangoMilitar.CABO, AreaEspecializacion.MEDICO, 25, false));
        batallon.getSoldados().add(new Soldado("002", "Luis", RangoMilitar.CABO, AreaEspecializacion.MEDICO, 30, false));
        batallon.getSoldados().add(new Soldado("003", "Pedro", RangoMilitar.CABO, AreaEspecializacion.LOGISITCA, 28, false));
        batallon.getSoldados().add(new Soldado("004", "Juan", RangoMilitar.CABO, AreaEspecializacion.LOGISITCA, 28, true)); // En misión
    }

    @Test
    void testCantidadSoldadosPorEspecialidad() {
        LOG.info("Inicio test: cantidad de soldados por especialidad");
        LinkedList<Soldado> medicos = batallon.buscarSoldadosEspecializados(AreaEspecializacion.MEDICO);
        assertEquals(2, medicos.size());
    }

    @Test
    void testCantidadSoldadosPorRangoMilitar() {
        LOG.info("Inicio test: cantidad de soldados por rango militar");
        LinkedList<Soldado> soldadosCabo = batallon.buscarSoldadosDisponibles(RangoMilitar.CABO);
        assertEquals(3, soldadosCabo.size());
    }
}

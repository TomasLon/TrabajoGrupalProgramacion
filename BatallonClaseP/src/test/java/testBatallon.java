import co.edu.uniquindio.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.logging.Logger;


public class testbatallon {

    private static final Logger LOG = Logger.getLogger(testbatallon.class.getName());

    private Batallon batallon;

    @BeforeEach
    void setUp() {
        LOG.info("Configurando batallón con soldados de prueba");

        // Crear el batallón y los soldados
        batallon = new Batallon("AltaMontaña", "10099");

        // Agregar soldados al batallón
        batallon.getSoldados().add(new Soldado("001", "Carlos", RangoMilitar.CABO, AreaEspecializacion.MEDICO, 25, false));
        batallon.getSoldados().add(new Soldado("002", "Luis", RangoMilitar.CABO, AreaEspecializacion.MEDICO, 30, true)); // En misión
        batallon.getSoldados().add(new Soldado("003", "Pedro", RangoMilitar.CABO, AreaEspecializacion.LOGISTICA, 28, false));
        batallon.getSoldados().add(new Soldado("004", "Juan", RangoMilitar.CABO, AreaEspecializacion.LOGISTICA, 28, true)); // En misión
        batallon.getSoldados().add(new Soldado("005", "Ana", RangoMilitar.SOLDADO, AreaEspecializacion.COMUNICACIONES, 24, false));
        batallon.getSoldados().add(new Soldado("006", "María", RangoMilitar.SOLDADO, AreaEspecializacion.MEDICO, 22, true)); // En misión
        batallon.getSoldados().add(new Soldado("007", "José", RangoMilitar.SARGENTO, AreaEspecializacion.LOGISTICA, 35, false));
        batallon.getSoldados().add(new Soldado("008", "Elena", RangoMilitar.CABO, AreaEspecializacion.COMUNICACIONES, 27, false));

        Mision mision1 = new Mision("Misión de Reconocimiento", LocalDate.now(), "PARAMO SUMAPAZ");
        mision1.getPersonal().add(batallon.getSoldados().get(1));  // Luis
        mision1.getPersonal().add(batallon.getSoldados().get(2));  // Pedro

        Mision mision2 = new Mision("Misión de Rescate", LocalDate.now(), "DESIERTO DEL SHARA");
        mision2.getPersonal().add(batallon.getSoldados().get(0));  // Carlos

        // Agregar misiones al batallón
        batallon.getMisiones().add(mision1);
        batallon.getMisiones().add(mision2);
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

    @Test
    void testAsignarSoldadoMision() {
        LOG.info("Inicio test: asignar soldado a misión");

        Soldado asignado = batallon.asignarSoldadoMision();

        assertNotNull(asignado, "Debe haberse asignado un soldado disponible");
        assertTrue(asignado.isEstaEnMision(), "El soldado asignado debe estar marcado como en misión");

        LOG.info("Soldado asignado a misión: " + asignado.getNombreCompleto() + " (ID: " + asignado.getId() + ")");
    }

    @Test
    void liberarMisionSoldados() {
        LOG.info("Inicio test: liberar soldados de una misión");

        Mision mision1 = batallon.getMisiones().getFirst();  // Misión 1

        batallon.liberarMisionSoldados(mision1);
        for (Soldado soldado : mision1.getPersonal()) {
            assertFalse(soldado.isEstaEnMision(), "El soldado " + soldado.getNombreCompleto() + " debería estar liberado de la misión 1");
        }

    }

}

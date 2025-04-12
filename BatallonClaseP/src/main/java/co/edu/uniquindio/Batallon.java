package co.edu.uniquindio;

import javax.swing.*;
import java.time.LocalDate;
import java.util.LinkedList;

public class Batallon {
    private String nombre;
    private String id;

    private LinkedList<Vehiculo> vehiculos;
    private LinkedList<VehiculoBlindado> listVehiculosBlindados;
    private LinkedList<TransporteTropas> listTransporteTropas;
    private LinkedList<VehiculoApoyo> listVehiculosApoyo;
    private LinkedList<Mision> listMisiones;
    public LinkedList<Soldado> soldados;

    public Batallon(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.soldados = new LinkedList<>();
    }

    //Unifica la lista de todos los vehiculos (esto para verificaciones y demás)
    public LinkedList<Vehiculo> unificarVehiculos() {

        LinkedList<Vehiculo> listVehiculosUnificada = new LinkedList<>();
        listVehiculosUnificada.addAll(listVehiculosBlindados);
        listVehiculosUnificada.addAll(listTransporteTropas);
        listVehiculosUnificada.addAll(listVehiculosApoyo);

        return listVehiculosUnificada;
    }

    //Retorna el tipo de función del vehiculo de apoyo
    public TipoFuncion tipoFuncion() {
        TipoFuncion funcion = null;
        while (funcion == null) {
            int optionTipoFuncion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Ingrese el número del tipo de función del vehiculo de apoyo:\n1.Logística\n2.Comunicaciones\n3.Médico"));
            switch (optionTipoFuncion) {
                case 1 -> funcion = TipoFuncion.LOGISTICA;
                case 2 -> funcion = TipoFuncion.COMUNICACIONES;
                case 3 -> funcion = TipoFuncion.MEDICO;
                default -> JOptionPane.showMessageDialog(null, "Opción no válida, intente nuevamente");
            }
        }
        return funcion;
    }

    //Crea un vehiculo base con las características que todos tienen en común (Esto para que sea más ordenado)
    public Object[] vehiculoBase() {
        String modelo = JOptionPane.showInputDialog(null, "Ingrese el modelo del vehiculo");
        int anioFabricacion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año de fabricación del vehiculo"));
        double kilometraje = Double.parseDouble(JOptionPane.showInputDialog(null, " Ingrese el kilometraje del vehiculo"));

        return new Object[]{modelo, anioFabricacion, kilometraje};
    }

    //Retorna el estado Operativo de un vehiculo desde un enum
    public EstadoOperativo estadoOperativo() {
        EstadoOperativo estado = null;
        while (estado == null) {
            int optionEstadoOperativo = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Ingrese el número del estado operativo del vehiculo:\n\n1.Disponible\n2.Misión\n3.Mantenimiento"));
            switch (optionEstadoOperativo) {
                case 1 -> estado = EstadoOperativo.DISPONIBLE;
                case 2 -> estado = EstadoOperativo.MISION;
                case 3 -> estado = EstadoOperativo.MANTENIMIENTO;
                default -> JOptionPane.showMessageDialog(null, "Opción no válida, intente nuevamente");
            }
        }
        return estado;
    }

    //Verifica el ID de un vehiculo y returna true/false para saber si agregarlo o no
    public boolean verificarIDVehiculo(String id) {
        LinkedList<Vehiculo> listVehiculos = unificarVehiculos();
        for (Vehiculo vehiculo : listVehiculos) {
            if (vehiculo.getId().equals(id)) {
                return false;
            }
        }
        return true;
    }

    //CRUD VEHICULOS(Create, Read, Update, Delete)

    //Agrega un vehiculo a su lista independiente
    public boolean agregarVehiculo(Vehiculo vehiculo) {
        boolean flag = false;
        String idVehiculo = JOptionPane.showInputDialog(null, "Ingrese el id del vehiculo a agregar");
        Object[] datosBase = vehiculoBase();
        while (!flag) {
            boolean vehiculoExiste = verificarIDVehiculo(idVehiculo);
            int options = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de la opción del vehiculo a agregar: \n1.Vehiculo Blindado \n2.Vehiculo Apoyo \n3.Vehiculo Transporte de tropas"));
            if (options == 1) {
                if (vehiculoExiste) {
                    String modelo = (String) datosBase[0];
                    int anioFabricacion = (int) datosBase[1];
                    double kilometraje = (double) datosBase[2];
                    EstadoOperativo estadoOperativo = estadoOperativo();
                    int nivelBlindaje = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nivel de blindaje"));

                    VehiculoBlindado newVehiculoBlindado = new VehiculoBlindado(idVehiculo, modelo, anioFabricacion,
                            kilometraje, 0, estadoOperativo, nivelBlindaje);
                    listVehiculosBlindados.add(newVehiculoBlindado);
                    flag = true;
                    break;
                } else {
                    break;
                }
            } else if (options == 2) {
                if (vehiculoExiste) {
                    String modelo = (String) datosBase[0];
                    int anioFabricacion = (int) datosBase[1];
                    double kilometraje = (double) datosBase[2];
                    EstadoOperativo estadoOperativo = estadoOperativo();
                    TipoFuncion funcionApoyo = tipoFuncion();

                    VehiculoApoyo newVehiculoApoyo = new VehiculoApoyo(idVehiculo, modelo, anioFabricacion, kilometraje, 0, estadoOperativo, funcionApoyo);
                    listVehiculosApoyo.add(newVehiculoApoyo);
                    flag = true;
                    break;
                } else {
                    break;
                }
            } else if (options == 3) {
                if (vehiculoExiste) {
                    String modelo = (String) datosBase[0];
                    int anioFabricacion = (int) datosBase[1];
                    double kilometraje = (double) datosBase[2];
                    EstadoOperativo estadoOperativo = estadoOperativo();
                    int capacidadSoldados = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el capacidad de soldados"));

                    TransporteTropas newVehiculoTransporte = new TransporteTropas(idVehiculo, modelo, anioFabricacion, kilometraje, 0, estadoOperativo, capacidadSoldados);
                    listTransporteTropas.add(newVehiculoTransporte);
                    flag = true;
                    break;
                } else {
                    break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Opción inválida, intente nuevamente");
            }
        }
        return flag;
    }

    //Retorna una lista que permite visualizar su contenido (dependiendo cuál quieran ver)
    public LinkedList<Vehiculo> obtenerVehiculos() {
        boolean flag = false;
        LinkedList<Vehiculo> listaRetornar = new LinkedList<>();
        while (!flag) {
            int option = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese qué lista desea ver:\n1.Vehiculos de apoyo\n2.Vehiculos Blindados\n3.Vehiculos de transporte de tropas"));
            switch (option) {
                case 1:
                    listaRetornar.addAll(listVehiculosApoyo);
                    flag = true;
                    break;
                case 2:
                    listaRetornar.addAll(listVehiculosBlindados);
                    flag = true;
                    break;
                case 3:
                    listaRetornar.addAll(listTransporteTropas);
                    flag = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida, intente nuevamente");
            }
        }
        return listaRetornar;
    }

    //Elimina un vehiculo de la lista
    public boolean eliminarVehiculo() {
        LinkedList<Vehiculo> listVehiculos = unificarVehiculos();
        String idVehiculoEliminar = JOptionPane.showInputDialog(null, "Ingrese el id del vehiculo que desea eliminar");
        boolean vehiculoExiste = verificarIDVehiculo(idVehiculoEliminar);
        if (!vehiculoExiste) {
            for (Vehiculo vehiculoEliminar : listVehiculos) {
                if (vehiculoEliminar.getId().equals(idVehiculoEliminar)) {
                    listVehiculos.remove(vehiculoEliminar);
                    return true;
                }
            }
        }
        return false;
    }

    //Permite editar un vehiculo buscandolo por su ID
    public boolean editarVehiculo() {
        String idVehiculoModificar = JOptionPane.showInputDialog(null, "Ingrese el id del vehiculo que desea modificar");
        for (VehiculoApoyo vehiculoApoyo : listVehiculosApoyo) {
            if (vehiculoApoyo.getId().equals(idVehiculoModificar)) {
                double nuevoKm = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el kilometraje actualizado"));
                EstadoOperativo NuevoEstadoOperativo = estadoOperativo();
                TipoFuncion NuevoTipoFuncion = tipoFuncion();

                vehiculoApoyo.setKilometraje(nuevoKm);
                vehiculoApoyo.setEstadoOperativo(NuevoEstadoOperativo);
                vehiculoApoyo.setTipoFuncion(NuevoTipoFuncion);
                return true;
            }
        }

        for (VehiculoBlindado vehiculoBlindado : listVehiculosBlindados) {
            if (vehiculoBlindado.getId().equals(idVehiculoModificar)) {
                double nuevoKm = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el kilometraje actualizado"));
                EstadoOperativo NuevoEstadoOperativo = estadoOperativo();
                int nuevoBlindaje = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el blindaje actualizado"));

                vehiculoBlindado.setKilometraje(nuevoKm);
                vehiculoBlindado.setEstadoOperativo(NuevoEstadoOperativo);
                vehiculoBlindado.setNivelBlindaje(nuevoBlindaje);
                return true;
            }
        }
        for (TransporteTropas transporteTropas : listTransporteTropas) {
            if (transporteTropas.getId().equals(idVehiculoModificar)) {
                double nuevoKm = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el kilometraje actualizado"));
                EstadoOperativo NuevoEstadoOperativo = estadoOperativo();
                int nuevaCapacidadSoldados = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el capacidad de soldados"));

                transporteTropas.setKilometraje(nuevoKm);
                transporteTropas.setEstadoOperativo(NuevoEstadoOperativo);
                transporteTropas.setCapacidadSoldados(nuevaCapacidadSoldados);
                return true;
            }
        }
        return false;
    }

    //Se obtiene vehiculos con más de 50 misiones
    public LinkedList<Vehiculo> obtenerVehiculosCantMisiones() {
        LinkedList<Vehiculo> vehiculosMisionesCompletadas = new LinkedList<>();


        for (Vehiculo vehiculo : listVehiculosApoyo) {
            if (vehiculo.getMisionesCompletadas() > 50) {
                vehiculosMisionesCompletadas.add(vehiculo);
            }

        }
        for (Vehiculo vehiculo : listVehiculosBlindados) {
            if (vehiculo.getMisionesCompletadas() > 50) {
                vehiculosMisionesCompletadas.add(vehiculo);
            }
        }

        for (TransporteTropas transporteTropa : listTransporteTropas) {
            if (Vehiculo.getMisionesCompletadas() > 50) {
                vehiculosMisionesCompletadas.add(transporteTropa);
            }
        }
        return vehiculosMisionesCompletadas;


    }

    //Registra una misión y la vincula con un vehiculo
    public boolean registrarMision(LocalDate fechaMision, String ubicacionMision, String idVehiculoMision, LinkedList personal) {
        Boolean flag = false;
        String cantMisionesActuales = String.valueOf(vehiculos.size() + 1);
        Mision newMision = new Mision(cantMisionesActuales, fechaMision, ubicacionMision);
        Soldado soldadoMision = asignarSoldadoMision();
        LinkedList<Soldado> personalMision = new LinkedList<>();
        personalMision.add(soldadoMision);
        newMision.setPersonal(personalMision);

        for (Vehiculo vehiculoBlindado : listVehiculosBlindados) {
            if (vehiculoBlindado.getId().equals(idVehiculoMision)) {
                vehiculoBlindado.setMisionesCompletadas(vehiculoBlindado.getMisionesCompletadas() + 1);
                newMision.setVehiculo(vehiculoBlindado);
                flag = true;
                break;
            }
        }
        for (Vehiculo vehiculoTropas : listTransporteTropas) {
            if (vehiculoTropas.getId().equals(idVehiculoMision)) {
                vehiculoTropas.setMisionesCompletadas(vehiculoTropas.getMisionesCompletadas() + 1);
                newMision.setVehiculo(vehiculoTropas);
                flag = true;
                break;
            }
        }
        for (Vehiculo vehiculoApoyo : listVehiculosApoyo) {
            if (vehiculoApoyo.getId().equals(idVehiculoMision)) {
                vehiculoApoyo.setMisionesCompletadas(vehiculoApoyo.getMisionesCompletadas() + 1);
                newMision.setVehiculo(vehiculoApoyo);
                flag = true;
                break;
            }
        }
        if (flag) {
            listMisiones.add(newMision);
        }
        return flag;
    }

    //Retorna un mensaje con el Kilometraje promedio de cada tipo de vehiculo
    public String promedioKilometrajeTipoVehiculo() {
        String mensajePromedio = "";
        int sumaKmApoyo = 0;
        int sumaKmBlindado = 0;
        int sumaKmTropas = 0;
        //Obtenemos el kilometraje total de cada tipo de vehiculo
        for (Vehiculo vehiculoApoyo : listVehiculosApoyo) {
            sumaKmApoyo += vehiculoApoyo.getKilometraje();
        }
        for (Vehiculo vehiculoBlindado : listVehiculosBlindados) {
            sumaKmBlindado += vehiculoBlindado.getKilometraje();
        }
        for (TransporteTropas vehiculoTransporteTropas : listTransporteTropas) {
            sumaKmTropas += vehiculoTransporteTropas.getKilometraje();
        }
        //Sacamos el promedio de cada uno
        int promedioApoyo = listVehiculosApoyo.isEmpty() ? 0 : sumaKmApoyo / listVehiculosApoyo.size();
        int promedioBlindado = listVehiculosBlindados.isEmpty() ? 0 : sumaKmBlindado / listVehiculosBlindados.size();
        int promedioTransporteTropas = listTransporteTropas.isEmpty() ? 0 : sumaKmTropas / listTransporteTropas.size();

        //Realizamos el mensaje para retornarlo
        mensajePromedio = "Kilometraje promedio por cada tipo de vehiculo:\n\n" +
                "Kilometraje promedio vehiculos de apoyo: " + promedioApoyo + '\n' +
                "Kilometraje promedio vehiculos blindados: " + promedioBlindado + '\n' +
                "Kilometraje promedio vehiculos transportadores de tropas: " + promedioTransporteTropas;
        return mensajePromedio;
    }

    //Obtiene misiones las cuales su ubicación sea la misma ingresada por un usuario
    public LinkedList<Mision> obtenerMisionesUbicacion(String ubicacionMision, LocalDate fechaMisionInicio, LocalDate fechaMisionFin) {
        LinkedList<Mision> misionesFiltradas = new LinkedList<>();
        for (Mision mision : listMisiones) {
            if (mision.getUbicacion().equalsIgnoreCase(ubicacionMision)) {
                LocalDate fechaMision = mision.getFecha();
                if ((fechaMision.isEqual(fechaMisionInicio) || fechaMision.isAfter(fechaMisionInicio)) &&
                        (fechaMision.isEqual(fechaMisionFin) || fechaMision.isBefore(fechaMisionFin))) {
                    misionesFiltradas.add(mision);
                }
            }
        }

        return misionesFiltradas;
    }

    //Retorna el vehiculo con la mayor cantidad de misiones completadas
    public Vehiculo vehiculoMayorCantMisiones() {
        Vehiculo vehiculoMaxCantMisiones = null;
        int maxCantMisiones = 0;
        for (Vehiculo vehiculoApoyo : listVehiculosApoyo) {
            if (vehiculoApoyo.getMisionesCompletadas() > maxCantMisiones) {
                maxCantMisiones = vehiculoApoyo.getMisionesCompletadas();
                vehiculoMaxCantMisiones = vehiculoApoyo;
            }
        }
        for (Vehiculo vehiculoBlindado : listVehiculosBlindados) {
            if (vehiculoBlindado.getMisionesCompletadas() > maxCantMisiones) {
                maxCantMisiones = vehiculoBlindado.getMisionesCompletadas();
                vehiculoMaxCantMisiones = vehiculoBlindado;
            }
        }
        for (TransporteTropas transporteTropas : listTransporteTropas) {
            if (transporteTropas.getMisionesCompletadas() > maxCantMisiones) {
                maxCantMisiones = transporteTropas.getMisionesCompletadas();
                vehiculoMaxCantMisiones = transporteTropas;
            }
        }
        return vehiculoMaxCantMisiones;
    }

    //Retorna una lista de vehiculos fabricados en un año determinado ordenados por tipo y modelo
    public LinkedList<Vehiculo> obtenerVehiculosFabricadosXAnio() {
        LinkedList<Vehiculo> vehiculosUnificados = unificarVehiculos();
        LinkedList<Vehiculo> vehiculosFiltrados = new LinkedList<>();
        int fechaFabricacionBuscar = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Ingrese el año a buscar del vehiculo:"));
        //Filtra los vehiculos que buscan en un año determinado
        for (Vehiculo vehiculo : vehiculosUnificados) {
            if (vehiculo.getFechaFabricacion() == fechaFabricacionBuscar) {
                vehiculosFiltrados.add(vehiculo);
            }
        }
        //Sortea los vehiculos por su tipo de vehiculo y luego por su modelo
        vehiculosFiltrados.sort((vehiculo1, vehiculo2) -> {
            int comparacionTipoVehiculo = vehiculo1.getClass().getSimpleName().compareTo(vehiculo2.getClass().getSimpleName());
            if (comparacionTipoVehiculo == 0) {
                return vehiculo1.getModelo().compareToIgnoreCase(vehiculo2.getModelo());
            }
            return comparacionTipoVehiculo;
        });

        return vehiculosFiltrados;
    }

    //Ordenar vehiculos por misiones completadas descendentemente
    public LinkedList<Vehiculo> vehiculosMisionesCompletadasDescendente() {
        LinkedList<Vehiculo> vehiculosUnificados = unificarVehiculos();

        vehiculosUnificados.sort((vehiculo1, vehiculo2) ->
                Integer.compare(vehiculo2.getMisionesCompletadas(), vehiculo1.getMisionesCompletadas()));

        return vehiculosUnificados;
    }

    //CRUD SOLDADO

    //Obtiene el rango del militar del enum
    public RangoMilitar obtenerRangoMilitar() {
        RangoMilitar rango = null;
        while (rango == null) {
            int option = Integer.parseInt(JOptionPane.showInputDialog(null, "A continuación ingrese el número del rango perteneciente al soldado" +
                    "\n1.Soldado\n2.Cabo\n3.Sargento"));
            switch (option) {
                case 1 -> rango = RangoMilitar.SOLDADO;
                case 2 -> rango = RangoMilitar.CABO;
                case 3 -> rango = RangoMilitar.SARGENTO;
            }
        }
        return rango;
    }

    //Obtiene el area en el que se especializa el soldado desde el enum
    public AreaEspecializacion obtenerAreaEspecializacion() {
        AreaEspecializacion especializacion = null;
        while (especializacion == null) {
            int option = Integer.parseInt(JOptionPane.showInputDialog(null, "A continuación ingrese el número de la función que cumple el soldado:" +
                    "\n1.Médica\n2.Logística\n3.Comunicaciones"));
            switch (option) {
                case 1 -> especializacion = AreaEspecializacion.MEDICO;
                case 2 -> especializacion = AreaEspecializacion.LOGISITCA;
                case 3 -> especializacion = AreaEspecializacion.COMUNICACIONES;
        }
    }
    return especializacion;}

    public boolean verificarIDsoldado(String id){
        for (Soldado verificarSoldado : soldados){
            if (verificarSoldado.getId().equals(id)){
                return false;
            }
        }
        return true;
    }

    public boolean agregarSoldado(Soldado soldado) {
        if (verificarIDsoldado(soldado.getId())) {
            soldados.add(soldado);
            return true;
        }
        return false;
    }

    public LinkedList<Soldado> getSoldados() {
        return soldados;
    }


    // TRABAJO EN CLASE
//    Asignar soldado a una misión
//    Agrega un soldado a la lista de personal de una misión si está disponible. Cambia su estado a no disponible.
//    Liberar soldados al finalizar una misión
//    Recorre todos los soldados de una misión y márcalos como disponibles una vez que la misión haya terminado.
//    Buscar soldados por especialidad
//    Retorna una lista con todos los soldados que tienen una especialidad específica (por ejemplo, "Médico" o "Comunicaciones").
//    Obtener soldados disponibles por rango
//    Dado un rango (por ejemplo, “Cabo”), retorna todos los soldados disponibles que tengan ese rango.
//    Calcular edad promedio del personal
//    Calcula y retorna la edad promedio de los soldados registrados en el batallón.
//    Buscar soldado por ID
//    Implementa un metodo para obtener un soldado específico dado su ID único.



    //Carlos
    public Soldado asignarSoldadoMision(){
        //Agrega un soldado a la lista de personal de una misión si está disponible. Cambia su estado a no disponible.
        Soldado soldadoAsignar = null;
        }
    }





    //----------------- Tomas


    //  3. Buscar soldados por especialidad
    //  Retorna una lista con todos los soldados que tienen una especialidad específica (por ejemplo, "Médico" o "Comunicaciones").
    public LinkedList<Soldado> buscarSoldadosEspecializados(AreaEspecializacion especializacion){
        LinkedList<Soldado> soldadosEspecializados = new LinkedList<>();
        for (Soldado soldado : soldados) {
            if (soldado.getAreaEspecializacion().equals(especializacion)) {
                soldadosEspecializados.add(soldado);
            }
        }
        return soldadosEspecializados;
    }


    // 4. Obtener soldados disponibles por rango
   // Dado un rango (por ejemplo, “Cabo”), retorna todos los soldados disponibles que tengan ese rango.
    public LinkedList<Soldado> buscarSoldadosDisponibles(RangoMilitar rangoMilitar) {
        LinkedList<Soldado> soldadosDisponibles = new LinkedList<>();
        for (Soldado soldado : soldados) {
            if (soldado.getRangoMilitar().equals(rangoMilitar) && !soldado.isEstaEnMision()) {
                soldadosDisponibles.add(soldado);
            }
        }
        return soldadosDisponibles;
    }




    //Juan

    //calcular edad promedio de edad
    public double calcularEdadPromedio(){
        int edadTotal = 0;
        for (Soldado soldado : soldados) {
            edadTotal += soldado.getEdad();
        }
        return (double) edadTotal / soldados.size();
    }
    //buscar soldado por id
    public Soldado buscarSoldado(String idSoldado) {
        for (Soldado soldado : soldados) {
            if (idSoldado.equals(soldado.getId())){
                return soldado;
            }
        }
        return null;
    }
}
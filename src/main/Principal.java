package main;

import adapters.DueñoAdaptador;
import adapters.DueñoAdaptadorConcreto;
import control.Controlador;
import factories.AbstractFactory;
import factories.FactoryConcreta;
import interfaces.DueñoInterface;
import interfaces.MascotaInterface;
import interfaces.ServicioInterface;
import interfaces.TablaUpdaterInterface;
import interfaces.VacunaInterface;
import vista.Vista;

public class Principal {
    public static void main(String[] args) {
        Vista v = new Vista();

        AbstractFactory factory = new FactoryConcreta();
        MascotaInterface m = factory.crearMascota();
        ServicioInterface s = factory.crearServicio();
        VacunaInterface vi = factory.crearVacuna();
        TablaUpdaterInterface tablaUpdater = factory.crearTablaUpdater();

 
        DueñoAdaptador dueñoAdaptador = new DueñoAdaptadorConcreto();
        DueñoInterface d = dueñoAdaptador.obtenerDueñoDesdeFuenteExterna("12345678");

        Controlador c = Controlador.getInstancia(v, d, m, s, vi, tablaUpdater);
    }
}

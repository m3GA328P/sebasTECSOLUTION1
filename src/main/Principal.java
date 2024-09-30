package main;

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

        DueñoInterface d = factory.crearDueño();  
        MascotaInterface m = factory.crearMascota();
        ServicioInterface s = factory.crearServicio(); 
        VacunaInterface vi = factory.crearVacuna(); 
        TablaUpdaterInterface tablaUpdater = factory.crearTablaUpdater();

        Controlador c = Controlador.getInstancia(v, d, m, s, vi, tablaUpdater);
    }
}

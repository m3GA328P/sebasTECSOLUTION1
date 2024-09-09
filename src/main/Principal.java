
package main;

import control.Controlador;
import implementaciones.TablaUpdater;
import interfaces.DueñoInterface;
import interfaces.MascotaInterface;
import interfaces.ServicioInterface;
import interfaces.TablaUpdaterInterface;
import interfaces.VacunaInterface;
import modelo.Dueño;
import modelo.Mascota;
import modelo.Servicio;
import modelo.Vacuna;
import vista.Vista;

public class Principal {
    public static void main(String[] args) {
        Principal p = new Principal();
        Vista v = new Vista();
        DueñoInterface d = new Dueño();  
        MascotaInterface m = new Mascota();
        ServicioInterface s = new Servicio(); 
        VacunaInterface vi = new Vacuna(); 
        TablaUpdaterInterface tablaUpdater = new TablaUpdater(); 

        Controlador c = new Controlador((Vista) v, d, m, s, vi, tablaUpdater);
    }
}
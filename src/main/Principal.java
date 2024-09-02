
package main;

import control.Controlador;
import vista.Vista;

public class Principal {
    public static void main(String[] args) {
        Principal p = new Principal();
        Vista v = new Vista();
        Controlador c = new Controlador(v);
        
    }
}

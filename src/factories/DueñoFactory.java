package factories;

import interfaces.DueñoInterface;
import modelo.Dueño;

public class DueñoFactory {
    public static DueñoInterface crearDueño() {

        return new Dueño.DueñoBuilder()
                .setCedula("defaultCedula")
                .setNombre("defaultNombre")
                .setDireccion("defaultDireccion")
                .setTelefono("defaultTelefono")
                .setGenero("defaultGenero")
                .build();
    }
}

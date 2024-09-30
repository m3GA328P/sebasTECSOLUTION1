package factories;

import interfaces.VacunaInterface;
import modelo.Vacuna;

public class VacunaFactory {
    public static VacunaInterface crearVacuna() {

        return new Vacuna.VacunaBuilder()
                .setNombre("defaultNombre")
                .setValor(0.0)
                .setDosificacion(0)
                .build();
    }
}


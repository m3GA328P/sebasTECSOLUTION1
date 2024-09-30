package factories;

import interfaces.MascotaInterface;
import modelo.Mascota;

public class MascotaFactory {
    public static MascotaInterface crearMascota() {

        return new Mascota.MascotaBuilder()
                .setNombre("defaultNombre")
                .setFechaNacimiento("defaultFechaNacimiento")
                .setCedula("defaultCedula")
                .setRaza("defaultRaza")
                .setPeso(0.0)
                .setUltimaVacuna("defaultUltimaVacuna")
                .build();
    }
}

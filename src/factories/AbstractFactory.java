package factories;

import interfaces.DueñoInterface;
import interfaces.MascotaInterface;
import interfaces.ServicioInterface;
import interfaces.TablaUpdaterInterface;
import interfaces.VacunaInterface;

public interface AbstractFactory {
    DueñoInterface crearDueño();
    MascotaInterface crearMascota();
    ServicioInterface crearServicio();
    VacunaInterface crearVacuna();
    TablaUpdaterInterface crearTablaUpdater();
}

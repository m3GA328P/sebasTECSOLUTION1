package factories;

import interfaces.DueñoInterface;
import interfaces.MascotaInterface;
import interfaces.ServicioInterface;
import interfaces.TablaUpdaterInterface;
import interfaces.VacunaInterface;
import modelo.Dueño;
import modelo.Mascota;
import modelo.Servicio;
import modelo.Vacuna;
import implementaciones.TablaUpdater;

public class FactoryConcreta implements AbstractFactory {
    
    @Override
    public DueñoInterface crearDueño() {
        return new Dueño.DueñoBuilder()
                .setCedula("defaultCedula")
                .setNombre("defaultNombre")
                .setDireccion("defaultDireccion")
                .setTelefono("defaultTelefono")
                .setGenero("defaultGenero")
                .build();
    }

    @Override
    public MascotaInterface crearMascota() {
        return new Mascota.MascotaBuilder()
                .setNombre("defaultNombre")
                .setFechaNacimiento("defaultFecha")
                .setCedula("defaultCedulaDueño")
                .setRaza("defaultRaza")
                .setPeso(0.0)
                .setUltimaVacuna("defaultVacuna")
                .build();
    }

    @Override
    public ServicioInterface crearServicio() {
        return new Servicio.ServicioBuilder()
                .setCodigo("defaultCodigo")
                .setNombre("defaultNombre")
                .setResponsable("defaultResponsable")
                .setTarifa(0.0)
                .build();
    }

    @Override
    public VacunaInterface crearVacuna() {
        return new Vacuna.VacunaBuilder()
                .setNombre("defaultNombre")
                .setValor(0.0)
                .setDosificacion(0)
                .build();
    }

    public TablaUpdaterInterface crearTablaUpdater() {
        return new TablaUpdater();
    }
}

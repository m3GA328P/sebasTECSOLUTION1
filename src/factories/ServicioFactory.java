 package factories;

import interfaces.ServicioInterface;
import modelo.Servicio;

public class ServicioFactory {
    public static ServicioInterface crearServicio() {
  
        return new Servicio.ServicioBuilder()
                .setCodigo("defaultCodigo")
                .setNombre("defaultNombre")
                .setResponsable("defaultResponsable")
                .setTarifa(0.0)
                .build();
    }
}

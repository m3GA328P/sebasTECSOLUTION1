package modelo;

import interfaces.ServicioComponent;

import java.util.ArrayList;
import java.util.List;

public class ServicioComposite implements ServicioComponent {
    private List<ServicioComponent> servicios = new ArrayList<>();

    public void agregarServicio(ServicioComponent servicio) {
        servicios.add(servicio);
    }

    public void eliminarServicio(ServicioComponent servicio) {
        servicios.remove(servicio);
    }

    @Override
    public String getDescripcion() {
        StringBuilder descripcion = new StringBuilder("Servicios Compuestos: \n");
        for (ServicioComponent servicio : servicios) {
            descripcion.append(servicio.getDescripcion()).append("\n");
        }
        return descripcion.toString();
    }

    @Override
    public double getCosto() {
        double costoTotal = 0;
        for (ServicioComponent servicio : servicios) {
            costoTotal += servicio.getCosto();
        }
        return costoTotal;
    }
}

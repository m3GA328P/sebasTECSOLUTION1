package modelo;

import interfaces.ServicioComponent;

public class ServicioLeaf implements ServicioComponent {
    private String descripcion;
    private double costo;

    public ServicioLeaf(String descripcion, double costo) {
        this.descripcion = descripcion;
        this.costo = costo;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public double getCosto() {
        return costo;
    }
}

package modelo;

import interfaces.ServicioInterface;
import java.util.ArrayList;

public class Servicio implements ServicioInterface {
    private String codigo;
    private String nombre;
    private String responsable;
    private Double tarifa;
    private static ArrayList<Servicio> servicios = new ArrayList<>();

    public Servicio() {
    }

    public Servicio(String codigo, String nombre, String responsable, Double tarifa) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.responsable = responsable;
        this.tarifa = tarifa;
    }

    // Getters y setters

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public Double getTarifa() {
        return tarifa;
    }

    public void setTarifa(Double tarifa) {
        this.tarifa = tarifa;
    }

    public static ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public static void setServicios(ArrayList<Servicio> servicios) {
        Servicio.servicios = servicios;
    }

    // Métodos implementados de la interfaz ServicioInterface

    @Override
    public void registrarServicio(String cedulaMascota, String descripcion, String fecha, double costo) {
        servicios.add(new Servicio(cedulaMascota, descripcion, fecha, costo));
    }

    public String buscarServicio(String cedula) {
        for (Servicio servicio : servicios) {
            if (cedula.equals(servicio.getCodigo())) {
                return servicio.getCodigo();
            }
        }
        return null;
    }
}

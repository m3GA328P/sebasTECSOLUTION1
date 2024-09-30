package modelo;

import interfaces.ServicioInterface;
import java.util.ArrayList;

public class Servicio implements ServicioInterface, Cloneable {
    private String codigo;
    private String nombre;
    private String responsable;
    private Double tarifa;
    private static ArrayList<Servicio> servicios = new ArrayList<>();


    private Servicio(ServicioBuilder builder) {
        this.codigo = builder.codigo;
        this.nombre = builder.nombre;
        this.responsable = builder.responsable;
        this.tarifa = builder.tarifa;
    }

 
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getResponsable() {
        return responsable;
    }

    public Double getTarifa() {
        return tarifa;
    }

   
    public void registrarServicio(String codigo, String nombre, String responsable, double tarifa) {
        servicios.add(new ServicioBuilder().setCodigo(codigo).setNombre(nombre)
                                           .setResponsable(responsable).setTarifa(tarifa).build());
    }

   
    public Servicio buscarServicio(String codigo) {
        for (Servicio servicio : servicios) {
            if (codigo.equals(servicio.getCodigo())) {
                return servicio;
            }
        }
        return null;
    }

  
    public static class ServicioBuilder {
        private String codigo;
        private String nombre;
        private String responsable;
        private Double tarifa;

        public ServicioBuilder setCodigo(String codigo) {
            this.codigo = codigo;
            return this;
        }

        public ServicioBuilder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public ServicioBuilder setResponsable(String responsable) {
            this.responsable = responsable;
            return this;
        }

        public ServicioBuilder setTarifa(Double tarifa) {
            this.tarifa = tarifa;
            return this;
        }

        public Servicio build() {
            return new Servicio(this);
        }
    }

    @Override
    public Servicio clone() {
        try {
            return (Servicio) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
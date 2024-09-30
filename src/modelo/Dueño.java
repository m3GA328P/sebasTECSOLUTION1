package modelo;

import interfaces.DueñoInterface;
import java.util.ArrayList;

public class Dueño implements DueñoInterface, Cloneable {
    private String cedula;
    private String nombre;
    private String direccion;
    private String telefono;
    private String genero;
    private ArrayList<Dueño> dueños = new ArrayList<>();


    private Dueño(DueñoBuilder builder) {
        this.cedula = builder.cedula;
        this.nombre = builder.nombre;
        this.direccion = builder.direccion;
        this.telefono = builder.telefono;
        this.genero = builder.genero;
    }


    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getGenero() {
        return genero;
    }


    public void registrarDueño(String cedula, String nombre, String direccion, String telefono, String genero) {
        dueños.add(new DueñoBuilder().setCedula(cedula).setNombre(nombre).setDireccion(direccion)
                                      .setTelefono(telefono).setGenero(genero).build());
    }

    // Builder
    public static class DueñoBuilder {
        private String cedula;
        private String nombre;
        private String direccion;
        private String telefono;
        private String genero;

        public DueñoBuilder setCedula(String cedula) {
            this.cedula = cedula;
            return this;
        }

        public DueñoBuilder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public DueñoBuilder setDireccion(String direccion) {
            this.direccion = direccion;
            return this;
        }

        public DueñoBuilder setTelefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        public DueñoBuilder setGenero(String genero) {
            this.genero = genero;
            return this;
        }

        public Dueño build() {
            return new Dueño(this);
        }
    }
    
      @Override
    public Dueño clone() {
        try {
            return (Dueño) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    

    public String buscarDueño(String cedula) {
        for (Dueño dueño : dueños) {
            if (cedula.equals(dueño.getCedula())) {
                return dueño.getCedula();
            }
        }
        return null;
    }
}

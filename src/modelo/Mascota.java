package modelo;

import interfaces.MascotaInterface;
import java.util.ArrayList;
import java.util.List;

public class Mascota implements MascotaInterface, Cloneable {
    private String nombre;
    private String fechaNacimiento;
    private String cedula;
    private String raza;
    private Double peso;
    private String ultimaVacuna;
    private static List<Mascota> mascotas = new ArrayList<>();

  
    private Mascota(MascotaBuilder builder) {
        this.nombre = builder.nombre;
        this.fechaNacimiento = builder.fechaNacimiento;
        this.cedula = builder.cedula;
        this.raza = builder.raza;
        this.peso = builder.peso;
        this.ultimaVacuna = builder.ultimaVacuna;
    }


    public static class MascotaBuilder {
        private String nombre;
        private String fechaNacimiento;
        private String cedula;
        private String raza;
        private Double peso;
        private String ultimaVacuna;

        public MascotaBuilder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public MascotaBuilder setFechaNacimiento(String fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
            return this;
        }

        public MascotaBuilder setCedula(String cedula) {
            this.cedula = cedula;
            return this;
        }

        public MascotaBuilder setRaza(String raza) {
            this.raza = raza;
            return this;
        }

        public MascotaBuilder setPeso(Double peso) {
            this.peso = peso;
            return this;
        }

        public MascotaBuilder setUltimaVacuna(String ultimaVacuna) {
            this.ultimaVacuna = ultimaVacuna;
            return this;
        }

        public Mascota build() {
            return new Mascota(this);
        }
    }

      @Override
    public Mascota clone() {
        try {
            return (Mascota) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

 
    public void registrarMascota(String nombre, String fechaNacimiento, String cedula, String raza, double peso, String ultimaVacuna) {
        mascotas.add(new MascotaBuilder().setNombre(nombre).setFechaNacimiento(fechaNacimiento).setCedula(cedula)
                                         .setRaza(raza).setPeso(peso).setUltimaVacuna(ultimaVacuna).build());
    }

    @Override
    public Mascota buscarMascota(String cedula) {
        for (Mascota mascota : mascotas) {
            if (cedula.equals(mascota.getCedula())) {
                return mascota;
            }
        }
        return null;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getUltimaVacuna() {
        return ultimaVacuna;
    }

    public void setUltimaVacuna(String ultimaVacuna) {
        this.ultimaVacuna = ultimaVacuna;
    }
}

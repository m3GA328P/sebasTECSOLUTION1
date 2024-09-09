package modelo;

import interfaces.MascotaInterface;
import java.util.ArrayList;
import java.util.List;

public class Mascota implements MascotaInterface {
    private String nombre;
    private String fechaNacimiento;
    private String cedula;
    private String raza;
    private Double peso;
    private String ultimaVacuna;
    private static List<Mascota> mascotas = new ArrayList<>();

    public Mascota() {
    }

    public Mascota(String nombre, String fechaNacimiento, String cedula, String raza, Double peso, String ultimaVacuna) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.cedula = cedula;
        this.raza = raza;
        this.peso = peso;
        this.ultimaVacuna = ultimaVacuna;
    }

    @Override
    public void registrarMascota(String nombre, String fechaNacimiento, String cedulaDueño, String raza, double peso, String ultimaVacuna) {
        mascotas.add(new Mascota(nombre, fechaNacimiento, cedulaDueño, raza, peso, ultimaVacuna));
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

    // Getters y setters

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

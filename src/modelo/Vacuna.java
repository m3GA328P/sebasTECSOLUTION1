package modelo;

import interfaces.VacunaInterface;
import java.util.ArrayList;
import javax.swing.JTable;

public class Vacuna implements VacunaInterface, Cloneable {
    private String nombre;
    private Double valor;
    private Integer dosificacion;
    private ArrayList<Vacuna> vacunas = new ArrayList<>();

  
    private Vacuna(VacunaBuilder builder) {
        this.nombre = builder.nombre;
        this.valor = builder.valor;
        this.dosificacion = builder.dosificacion;
    }


    public String getNombre() {
        return nombre;
    }

    public Double getValor() {
        return valor;
    }

    public Integer getDosificacion() {
        return dosificacion;
    }

  
    public void registrarVacuna(String nombre, Double valor, Integer dosificacion) {
        vacunas.add(new VacunaBuilder().setNombre(nombre).setValor(valor)
                                       .setDosificacion(dosificacion).build());
    }


    public Vacuna buscarVacuna(String nombre) {
        for (Vacuna vacuna : vacunas) {
            if (nombre.equals(vacuna.getNombre())) {
                return vacuna;
            }
        }
        return null;
    }

    @Override
    public void actualizarTabla(JTable tabla, Object[] datos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    public static class VacunaBuilder {
        private String nombre;
        private Double valor;
        private Integer dosificacion;

        public VacunaBuilder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public VacunaBuilder setValor(Double valor) {
            this.valor = valor;
            return this;
        }

        public VacunaBuilder setDosificacion(Integer dosificacion) {
            this.dosificacion = dosificacion;
            return this;
        }

        public Vacuna build() {
            return new Vacuna(this);
        }
    }

    @Override
    public Vacuna clone() {
        try {
            return (Vacuna) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
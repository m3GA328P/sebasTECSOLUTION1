
package interfaces;

import modelo.Mascota;


public interface MascotaInterface {
     void registrarMascota(String nombre, String fechaNacimiento, String cedulaDueño, String raza, double peso, String ultimaVacuna);
    Mascota buscarMascota(String cedulaDueño);
}

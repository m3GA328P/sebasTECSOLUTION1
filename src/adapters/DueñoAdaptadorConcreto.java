package adapters;

import modelo.Dueño;

public class DueñoAdaptadorConcreto implements DueñoAdaptador {
    @Override
    public Dueño obtenerDueñoDesdeFuenteExterna(String identificador) {
   
        return new Dueño.DueñoBuilder()
                .setCedula(identificador)
                .setNombre("Nombre Ejemplo")
                .setDireccion("Dirección Ejemplo")
                .setTelefono("123456789")
                .setGenero("Masculino")
                .build();
    }
}

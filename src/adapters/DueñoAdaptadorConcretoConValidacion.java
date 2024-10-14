package adapters;

import modelo.Dueño;

public class DueñoAdaptadorConcretoConValidacion extends DueñoAdaptadorDecorator {

    public DueñoAdaptadorConcretoConValidacion(DueñoAdaptador adaptador) {
        super(adaptador);
    }

    @Override
    public Dueño obtenerDueñoDesdeFuenteExterna(String identificador) {
    
        if (identificador == null || identificador.isEmpty()) {
            throw new IllegalArgumentException("El identificador no puede estar vacío");
        }


        Dueño dueño = adaptador.obtenerDueñoDesdeFuenteExterna(identificador);

 
        return dueño;
    }
}

package adapters;

import modelo.Dueño;

public abstract class DueñoAdaptadorDecorator implements DueñoAdaptador {
    protected DueñoAdaptador adaptador;

    public DueñoAdaptadorDecorator(DueñoAdaptador adaptador) {
        this.adaptador = adaptador;
    }

    @Override
    public Dueño obtenerDueñoDesdeFuenteExterna(String identificador) {
        return adaptador.obtenerDueñoDesdeFuenteExterna(identificador);
    }
}

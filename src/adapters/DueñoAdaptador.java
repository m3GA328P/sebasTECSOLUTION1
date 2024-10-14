package adapters;

import modelo.Dueño;

public interface DueñoAdaptador {
    Dueño obtenerDueñoDesdeFuenteExterna(String identificador);
}

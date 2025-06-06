import java.util.ArrayList;
import java.util.List;

public class ArbolBusqueda {
    private NodoArbol raiz;

    public ArbolBusqueda(List<Documento> documentos) {
        for (Documento d : documentos) {
            insertar(d);
        }
    }

    private void insertar(Documento d) {
        raiz = insertarRec(raiz, d);
    }

    private NodoArbol insertarRec(NodoArbol actual, Documento d) {
        if (actual == null) {
            return new NodoArbol(d);
        }

        if (d.getNombreCompleto().compareToIgnoreCase(actual.getClave()) < 0) {
            actual.izquierdo = insertarRec(actual.izquierdo, d);
        } else {
            actual.derecho = insertarRec(actual.derecho, d);
        }

        return actual;
    }

    public List<Documento> buscarCoincidencias(String texto) {
        List<Documento> resultado = new ArrayList<>();
        texto = texto.toLowerCase();
        buscarRec(raiz, texto, resultado);
        return resultado;
    }

    private void buscarRec(NodoArbol actual, String texto, List<Documento> resultado) {
        if (actual == null) return;

        if (actual.getClave().contains(texto)) {
            resultado.add(actual.documento);
        }

        buscarRec(actual.izquierdo, texto, resultado);
        buscarRec(actual.derecho, texto, resultado);
    }
}

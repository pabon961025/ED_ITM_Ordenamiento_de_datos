public class NodoArbol {
    public Documento documento;
    public NodoArbol izquierdo;
    public NodoArbol derecho;

    public NodoArbol(Documento documento) {
        this.documento = documento;
        this.izquierdo = null;
        this.derecho = null;
    }

    public String getClave() {
        return documento.getNombreCompleto().toLowerCase();
    }
}

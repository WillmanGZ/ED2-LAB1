package lab1;

public class Nodo {

    String nombre;
    String descripcion;
    String acertijo;
    String respuesta;
    int dificultad;
    Nodo izquierda;
    Nodo derecha;

    public Nodo(String nombre, String descripcion, String acertijo, String respuesta, int dificultad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.acertijo = acertijo;
        this.respuesta = respuesta;
        this.dificultad = dificultad;
        this.izquierda = null;
        this.derecha = null;
    }
}

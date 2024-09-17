package lab1;

import java.util.Random;

public class Arbol {

    Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    public void agregarNodo(String nombre, String descripcion, String acertijo, String respuesta, int dificultad, Nodo nodo) { //Ese Nodo nodo es de donde va a partir para agregar
        Nodo nuevoNodo = new Nodo(nombre, descripcion, acertijo, respuesta, dificultad);

        //Si el arbol no tiene raiz, entonces el nuevo nodo pasará a ser su raiz
        if (this.raiz == null) {
            this.raiz = nuevoNodo;
            return;
        }

        Nodo actual = nodo;

        //Si la dificultad del nuevo nodo es menor a la del nodo actual, pasa a la izquierda, si no tiene hijo pasa a ser el hijo izquerdo, sino, recursivamente pasa al nodo izquierdo
        if (nuevoNodo.dificultad < actual.dificultad) {
            if (actual.izquierda == null) {
                actual.izquierda = nuevoNodo;
                return;
            } else {
                this.agregarNodo(nuevoNodo.nombre, nuevoNodo.descripcion, nuevoNodo.acertijo, nuevoNodo.respuesta, nuevoNodo.dificultad, actual.izquierda);
            }
        }

        //Si la dificultad del nuevo nodo es mayor a la del nodo actual, pasa a la derecha, si no tiene hijo pasa a ser el hijo derecho, sino, recursivamente pasa al nodo derecho
        if (nuevoNodo.dificultad > actual.dificultad) {
            if (actual.derecha == null) {
                actual.derecha = nuevoNodo;
                return;
            } else {
                this.agregarNodo(nuevoNodo.nombre, nuevoNodo.descripcion, nuevoNodo.acertijo, nuevoNodo.respuesta, nuevoNodo.dificultad, actual.derecha);
            }
        }

        // Si la dificultad es igual, usamos un criterio de aleatoriedad
        if (nuevoNodo.dificultad == actual.dificultad) {
            Random random = new Random();
            // Generar un número aleatorio entre 0 y 1 para decidir si va a la izquierda o derecha
            if (random.nextBoolean()) {
                // Si el número es "true" va a la izquierda
                if (actual.izquierda == null) {
                    actual.izquierda = nuevoNodo;
                } else {
                    this.agregarNodo(nuevoNodo.nombre, nuevoNodo.descripcion, nuevoNodo.acertijo, nuevoNodo.respuesta, nuevoNodo.dificultad, actual.izquierda);
                }
            } else {
                // Si el número es "false" va a la derecha
                if (actual.derecha == null) {
                    actual.derecha = nuevoNodo;
                } else {
                    this.agregarNodo(nuevoNodo.nombre, nuevoNodo.descripcion, nuevoNodo.acertijo, nuevoNodo.respuesta, nuevoNodo.dificultad, actual.derecha);
                }
            }
        }
    }

}

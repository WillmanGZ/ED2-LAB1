package lab1;

import java.util.Random;
import java.util.Scanner;

public class Arbol {

    Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    public void iniciarJuego() throws InterruptedException {
        Boolean jugando = true;
        Scanner sc = new Scanner(System.in);
        Nodo nivelActual = this.raiz;

        while (jugando) { //Mientras que el jugador esté jugando

            if (nivelActual == null) {
                System.out.println("Este juego no tiene niveles añadidos");
                jugando = false;
            }

            System.out.println(nivelActual.nombre);
            System.out.println("");
            System.out.println(nivelActual.descripcion);
            System.out.println("");
            System.out.println("El acertijo es: ");
            System.out.println(nivelActual.acertijo);
            System.out.println("");
            System.out.print("Digite su respuesta: ");
            String respuesta = sc.next().toLowerCase();

            if (nivelActual == this.raiz) {
                while (!respuesta.equals("si") && !respuesta.equals("salir")) {
                    System.out.println("");
                    System.out.println("Respuesta invalida, escribe 'si' para iniciar o 'salir' para salir del juego");
                    respuesta = sc.next();
                }

                if (respuesta.equals("salir")) {
                    System.out.println("");
                    System.out.println("Esperamos verte pronto!");
                    return;
                }
            }

            //Si la respuesta es correcta
            if (respuesta.toLowerCase().equals(nivelActual.respuesta.toLowerCase())) {
                if (nivelActual.izquierda != null || nivelActual.derecha != null) { //Si todavía contiene niveles
                    System.out.println("");
                    System.out.print("Has acertado, quieres pasar al proximo nivel? Escribe Si o No: ");
                    String seguir = sc.next().toLowerCase();
                    while (!seguir.equals("si") && !seguir.equals("no")) {
                        System.out.println("");
                        System.out.println("Respuesta invalida, escribe 'si' para continuar o 'no' para salir del juego");
                        seguir = sc.next().toLowerCase();
                    }
                    if (seguir.equals("no")) { //Si responde que no
                        System.out.println("");
                        System.out.println("Esperamos verte pronto!");
                        jugando = false;
                    } else if (seguir.equals("si")) { //Si responde que si
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("--------------------------------------------------------------");
                        Random random = new Random();
                        if (nivelActual.izquierda != null && nivelActual.derecha != null) { //Si tiene los dos niveles disponibles, eligé de manera aleatoria el proximo
                            if (random.nextBoolean()) {
                                nivelActual = nivelActual.izquierda;
                            } else {
                                nivelActual = nivelActual.derecha;
                            }
                        } //Si solo uno de los dos niveles está disponible, elegirá el disponible
                        else if (nivelActual.izquierda == null) {
                            nivelActual = nivelActual.derecha;
                        } else if (nivelActual.derecha == null) {
                            nivelActual = nivelActual.izquierda;
                        }
                    }
                } else {// Si no tiene mas niveles
                    System.out.println("");
                    System.out.println("Ya no hay mas niveles, has ganado.");
                    jugando = false;
                }

            } else { //Si la respuesta es incorrecta

                System.out.println("");
                System.out.println("Respuesta incorrecta, repetirás el nivel, buena suerte en el proximo intento.");
                try {
                    // Retrasa el programa por 5 segundos
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("----------------------------------------------------------------");

            }
        }
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
// Leer (Recorrer el árbol in-order para mostrar todos los nodos)

    public void mostrarArbol(Nodo nodo) {
        if (nodo != null) {
            mostrarArbol(nodo.izquierda);
            System.out.println("Escenario: " + nodo.nombre + " | Descripción: " + nodo.descripcion + " | Dificultad: " + nodo.dificultad);
            mostrarArbol(nodo.derecha);
        }
    }

    // Buscar un nodo por nombre
    public Nodo buscarNodo(String nombre, Nodo nodo) {
        if (nodo == null || nodo.nombre.equals(nombre)) {
            return nodo;
        }

        Nodo encontrado = buscarNodo(nombre, nodo.izquierda);
        if (encontrado == null) {
            encontrado = buscarNodo(nombre, nodo.derecha);
        }
        return encontrado;
    }

    // Actualizar un nodo (nombre, descripción, acertijo o respuesta)
    public void actualizarNodo(String nombre, String nuevoNombre, String nuevaDescripcion, String nuevoAcertijo, String nuevaRespuesta, Nodo nodo) {
        Nodo nodoAActualizar = buscarNodo(nombre, nodo);

        if (nodoAActualizar != null) {
            nodoAActualizar.nombre = nuevoNombre;
            nodoAActualizar.descripcion = nuevaDescripcion;
            nodoAActualizar.acertijo = nuevoAcertijo;
            nodoAActualizar.respuesta = nuevaRespuesta;
            System.out.println("Nodo actualizado exitosamente.");
        } else {
            System.out.println("Nodo no encontrado.");
        }
    }

    // Eliminar un nodo del árbol
    public Nodo eliminarNodo(Nodo raiz, String nombre) {
        if (raiz == null) {
            return null;
        }

        // Buscar el nodo a eliminar
        if (nombre.compareTo(raiz.nombre) < 0) {
            raiz.izquierda = eliminarNodo(raiz.izquierda, nombre);
        } else if (nombre.compareTo(raiz.nombre) > 0) {
            raiz.derecha = eliminarNodo(raiz.derecha, nombre);
        } else {
            // Nodo encontrado
            // Caso 1: Sin hijos
            if (raiz.izquierda == null && raiz.derecha == null) {
                return null;
            }

            // Caso 2: Un hijo
            if (raiz.izquierda == null) {
                return raiz.derecha;
            } else if (raiz.derecha == null) {
                return raiz.izquierda;
            }

            // Caso 3: Dos hijos
            Nodo sucesor = obtenerNodoMinimo(raiz.derecha);
            raiz.nombre = sucesor.nombre;
            raiz.descripcion = sucesor.descripcion;
            raiz.acertijo = sucesor.acertijo;
            raiz.respuesta = sucesor.respuesta;
            raiz.dificultad = sucesor.dificultad;
            raiz.derecha = eliminarNodo(raiz.derecha, sucesor.nombre);
        }
        return raiz;
    }

    // Obtener el nodo con el valor mínimo (usado en el caso de dos hijos)
    public Nodo obtenerNodoMinimo(Nodo nodo) {
        while (nodo.izquierda != null) {
            nodo = nodo.izquierda;
        }
        return nodo;
    }
}

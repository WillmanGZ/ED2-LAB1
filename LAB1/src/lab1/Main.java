package lab1;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Arbol arbol = new Arbol();
        arbol.agregarNodo("Bienvenid@!", "Bienvenido al juego! Preparate para comenzar tu aventura. Toma tus decisiones con cuidado y diviertete explorando. Buena suerte!", "Escribe 'si' para iniciar", "si", 0, arbol.raiz);
        arbol.agregarNodo("Continente del Sahara", "Geografia", "En que continente se encuentra el desierto del Sahara", "Africa", 1, arbol.raiz);
        arbol.agregarNodo("Elemento Au", "Quimica", "Que elemento quimico tiene el simbolo Au", "Oro", 2, arbol.raiz);
        arbol.agregarNodo("Llegada a la Luna", "Historia", "En que ano llego el hombre a la luna", "1969", 3, arbol.raiz);
        arbol.agregarNodo("Pais mas Grande", "Geografia", "Cual es el pais mas grande del mundo por superficie", "Rusia", 4, arbol.raiz);
        arbol.agregarNodo("Jugadores de Futbol", "Deportes", "Cuantos jugadores hay en un equipo de futbol en el campo", "11", 5, arbol.raiz);
        arbol.iniciarJuego();
    }

}

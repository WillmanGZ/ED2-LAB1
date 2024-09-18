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
        arbol.agregarNodo("Inventor de Microsoft", "Tecnologia", "Bill Gates es el fundador de Microsoft", "Verdadero", 1, arbol.raiz);
        arbol.agregarNodo("Tabla periodica", "Ciencias", "La tabla periodica tiene 118 elementos", "Verdadero", 2, arbol.raiz);
        arbol.agregarNodo("El Renacimiento", "Arte", "El Renacimiento fue un movimiento artistico del siglo XV", "Verdadero", 3, arbol.raiz);
        arbol.agregarNodo("Torre Eiffel", "Cultura Pop", "La Torre Eiffel esta en Berlin", "Falso", 5, arbol.raiz);
        arbol.agregarNodo("El baloncesto", "Deportes", "El baloncesto fue inventado en Estados Unidos", "Verdadero", 4, arbol.raiz);
        arbol.agregarNodo("La independencia", "Historia", "La independencia de Mexico se declaro en 1821", "Falso", 8, arbol.raiz);
        arbol.agregarNodo("Rayos", "Ciencias", "Los rayos siempre caen en el mismo lugar", "Falso", 3, arbol.raiz);

        arbol.iniciarJuego();
    }

}

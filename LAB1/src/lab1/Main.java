package lab1;

public class Main {

    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        arbol.agregarNodo("Entrada del Bosque", "Te encuentras al inicio de un misterioso bosque lleno de secretos.", "¿Qué crece hacia abajo?", "Raíz", 3, arbol.raiz);
        arbol.agregarNodo("Cueva Oscura", "Una cueva siniestra con una entrada oscura que parece no tener fin.", "¿Qué cosa cuanto más grande menos ves?", "Oscuridad", 5, arbol.raiz);
        arbol.agregarNodo("Río Tranquilo", "Un río que fluye suavemente, sus aguas parecen reflejar el cielo.", "Soy agua pero no mojo, ¿quién soy?", "Reflejo", 2, arbol.raiz);
        arbol.agregarNodo("Montaña Alta", "Una montaña que se eleva hacia las nubes, desafiando a quienes intentan escalarla.", "Mientras más subes, menos te llevas, ¿qué soy?", "Altitud", 5, arbol.raiz);
        arbol.agregarNodo("Valle Misterioso", "Un valle cubierto de neblina que oculta muchos misterios.", "Vuelo sin alas y lloro sin ojos, ¿quién soy?", "Nube", 1, arbol.raiz);
        arbol.agregarNodo("Ruinas Antiguas", "Ruinas de una civilización perdida que todavía guarda muchos secretos.", "Soy fuerte pero me rompo si me miras, ¿quién soy?", "Silencio", 4, arbol.raiz);
    }

}

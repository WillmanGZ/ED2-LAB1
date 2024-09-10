from Arbol import *
class Juego:
    juego = Arbol()
    
    nivel1 = Nodo("Nivel1", "Nivel1", 1, "Nivel1", "Nivel1")
    nivel2 = Nodo("Nivel2", "Nivel2", 2, "Nivel2", "Nivel2")
    nivel3 = Nodo("Nivel3", "Nivel3", 3, "Nivel3", "Nivel3")
    juego.agregar_nodo(nivel1)
    juego.agregar_nodo(nivel2)
    juego.agregar_nodo(nivel3)
    
    print(juego.raiz.descripcion)
    print(juego.raiz.izquierda.descripcion)
    print(juego.raiz.derecha.descripcion)
from Nodo import *

class Arbol:
    def __init__(self, raiz: Nodo=None):
        self.raiz = raiz
        
        
    def agregar_nodo(self, nuevoNodo: Nodo):
        if self.raiz is None:
            self.raiz = nuevoNodo
        else:
            self._agregar_recursivo(self.raiz, nuevoNodo)
    
    def _agregar_recursivo(self, nodo: Nodo, nuevoNodo: Nodo):
        if nuevoNodo.nivel < nodo.nivel:
            if nodo.izquierda is None:
                nodo.izquierda = nuevoNodo
            else:
                self._agregar_recursivo(nodo.izquierda, nuevoNodo)
        elif nuevoNodo.nivel > nodo.nivel:
            if nodo.derecha is None:
                nodo.derecha = nuevoNodo
            else:
                self._agregar_recursivo(nodo.derecha, nuevoNodo)
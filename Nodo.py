class Nodo:
    def __init__(self, nombre: str, descripcion: str, nivel: int, acertijo: str, respuesta : str, izquierda=None, derecha=None):
        self.nombre = nombre
        self.descripcion = descripcion
        self.nivel = nivel
        self.acertijo = acertijo
        self.respuesta = respuesta
        self.izquierda = izquierda
        self.derecha = derecha
# Sofka_Task_SpringBoot_Mongodb_Library

Consultar disponibilidad de un recurso indicando en un mensaje si esta disponible o no. en caso de no estar disponible presentar la fecha del préstamo actual del ultimo ejemplar

rest: "/listMaterialAvailable/{name}"

Prestar un recurso, se debe comprobar si esta prestado o no, indicarlo mediante un mensaje. Si se encuentra disponible debemos marcarlo como prestado y registrar la fecha del préstamo (no es necesario llevar el historia de prestamos).

rest: "/borrow/{id}"

Recomendar un listado de recursos al usuario a partir del tipo de recurso, del área temática o de los dos. Los recursos están clasificados por tipo de recurso (libros, revistas, fichas, etc) pero también por área temática (ciencias, naturaleza, historia, etc).

rest: "/listByThematicArea/{search}"
      "/listTypeMaterial/{search}"

Devolver un recurso que se encontraba prestado, obviamente si un recurso no se encuentra en préstamo no podrá ser devuelto. Indicar el resultado con un mensaje.

rest: "/return/{id}"


{
    "typeMaterial": "Libro",
    "thematicArea": "Guerra",
    "name": "La Odisea",
    "numberCopyMaterial": 1,
    "borrowDateMaterial": null,
    "available": true
}

{
    "typeMaterial": "Libro",
    "thematicArea": "Guerra",
    "name": "La Odisea",
    "numberCopyMaterial": 2,
    "borrowDateMaterial": null,
    "available": true
}

{
    "typeMaterial": "Libro",
    "thematicArea": "Guerra",
    "name": "La Odisea",
    "numberCopyMaterial": 3,
    "borrowDateMaterial": null,
    "available": true
}

{
    "typeMaterial": "Revista",
    "thematicArea": "Noticias",
    "name": "Revsta Semana",
    "numberCopyMaterial": 1,
    "borrowDateMaterial": null,
    "available": true
}


{
    "typeMaterial": "Revista",
    "thematicArea": "Noticias",
    "name": "Revsta Semana",
    "numberCopyMaterial": 2,
    "borrowDateMaterial": null,
    "available": true
}


{
    "typeMaterial": "Revista",
    "thematicArea": "Noticias",
    "name": "Revsta Semana",
    "numberCopyMaterial": 3,
    "borrowDateMaterial": null,
    "available": true
}


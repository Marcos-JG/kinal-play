package org.algorix.kinal_play.dominio.exception;

public class PeliculaNoExisteExpection extends RuntimeException{
    public PeliculaNoExisteExpection(Long codigoPelicula) {
        super("La pelicula con codigo " + codigoPelicula + " no existe en el sistema.");

    }
}

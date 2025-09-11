package org.algorix.kinal_play.dominio.exception;

public class PeliculaYaExisteException extends  RuntimeException{
    public PeliculaYaExisteException(String peliculaTitulo){
        super("La pelicula con titulo " + peliculaTitulo + " ya existe en el sistema.");
    }
}

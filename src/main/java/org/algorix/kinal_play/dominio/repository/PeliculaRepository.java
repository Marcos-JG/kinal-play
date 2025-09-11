package org.algorix.kinal_play.dominio.repository;

import org.algorix.kinal_play.dominio.dto.ModPeliculaDto;
import org.algorix.kinal_play.dominio.dto.PeliculaDto;

import java.util.List;

public interface PeliculaRepository {
    //firmas del mantenimiento de DTO
    //1 Inici
    List<PeliculaDto> obtenerTodo();
    PeliculaDto obtenerPeliculaPorCodigo(Long codigo);
    PeliculaDto guardarPelicula(PeliculaDto peliculaDto);
    PeliculaDto modificarPelicula(Long codigo, ModPeliculaDto peliculaDto);
    void eliminarPelicula(Long codigo);
}

package org.algorix.kinal_play.dominio.repository;

import org.algorix.kinal_play.dominio.dto.PeliculaDto;

import java.util.List;

public interface PeliculaRepository {
    //firmas del mantenimiento de DTO
    List<PeliculaDto> obtenerTodo();

}

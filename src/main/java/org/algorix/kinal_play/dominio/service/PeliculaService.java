package org.algorix.kinal_play.dominio.service;

import lombok.Data;
import org.algorix.kinal_play.dominio.dto.ModPeliculaDto;
import org.algorix.kinal_play.dominio.dto.PeliculaDto;
import org.algorix.kinal_play.dominio.repository.PeliculaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PeliculaService {
    private final PeliculaRepository peliculaRepository;

    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public List<PeliculaDto> obtenerTodo() {
        return this.peliculaRepository.obtenerTodo();
    }

    //2 continua con el servicio
    public PeliculaDto obtenerPeliculaPorCodigo(Long codigo){
        return this.peliculaRepository.obtenerPeliculaPorCodigo(codigo);
    }

    public PeliculaDto guardarPelicula(PeliculaDto peliculaDto){
        return this.peliculaRepository.guardarPelicula(peliculaDto);

    }

    public PeliculaDto modficarPelicula(Long codigo, ModPeliculaDto modPeliculaDto){
        return this.peliculaRepository.modificarPelicula(codigo, modPeliculaDto);
    }
}

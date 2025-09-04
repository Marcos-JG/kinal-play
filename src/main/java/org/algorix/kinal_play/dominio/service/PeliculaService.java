package org.algorix.kinal_play.dominio.service;

import lombok.Data;
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
}

package org.algorix.kinal_play.persistence;
import lombok.Data;
import org.algorix.kinal_play.dominio.dto.ModPeliculaDto;
import org.algorix.kinal_play.dominio.dto.PeliculaDto;
import org.algorix.kinal_play.dominio.repository.PeliculaRepository;
import org.algorix.kinal_play.persistence.crud.CrudPeliculaEntity;
import org.algorix.kinal_play.persistence.entity.PeliculaEntity;
import org.algorix.kinal_play.web.mapper.PeliculaMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class PeliculaEntityRepository implements PeliculaRepository {

    private final CrudPeliculaEntity crudPelicula;
    private final PeliculaMapper peliculaMapper;

    //Inyeccion de dependencias implicito sin el @Autowired
    public PeliculaEntityRepository(CrudPeliculaEntity crudPelicula, PeliculaMapper peliculaMapper) {
        this.crudPelicula = crudPelicula;
        this.peliculaMapper = peliculaMapper;
    }
    //3
    @Override
    public List<PeliculaDto> obtenerTodo() {
        return this.peliculaMapper.toDto(this.crudPelicula.findAll());
    }


    @Override
    public PeliculaDto obtenerPeliculaPorCodigo(Long codigo) {
        return this.peliculaMapper.toDto(this.crudPelicula.findById(codigo).orElse(null));
    }

    @Override
    public PeliculaDto guardarPelicula(PeliculaDto peliculaDto) {
        //instanciar clase de entidad
        PeliculaEntity pelicula = new PeliculaEntity();
        //convertir dto a entidad
        pelicula = this.peliculaMapper.toEntity(peliculaDto);
        pelicula.setEstado("D");
        //guardar en la DB con JPA
        this.crudPelicula.save(pelicula);
        //Retornar el valor guardado como DTO
        return this.peliculaMapper.toDto(pelicula);
    }

    @Override
    public PeliculaDto modificarPelicula(Long codigo, ModPeliculaDto modPeliculaDto) {
        PeliculaEntity pelicula = this.crudPelicula.findById(codigo).orElse(null);
        pelicula.setNombre(modPeliculaDto.name());
        pelicula.setFechaEstreno(modPeliculaDto.releaseDate());
        pelicula.setCalificacion(BigDecimal.valueOf(modPeliculaDto.rating()));
        this.crudPelicula.save(pelicula);
        return this.peliculaMapper.toDto(pelicula);
    }
}

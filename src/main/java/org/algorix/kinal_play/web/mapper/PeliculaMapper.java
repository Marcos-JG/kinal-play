package org.algorix.kinal_play.web.mapper;
import org.algorix.kinal_play.dominio.dto.ModPeliculaDto;
import org.algorix.kinal_play.dominio.dto.PeliculaDto;
import org.algorix.kinal_play.persistence.entity.PeliculaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {GenreMapper.class})
public interface PeliculaMapper {
    //Firmas de métodos: toDTO -> convertir a dto

    @Mapping(source = "nombre",target = "name")
    @Mapping(source = "duracion",target = "duration")
    @Mapping(source = "genero",target = "genre",qualifiedByName = "generarGenre" )
    @Mapping(source = "fechaEstreno",target = "releaseDate")
    @Mapping(source = "calificacion",target = "rating")
    public PeliculaDto toDto(PeliculaEntity entity);

   public List<PeliculaDto> toDto(Iterable <PeliculaEntity> entities);
    //para convertir DTO a entity -> toEntity
    @InheritInverseConfiguration
    @Mapping(source = "genre", target = "genero", qualifiedByName = "generarGenero")
    PeliculaEntity toEntity(PeliculaDto peliculaDto);

    //Auto actualizar el ModPeliculasDto a PeliculaEntity
    @Mapping(source = "name",target = "nombre")
    @Mapping(source = "releaseDate",target = "fechaEstreno")
    @Mapping(source = "rating",target = "calificacion")
    void modificarEntityFromDto(ModPeliculaDto modPeliculaDto,@MappingTarget PeliculaEntity peliculaEntity);



}

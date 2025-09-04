package org.algorix.kinal_play.persistence.crud;

import org.algorix.kinal_play.persistence.entity.PeliculaEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudPeliculaEntity extends CrudRepository<PeliculaEntity, Long > {
}

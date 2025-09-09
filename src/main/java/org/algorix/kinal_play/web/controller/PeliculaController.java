package org.algorix.kinal_play.web.controller;
import org.algorix.kinal_play.dominio.dto.PeliculaDto;
import org.algorix.kinal_play.dominio.service.PeliculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peliculas/v1")
public class PeliculaController {
    private final PeliculaService  peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }
     //4
    @GetMapping
    public ResponseEntity<List<PeliculaDto>> obtenerTodo(){
        //200: OK
        //404: Not Found, no existe, mal nombre
        //500: Internal Server Error, error de lógica
        //405: Method de solicitud incorrecto, el verbo no es correcto
        //return this.peliculaService.obtenerTodo();
        return ResponseEntity.ok(this.peliculaService.obtenerTodo());
    }

    @GetMapping("{codigo}")
    public ResponseEntity<PeliculaDto> obtenerPeliculaPorCodigo(@PathVariable Long codigo){
        //return this.peliculaService.obtenerPeliculaPorCodigo(codigo);
        return ResponseEntity.ok(this.peliculaService.obtenerPeliculaPorCodigo(codigo));
    }
    //guardar pelicula
    @PostMapping
    public ResponseEntity<PeliculaDto> guardarPelicula(@RequestBody PeliculaDto peliculaDto){
        //return this.peliculaService.guardarPelicula(peliculaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.peliculaService.guardarPelicula(peliculaDto));
    }
    //modificar pelicula
    @PutMapping
    public ResponseEntity<PeliculaDto> modificarPelicula(@PathVariable Long codigo, @RequestBody PeliculaDto peliculaDto){
        return ResponseEntity.ok().build();
    }
    //eliminar pelicula

    //exception - peliculaNoExiste - PeliculaYaExiste

    //Consulta a la IA

    //Validaciones (dependencias)

    //Documentación (dependencias)
}

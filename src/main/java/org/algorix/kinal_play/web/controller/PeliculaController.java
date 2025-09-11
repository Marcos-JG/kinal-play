package org.algorix.kinal_play.web.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.algorix.kinal_play.dominio.dto.ModPeliculaDto;
import org.algorix.kinal_play.dominio.dto.PeliculaDto;
import org.algorix.kinal_play.dominio.service.PeliculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/peliculas")
@Tag(name = "Peliculas", description = "Operaciones (CRUD) sobre las peliculas de Kinal Play")
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
    @Operation(
            summary = "Obtener una pelicula a partir de su identificador",
            description = "Retorna la pelicula que coincide con el identificador proporcionado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Pelicula encontrada con exito"),
                    @ApiResponse(responseCode = "400", description = "Pelicula no encontrada",
                            content = @Content)
            }
    )
    public ResponseEntity<PeliculaDto> obtenerPeliculaPorCodigo(
            @Parameter(description = "Identificador de la pelicula a recuperar",example = "5")
            @PathVariable Long codigo){
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
    @PutMapping("{codigo}")
    public ResponseEntity<PeliculaDto> modificarPelicula
        (@PathVariable Long codigo, @RequestBody @Valid ModPeliculaDto modpeliculaDto){
        return ResponseEntity.ok(this.peliculaService.modficarPelicula(codigo,modpeliculaDto));
    }
    //eliminar pelicula
    @DeleteMapping("{codigo}")
    public ResponseEntity<PeliculaDto> eliminarPelicula(@PathVariable Long codigo){
        this.peliculaService.eliminarPelicula(codigo);
        return ResponseEntity.ok().build();
    }
    //exception - peliculaNoExiste - PeliculaYaExiste

    //Consulta a la IA

    //Validaciones (dependencias)

    //Documentación (dependencias)

    }

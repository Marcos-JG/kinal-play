package org.algorix.kinal_play.web.mapper;

import org.algorix.kinal_play.dominio.Genre;
import org.mapstruct.Named;

public class GenreMapper {
    @Named("generarGenre")
    public static Genre generarGenre(String genero){
        if (genero == null) return null;
        return switch (genero.toUpperCase()){
            case "ACCION" -> Genre.ACTION;
            case "ANIMADA" -> Genre.ANIMATE;
            case "CIENCIA_FICCION" -> Genre.SCI_FY;
            case "CRIMEN" -> Genre.CRIME;
            case "DRAMA" -> Genre.DRAMA;
            case "DRAMA_BELICO" -> Genre.BELIC_DRAMA;
            case "FANTASIA" -> Genre.FANTASY;
            case "SUSPENSO" -> Genre.SUSPENSE;
            case "TERROR" -> Genre.HORROR;
            default -> null;
        };
    }
    @Named("generarGenero")
    public static String generarGenero(Genre genre){
        if (genre == null) return null;
        return switch (genre){
            case ACTION -> "ACCION";
            case ANIMATE -> "ANIMADA";
            case SCI_FY -> "CIENCIA_FICCION";
            case CRIME ->  "CRIMEN";
            case DRAMA -> "DRAMA";
            case BELIC_DRAMA -> "DRAMA_BELICO";
            case FANTASY -> "FANTASIA";
            case SUSPENSE -> "SUSPENSO";
            case HORROR -> "TERROR";
            default -> null;
        };
    }
}

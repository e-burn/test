package serverInteraction;

import data.FilmInfo;

import java.io.IOException;

public interface IFilmsServer
{
    boolean searchFilm(String filmTitle) throws IOException;
    FilmInfo getFilmDesc();
}

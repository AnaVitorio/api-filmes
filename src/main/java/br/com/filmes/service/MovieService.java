package br.com.filmes.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.modelmapper.ModelMapper;

import br.com.filmes.dao.MoviesDao;
import br.com.filmes.model.Movies;
import br.com.filmes.model.MoviesDto;

@ApplicationScoped
public class MovieService {
    
    private MoviesDao moviesDao;

    public MovieService(MoviesDao moviesDao){
        this.moviesDao = moviesDao;
    }

    @Produces(MediaType.APPLICATION_JSON)
    public List<Movies> listarFilmes(){
        return moviesDao.listarFilmes();
    }

    @Produces(MediaType.APPLICATION_JSON)
    public MoviesDto adicionarFilmes(MoviesDto filmeDto) {
        Movies filme = toMovies(filmeDto);
        MoviesDto filmeCadastrado = toMoviesDTO(moviesDao.adicionarFilmes(filme));
        return filmeCadastrado;

    }

    @Produces(MediaType.APPLICATION_JSON)
    public Movies buscarFilmePeloNome(String titulo){
        return moviesDao.buscarFilmePeloNome(titulo.toLowerCase());
    }

    public MoviesDto atualizarFilme(MoviesDto filmeAtualizado, Long id) {
        Movies filme = toMovies(filmeAtualizado);
        filmeAtualizado = toMoviesDTO(moviesDao.atualizarFilme(filme, id));
        return filmeAtualizado;
    }

    public Response deletarFilme(Long id) {
        return Response.ok(moviesDao.deletarFilme(id)).build();
    }


    public static MoviesDto toMoviesDTO(Movies filme) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(filme, MoviesDto.class);
    }

    public static Movies toMovies(MoviesDto moviesDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(moviesDto, Movies.class);
    }

  


}

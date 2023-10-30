package br.com.filmes.service;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<MoviesDto> listarFilmes(int pag) throws Exception{
        List<Movies> listaFilmes = moviesDao.listarFilmes(pag);
        List<MoviesDto> listaFilmesDto = listaFilmes.stream().map(filme -> toMoviesDTO(filme)).collect(Collectors.toList());
        return listaFilmesDto;
    }

    @Produces(MediaType.APPLICATION_JSON)
    public Response adicionarFilmes(MoviesDto filmeDto) {
        Movies filme = toMovies(filmeDto);
        MoviesDto filmeCadastrado = toMoviesDTO(moviesDao.adicionarFilmes(filme));
        return Response.ok(filmeCadastrado).status(Response.Status.CREATED).build();

    }

    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarFilmePeloNome(String titulo){
        List<Movies> filmes = moviesDao.buscarFilmePeloNome(titulo.toLowerCase());

        if(filmes.size() == 0){
            return Response.noContent().status(Response.Status.NOT_FOUND).build();
        }

        MoviesDto filmeProcurado = toMoviesDTO(filmes.get(0));

        return Response.ok(filmeProcurado).build() ;
    }

    public MoviesDto atualizarFilme(MoviesDto filmeAtualizado, Long id) {
        Movies filme = toMovies(filmeAtualizado);
        filmeAtualizado = toMoviesDTO(moviesDao.atualizarFilme(filme, id));
        return filmeAtualizado;
    }

    public Response deletarFilme(Long id) {
        if(Movies.findById(id).equals(null)){
            return Response.noContent().status(Response.Status.NOT_FOUND).build();
        }
        moviesDao.deletarFilme(id);
        return Response.ok().status(Response.Status.ACCEPTED).build();
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

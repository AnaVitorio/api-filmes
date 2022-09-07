package br.com.filmes.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import br.com.filmes.model.Movies;

@ApplicationScoped
public class MoviesDao {

    public List<Movies> listarFilmes(){
        List<Movies> listaFilmes = Movies.findAll().list();
        return listaFilmes;
    }

    @Transactional
    public List<Movies> adicionarFilmes(List<Movies> filmes) {
        return null;
    }

    public Movies buscarFilmePeloNome(String titulo) {
        List<Movies> filmes = Movies.findAll().list();
        return filmes.stream()
                     .filter(filme -> filme.getTitulo()
                                            .toLowerCase()
                                            .equals(titulo)).findFirst().get();
    }
}

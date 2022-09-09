package br.com.filmes.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import br.com.filmes.model.Movies;

@ApplicationScoped
public class MoviesDao {

    public List<Movies> listarFilmes(){
        List<Movies> listaFilmes = Movies.findAll().list();
        return listaFilmes;
    }

    @Transactional
    public Movies adicionarFilmes(Movies filme) {
        Movies.persist(filme);
        return filme;
    }

    public Movies buscarFilmePeloNome(String titulo) {
        List<Movies> filmes = Movies.findAll().list();
        return filmes.stream()
                     .filter(filme -> filme.getTitulo()
                                            .toLowerCase()
                                            .equals(titulo)).findFirst().get();
    }

    @Transactional
    public Movies atualizarFilme(Movies filmeAtualizado, Long id) {
        Movies filme = Movies.findById(id);
        filme.setTitulo(filmeAtualizado.getTitulo());
        filme.setDiretor(filmeAtualizado.getDiretor());
        filme.setGenero(filmeAtualizado.getGenero());
        filme.setLancamento(filmeAtualizado.getLancamento());
        return filmeAtualizado;
    }

    @Transactional
    public Response deletarFilme(Long id) {
        Movies.deleteById(id);
        return Response.ok().status(Response.Status.OK).build();
    }
}

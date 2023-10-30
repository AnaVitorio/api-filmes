package br.com.filmes.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import javax.transaction.Transactional;
import br.com.filmes.model.Movies;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Page;

@ApplicationScoped
public class MoviesDao {

    @Inject
    EntityManager em;

    public List<Movies> listarFilmes(int pag) throws Exception{
        
        PanacheQuery<Movies> filmes = Movies.findAll();

        filmes.page(Page.ofSize(5));
        // List<Movies> firstPage = filmes.list();
        pag= pag - 1;
    
        if((pag < 0)){ 
            throw new Exception("Página não encontrada");
        }
        List<Movies> page = filmes.page(Page.of(pag, 5)).list();
         
        return page;
    }

    @Transactional
    public Movies adicionarFilmes(Movies filme) {
        Movies.persist(filme);
        return filme;
    }

    public List<Movies> buscarFilmePeloNome(String titulo) {
        List<Movies> filmes = Movies.findAll().list();

        List<Movies> filmesEncontrados = filmes.stream()
                                                .filter(filme -> filme.getTitulo()
                                                                        .toLowerCase()
                                                                        .equals(titulo))
                                                                        .collect(Collectors.toList());
                                                                        
        return filmesEncontrados;
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
    public void deletarFilme(Long id) {
        Movies.deleteById(id);
      
    }

    public List<Movies> listarTodosFilmes() {
         List<Movies> filmes = Movies.findAll().list();
        return filmes;
    }
}

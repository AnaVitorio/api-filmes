package br.com.filmes.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


import br.com.filmes.dao.MoviesDao;
import br.com.filmes.model.Movies;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {


    @BeforeEach
    void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testBuscarFilmePeloNome() {
       
        MoviesDao moviesDao = Mockito.mock(MoviesDao.class);
        MovieService movieService = Mockito.mock(MovieService.class);

        List<Movies> listaFilmes = new ArrayList<>();

        Movies filme = new Movies();
        filme.setDiretor("teste");
        filme.setGenero("null");
        filme.setId(1L);
        filme.setLancamento("12/02/2000");
        filme.setTitulo("null");

        listaFilmes.add(filme);

        // Mockito.when(moviesDao.buscarFilmePeloNome(Mockito.anyString())).thenReturn(listaFilmes);

        assertDoesNotThrow(() -> movieService.buscarFilmePeloNome("null"));        

    }
}

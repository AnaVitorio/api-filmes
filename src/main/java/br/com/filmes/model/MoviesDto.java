package br.com.filmes.model;

public class MoviesDto {

    private String titulo;
    private String diretor;
    private String genero;
    private String lancamento;
    
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDiretor() {
        return diretor;
    }
    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getLancamento() {
        return lancamento;
    }
    public void setLancamento(String lancamento) {
        this.lancamento = lancamento;
    }

    
    
}

package br.com.filmes.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movies {
    
    @Id
    private int id;

    private String titulo;
    private String diretor;
    private String genero;
    private String lancamento;

    public int getId(){
        return this.id;
    };

    public void setId(int id){
        this.id = id;
    };

    public String getTitulo(){
        return this.titulo;
    };

    public void setTitulo(String titulo){
        this.titulo = titulo;
    };

    public String getDiretor(){
        return this.diretor;
    };

    public void setDiretor(String diretor){
        this.diretor = diretor;
    };

    public String getGenero(){
        return genero;
    };

    public void setGenero(String genero){
        this.genero = genero;
    };

    public String getLancamento(){
        return lancamento;
    };

    public void setLancamento(String lancamento){
        this.lancamento = lancamento;
    };


    
}

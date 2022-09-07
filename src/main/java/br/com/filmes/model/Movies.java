package br.com.filmes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Movies extends PanacheEntityBase{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String titulo;
    private String diretor;
    private String genero;
    private String lancamento;

    public Long getId(){
        return this.id;
    };

    public void setId(Long id){
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

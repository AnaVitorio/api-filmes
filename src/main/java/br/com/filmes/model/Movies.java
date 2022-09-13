package br.com.filmes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;


@Entity
public class Movies extends PanacheEntityBase{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Título não pode estar vazio")
    @NotNull(message = "Título não pode ser nulo")
    private String titulo;

    @NotEmpty(message = "Diretor não pode estar vazio")
    @NotNull(message = "Diretor não pode ser nulo")
    private String diretor;

    @NotEmpty(message = "Gênero não pode estar vazio")
    @NotNull(message = "Gênero não pode ser nulo")
    private String genero;

    @NotEmpty(message = "Lançamento não pode estar vazio")
    @NotNull(message = "Lançamento não pode ser nulo")
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

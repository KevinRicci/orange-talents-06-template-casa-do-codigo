package br.com.zupacademy.kevin.casadocodigo.categoria;

import br.com.zupacademy.kevin.casadocodigo.validacao.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public CategoriaRequest(String nome) {
        this.nome = nome;
    }

    @Deprecated
    public CategoriaRequest(){

    }

    public Categoria toModel(){
        return new Categoria(this.nome);
    }

    public String getNome(){
        return this.nome;
    }
}

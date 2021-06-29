package br.com.zupacademy.kevin.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank
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

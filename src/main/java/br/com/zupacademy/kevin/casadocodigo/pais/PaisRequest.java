package br.com.zupacademy.kevin.casadocodigo.pais;

import br.com.zupacademy.kevin.casadocodigo.validacao.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;

public class PaisRequest {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public PaisRequest(String nome) {
        this.nome = nome;
    }

    @Deprecated
    public PaisRequest() {
    }

    public String getNome() {
        return nome;
    }


    public Pais toModel(){
        return new Pais(this.nome);
    }
}

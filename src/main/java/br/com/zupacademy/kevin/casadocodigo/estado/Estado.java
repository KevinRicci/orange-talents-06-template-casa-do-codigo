package br.com.zupacademy.kevin.casadocodigo.estado;

import br.com.zupacademy.kevin.casadocodigo.pais.Pais;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Estado {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @ManyToOne(optional = false)
    private Pais pais;

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    @Deprecated
    public Estado(){

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }
}

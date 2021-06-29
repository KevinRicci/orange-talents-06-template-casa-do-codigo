package br.com.zupacademy.kevin.casadocodigo.categoria;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column(nullable = false)
    private String nome;

    public Categoria(String nome) {
        this.nome = nome;
    }

    public Categoria(){
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}

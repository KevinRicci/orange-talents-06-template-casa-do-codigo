package br.com.zupacademy.kevin.casadocodigo.categoria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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

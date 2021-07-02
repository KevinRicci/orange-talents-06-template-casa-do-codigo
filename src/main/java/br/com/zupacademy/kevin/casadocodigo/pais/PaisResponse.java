package br.com.zupacademy.kevin.casadocodigo.pais;

import br.com.zupacademy.kevin.casadocodigo.estado.EstadoResponse;

import java.util.ArrayList;
import java.util.List;

public class PaisResponse {

    private Long id;
    private String nome;
    List<EstadoResponse> estados = new ArrayList<>();

    public  PaisResponse(Pais pais){
        this.id = pais.getId();
        this.nome = pais.getNome();
        pais.getEstados().forEach(e ->{
            estados.add(new EstadoResponse(e));
        });
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<EstadoResponse> getEstados() {
        return estados;
    }
}

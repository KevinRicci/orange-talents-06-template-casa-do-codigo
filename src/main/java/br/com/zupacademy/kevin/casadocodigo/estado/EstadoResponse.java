package br.com.zupacademy.kevin.casadocodigo.estado;

public class EstadoResponse {

    private Long id;
    private String nome;

    public EstadoResponse(Estado estado){
        this.id = estado.getId();
        this.nome = estado.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}

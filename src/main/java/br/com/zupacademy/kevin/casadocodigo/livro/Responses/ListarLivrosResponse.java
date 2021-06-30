package br.com.zupacademy.kevin.casadocodigo.livro.Responses;

import br.com.zupacademy.kevin.casadocodigo.livro.Livro;

public class ListarLivrosResponse {

    private Long id;
    private String titulo;

    public ListarLivrosResponse(Livro livro){
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}

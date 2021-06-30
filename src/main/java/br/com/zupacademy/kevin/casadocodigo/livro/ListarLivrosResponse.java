package br.com.zupacademy.kevin.casadocodigo.livro;

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

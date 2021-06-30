package br.com.zupacademy.kevin.casadocodigo.livro;

import br.com.zupacademy.kevin.casadocodigo.autor.Autor;
import br.com.zupacademy.kevin.casadocodigo.categoria.Categoria;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank
    private String titulo;

    @Column(nullable = false, length = 500)
    @NotBlank
    @Size(max = 500)
    private String resumo;

    @Column(length = 9999)
    @NotBlank
    private String sumario;

    @Column(nullable = false)
    @NotNull
    @Min(20)
    private BigDecimal preco;

    @Column(nullable = false)
    @NotNull
    @Min(100)
    private int numeroPaginas;

    @Column(nullable = false, unique = true)
    @NotBlank
    private String isbn;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dataPublicacao;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Autor autor;

    public Livro(String titulo, String resumo, String sumario, BigDecimal preco, int numeroPaginas, String isbn, LocalDate dataPublicacao, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    @Deprecated
    public Livro(){
    }
}

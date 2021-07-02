package br.com.zupacademy.kevin.casadocodigo.livro;

import br.com.zupacademy.kevin.casadocodigo.autor.Autor;
import br.com.zupacademy.kevin.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.kevin.casadocodigo.categoria.Categoria;
import br.com.zupacademy.kevin.casadocodigo.categoria.CategoriaRepository;
import br.com.zupacademy.kevin.casadocodigo.validacao.ExistsId;
import br.com.zupacademy.kevin.casadocodigo.validacao.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.core.MethodParameter;
import org.springframework.data.repository.query.Parameter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.servlet.tags.Param;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class LivroRequest {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    @NotBlank
    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private int numeroPaginas;

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @Future
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPublicacao;

    @NotNull
    @ExistsId(domainClass = Categoria.class)
    private Long idCategoria;

    @NotNull
    @ExistsId(domainClass = Autor.class)
    private Long idAutor;

    @JsonCreator
    public LivroRequest(String titulo, String resumo, String sumario, BigDecimal preco, int numeroPaginas, String isbn, LocalDate dataPublicacao, Long idCategoria, Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    public Livro toModel(CategoriaRepository categoriaRepository, AutorRepository autorRepository){
        Optional<Categoria> categoria = categoriaRepository.findById(this.idCategoria);
        Optional<Autor> autor = autorRepository.findById(this.idAutor);

        return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.numeroPaginas, this.isbn, this.dataPublicacao, categoria.get(), autor.get());
    }
}

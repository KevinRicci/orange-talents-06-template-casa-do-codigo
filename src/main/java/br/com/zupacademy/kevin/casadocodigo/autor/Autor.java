package br.com.zupacademy.kevin.casadocodigo.autor;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    @Column(nullable = false)
    private String nome;
    @Email
    @Column(nullable = false)
    private String email;
    @NotBlank @Size(max = 400)
    @Column(nullable = false)
    private String descricao;
    private LocalDateTime instanteCadastro = LocalDateTime.now();

    public Autor(@NotBlank String nome, @Email String email,
                 @NotBlank @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    @Deprecated
    public Autor(){
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getInstanteCadastro() {
        return instanteCadastro;
    }
}

package br.com.zupacademy.kevin.casadocodigo.autor;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private String nome;
    @Email
    private String email;
    @NotBlank @Size(max = 400)
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
}

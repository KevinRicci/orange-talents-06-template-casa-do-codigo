package br.com.zupacademy.kevin.casadocodigo.estado;

import br.com.zupacademy.kevin.casadocodigo.pais.Pais;
import br.com.zupacademy.kevin.casadocodigo.pais.PaisRepository;
import br.com.zupacademy.kevin.casadocodigo.validacao.ExistsId;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class EstadoRequest {

    @NotBlank
    private String nome;
    @NotNull
    @ExistsId(domainClass = Pais.class)
    private long idPais;

    public EstadoRequest(String nome, long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    @Deprecated
    public EstadoRequest(){
    }

    public String getNome() {
        return nome;
    }

    public long getIdPais() {
        return idPais;
    }

    public Optional<Estado> toModel(PaisRepository paisRepository, EstadoRepository estadoRepository){
        Optional<Pais> pais = paisRepository.findById(this.idPais);
        Optional<Estado> estadoComNomeRepetido = estadoRepository.findByNomeAndPais_Id(this.nome, this.idPais);

        if(estadoComNomeRepetido.isEmpty()){
            return Optional.of(new Estado(this.nome, pais.get()));
        }else{
            return Optional.empty();
        }
    }
}

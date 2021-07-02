package br.com.zupacademy.kevin.casadocodigo.cliente;

import br.com.zupacademy.kevin.casadocodigo.cliente.validacao.ClienteRestricoes;
import br.com.zupacademy.kevin.casadocodigo.cliente.validacao.CpfCnpj;
import br.com.zupacademy.kevin.casadocodigo.estado.Estado;
import br.com.zupacademy.kevin.casadocodigo.estado.EstadoRepository;
import br.com.zupacademy.kevin.casadocodigo.pais.Pais;
import br.com.zupacademy.kevin.casadocodigo.pais.PaisRepository;
import br.com.zupacademy.kevin.casadocodigo.validacao.ExistsId;
import br.com.zupacademy.kevin.casadocodigo.validacao.UniqueValue;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@ClienteRestricoes(idPais = "idPais", idEstado = "idEstado")
public class ClienteRequest {

    @NotBlank @Email
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank @UniqueValue(domainClass = Cliente.class, fieldName = "documento") @CpfCnpj
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    private Long idPais;
    private Long idEstado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public Cliente toModel(PaisRepository paisRepository, EstadoRepository estadoRepository){
        Pais pais = paisRepository.getById(this.idPais);

        Estado estado = null;
        if(idEstado != null){
            estado = estadoRepository.getById(this.idEstado);
        }

        return new Cliente(this.email, this.nome, this.sobrenome, this.documento, this.endereco, this.complemento, this.cidade, pais, estado, this.telefone, this.cep);
    }
}

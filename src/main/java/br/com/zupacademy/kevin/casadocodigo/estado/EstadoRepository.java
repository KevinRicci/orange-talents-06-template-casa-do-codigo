package br.com.zupacademy.kevin.casadocodigo.estado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    public Optional<Estado> findByNomeAndPais_Id(String nome, Long idPais);
}

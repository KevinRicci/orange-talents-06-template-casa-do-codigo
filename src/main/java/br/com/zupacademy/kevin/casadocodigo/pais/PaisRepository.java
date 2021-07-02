package br.com.zupacademy.kevin.casadocodigo.pais;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {

    public Optional<Pais> findByEstados_Id(Long id);
}

package br.com.zupacademy.kevin.casadocodigo.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> criar(@RequestBody @Valid CategoriaRequest categoriaRequest){
        Categoria categoria = categoriaRequest.toModel();
        categoriaRepository.save(categoria);
        return ResponseEntity.ok().build();
    }
}

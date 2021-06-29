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

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private CategoriaValidator categoriaValidator;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(categoriaValidator);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> criar(@RequestBody @Valid CategoriaRequest categoriaRequest){
        Categoria categoria = categoriaRequest.toModel();
        entityManager.persist(categoria);
        return ResponseEntity.ok().build();
    }
}

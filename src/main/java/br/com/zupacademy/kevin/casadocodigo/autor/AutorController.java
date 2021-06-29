package br.com.zupacademy.kevin.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(proibeEmailDuplicadoAutorValidator);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> criar(@Valid @RequestBody AutorRequest autorRequest){
        Autor autor = autorRequest.toModel();
        entityManager.persist(autor);
        return ResponseEntity.ok().build();
    }
}

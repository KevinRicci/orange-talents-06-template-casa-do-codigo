package br.com.zupacademy.kevin.casadocodigo.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class CategoriaValidator implements Validator {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return CategoriaRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object request, Errors errors) {
        this.proibeNomeDuplicado(request,  errors);
    }

    public void proibeNomeDuplicado(Object request, Errors errors){
        CategoriaRequest categoriaRequest = (CategoriaRequest) request;
        Optional<Categoria> possivelCategoria = categoriaRepository.findByNome(categoriaRequest
                .getNome());

        if(possivelCategoria.isPresent()){
            errors.rejectValue("nome", null, "Nome de categoria já cadastrado");
        }
    }
}

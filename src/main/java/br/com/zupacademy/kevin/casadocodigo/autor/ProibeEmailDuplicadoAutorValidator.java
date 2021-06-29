package br.com.zupacademy.kevin.casadocodigo.autor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    //verifica se o parâmetro é um AutorRequest ou uma superclasse
    @Override
    public boolean supports(Class<?> aClass) {
        return AutorRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object request, Errors errors) {
        if(errors.hasErrors()){
            return;
        }
        AutorRequest autorRequest = (AutorRequest) request;
        Optional<Autor> possivelAutor = autorRepository.findByEmail(autorRequest.getEmail());

        if(possivelAutor.isPresent()){
            errors.rejectValue("email", null, "Já existe um email igual cadastrado: "
                + autorRequest.getEmail());
        }
    }
}

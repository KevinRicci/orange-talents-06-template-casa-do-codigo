package br.com.zupacademy.kevin.casadocodigo.pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar( @RequestBody @Valid PaisRequest paisRequest){
        Pais pais = paisRequest.toModel();
        paisRepository.save(pais);
        return ResponseEntity.ok().build();
    }
}

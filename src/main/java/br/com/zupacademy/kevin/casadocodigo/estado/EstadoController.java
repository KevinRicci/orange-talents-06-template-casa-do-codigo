package br.com.zupacademy.kevin.casadocodigo.estado;

import br.com.zupacademy.kevin.casadocodigo.pais.Pais;
import br.com.zupacademy.kevin.casadocodigo.pais.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid EstadoRequest estadoRequest){
        Optional<Estado> estado = estadoRequest.toModel(paisRepository, estadoRepository);
        if(estado.isPresent()) {
            estadoRepository.save(estado.get());
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().body("País com estado já cadastrado");
        }
    }
}

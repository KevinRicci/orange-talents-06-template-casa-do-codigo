package br.com.zupacademy.kevin.casadocodigo.cliente;

import br.com.zupacademy.kevin.casadocodigo.estado.Estado;
import br.com.zupacademy.kevin.casadocodigo.estado.EstadoRepository;
import br.com.zupacademy.kevin.casadocodigo.pais.Pais;
import br.com.zupacademy.kevin.casadocodigo.pais.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PaisRepository paisRepository;
    @Autowired
    private EstadoRepository estadoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> criar(@RequestBody @Valid ClienteRequest clienteRequest){
        Cliente cliente = clienteRequest.toModel(paisRepository, estadoRepository);
        clienteRepository.save(cliente);
        return ResponseEntity.ok().build();
    }
}

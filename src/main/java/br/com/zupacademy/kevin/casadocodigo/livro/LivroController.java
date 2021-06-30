package br.com.zupacademy.kevin.casadocodigo.livro;

import br.com.zupacademy.kevin.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.kevin.casadocodigo.categoria.CategoriaRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> criar(@RequestBody @Valid LivroRequest livroRequest){
        Livro livro = livroRequest.toModel(categoriaRepository, autorRepository);
        livroRepository.save(livro);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @Transactional
    public ResponseEntity<List<ListarLivrosResponse>> listar(){
        List<Livro> livros = livroRepository.findAll();
        List<ListarLivrosResponse> livrosResponse = new ArrayList<>();
        livros.forEach(livro ->{
            livrosResponse.add(new ListarLivrosResponse(livro));
        });

        return ResponseEntity.ok().body(livrosResponse);
    }
}

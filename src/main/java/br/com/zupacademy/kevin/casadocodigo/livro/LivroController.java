package br.com.zupacademy.kevin.casadocodigo.livro;

import br.com.zupacademy.kevin.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.kevin.casadocodigo.categoria.CategoriaRepository;
import br.com.zupacademy.kevin.casadocodigo.livro.Responses.DetalhesLivroResponse;
import br.com.zupacademy.kevin.casadocodigo.livro.Responses.ListarLivrosResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DetalhesLivroResponse> detalhes(@PathVariable Long id){
        Optional<Livro> livro = livroRepository.findById(id);
        if(livro.isPresent()){
            return ResponseEntity.ok().body(new DetalhesLivroResponse(livro.get()));
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}

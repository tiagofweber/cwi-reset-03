package br.com.cwi.reset.tiagofweber.controller;

import br.com.cwi.reset.tiagofweber.model.Filme;
import br.com.cwi.reset.tiagofweber.request.FilmeRequest;
import br.com.cwi.reset.tiagofweber.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarFilme(@RequestBody @Valid FilmeRequest filmeRequest) throws Exception {
        filmeService.criarFilme(filmeRequest);
    }

    @GetMapping
    public List<Filme> consultarFilmes(
            @RequestParam("nome-filme") String nomeFilme,
            @RequestParam("nome-diretor") String nomeDiretor,
            @RequestParam("nome-personagem") String nomePersonagem,
            @RequestParam("nome-ator") String nomeAtor
    ) throws Exception {
        return filmeService.consultarFilmes(nomeFilme, nomeDiretor, nomePersonagem, nomeAtor);
    }

    @DeleteMapping("/{id}")
    public void removerFilme(@PathVariable Integer id) throws Exception {
        filmeService.removerFilme(id);
    }
}

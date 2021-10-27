package br.com.cwi.reset.tiagofweber.controller;

import br.com.cwi.reset.tiagofweber.model.Ator;
import br.com.cwi.reset.tiagofweber.request.AtorRequest;
import br.com.cwi.reset.tiagofweber.response.AtorEmAtividade;
import br.com.cwi.reset.tiagofweber.service.AtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/atores")
public class AtorController {

    @Autowired
    private AtorService atorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAtor(@RequestBody @Valid AtorRequest atorRequest) throws Exception {
        this.atorService.criarAtor(atorRequest);
    }

    @GetMapping("/em-atividade")
    public List<AtorEmAtividade> listarAtoresEmAtividade(@RequestParam("filtro-nome") String filtroNome) throws Exception {
        return atorService.listarAtoresEmAtividade(filtroNome);
    }

    @GetMapping("/{id}")
    public Ator consultarAtor(@PathVariable Integer id) throws Exception {
        return atorService.consultarAtor(id);
    }

    @GetMapping
    public List<Ator> consultarAtores() throws Exception {
        return atorService.consultarAtores();
    }

    @PutMapping("/{id}")
    public void atualizarAtor(@PathVariable Integer id, @RequestBody @Valid AtorRequest atorRequest) throws Exception {
        atorService.atualizarAtor(id, atorRequest);
    }
}

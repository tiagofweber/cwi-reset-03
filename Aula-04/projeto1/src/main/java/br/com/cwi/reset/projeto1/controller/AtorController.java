package br.com.cwi.reset.projeto1.controller;

import br.com.cwi.reset.projeto1.domain.Ator;
import br.com.cwi.reset.projeto1.service.AtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ator")
public class AtorController {

    @Autowired
    private AtorService service;

    @PostMapping
    public Ator salvar(@RequestBody Ator ator) {
        return service.salvar(ator);
    }

    @GetMapping
    public List<Ator> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{nome}")
    public Ator buscarPorNome(@PathVariable String nome) {
        return service.procurarPorNome(nome);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        service.deletar(id);
    }

    @GetMapping("/by-filter")
    public List<Ator> buscarPorFiltro(@RequestParam Integer numeroOscars, Integer anoNascimento) {
        return service.buscarPorFiltro(numeroOscars, anoNascimento);
    }
}

package br.com.cwi.reset.tiagofweber.controller;

import br.com.cwi.reset.tiagofweber.model.Diretor;
import br.com.cwi.reset.tiagofweber.request.DiretorRequest;
import br.com.cwi.reset.tiagofweber.service.DiretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/diretores")
public class DiretorController {

    @Autowired
    private DiretorService diretorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarDiretor(@RequestBody @Valid DiretorRequest diretorRequest) throws Exception {
        diretorService.cadastrarDiretor(diretorRequest);
    }

    @GetMapping
    public List<Diretor> listarDiretores(@RequestParam("filtro-nome") String filtroNome) throws Exception {
        return diretorService.listarDiretores(filtroNome);
    }

    @GetMapping("/{id}")
    public Diretor consultarDiretor(@PathVariable Integer id) throws Exception {
        return diretorService.consultarDiretor(id);
    }

    @PutMapping("/{id}")
    public void atualizarDiretor(
            @PathVariable Integer id,
            @RequestBody @Valid DiretorRequest diretorRequest
    ) throws Exception {
        diretorService.atualizarDiretor(id, diretorRequest);
    }

    @DeleteMapping("/{id}")
    public void removerDiretores(@PathVariable Integer id) throws Exception {
        diretorService.removerDiretores(id);
    }
}

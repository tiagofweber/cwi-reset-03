package br.com.cwi.reset.tiagofweber.controller;

import br.com.cwi.reset.tiagofweber.FakeDatabase;
import br.com.cwi.reset.tiagofweber.model.Diretor;
import br.com.cwi.reset.tiagofweber.request.DiretorRequest;
import br.com.cwi.reset.tiagofweber.service.DiretorService;
import ch.qos.logback.core.encoder.EchoEncoder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diretores")
public class DiretorController {

    private DiretorService diretorService;

    public DiretorController() {
        this.diretorService = new DiretorService(FakeDatabase.getInstance());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarDiretor(@RequestBody DiretorRequest diretorRequest) throws Exception {
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
}

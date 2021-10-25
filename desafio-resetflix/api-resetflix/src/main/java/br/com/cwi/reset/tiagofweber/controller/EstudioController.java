package br.com.cwi.reset.tiagofweber.controller;

import br.com.cwi.reset.tiagofweber.FakeDatabase;
import br.com.cwi.reset.tiagofweber.model.Estudio;
import br.com.cwi.reset.tiagofweber.request.EstudioRequest;
import br.com.cwi.reset.tiagofweber.service.EstudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("estudios")
public class EstudioController {

    @Autowired
    private EstudioService estudioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarEstudio(@RequestBody EstudioRequest estudioRequest) throws Exception {
        estudioService.criarEstudio(estudioRequest);
    }

    @GetMapping
    public List<Estudio> consultarEstudios(@RequestParam("filtro-nome") String filtroNome) throws Exception {
        return estudioService.consultarEstudios(filtroNome);
    }

    @GetMapping("/{id}")
    public Estudio consultarEstudio(@PathVariable Integer id) throws Exception {
        return estudioService.consultarEstudio(id);
    }
}

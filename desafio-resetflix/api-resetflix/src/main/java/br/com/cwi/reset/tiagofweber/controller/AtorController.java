package br.com.cwi.reset.tiagofweber.controller;

import br.com.cwi.reset.tiagofweber.request.AtorRequest;
import br.com.cwi.reset.tiagofweber.service.AtorService;
import br.com.cwi.reset.tiagofweber.FakeDatabase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/atores")
public class AtorController {

    private AtorService atorService;

    public AtorController() {
        this.atorService = new AtorService(FakeDatabase.getInstance());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAtor(@RequestBody AtorRequest atorRequest) throws Exception {
        this.atorService.criarAtor(atorRequest);
    }
}

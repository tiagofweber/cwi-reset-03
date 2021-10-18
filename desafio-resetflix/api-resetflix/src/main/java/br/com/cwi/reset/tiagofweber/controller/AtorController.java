package br.com.cwi.reset.tiagofweber.controller;

import br.com.cwi.reset.tiagofweber.service.AtorService;
import br.com.cwi.reset.tiagofweber.FakeDatabase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/atores")
public class AtorController {

    private AtorService atorService;

    public AtorController() {
        this.atorService = new AtorService(FakeDatabase.getInstance());
    }

    //demais métodos
}

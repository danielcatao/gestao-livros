package br.com.fecaf.gestao_livros.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class ApiController {

    @GetMapping
    public String helloWorld() {
        return "Hello World";
    }
}

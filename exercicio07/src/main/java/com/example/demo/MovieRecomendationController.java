package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@GetMapping("/exercicio")
public class MovieRecomendationController {
    @GetMapping("/recomendar")
    public String recomendarFilme(
            @RequestParam String genero,
            @RequestParam String ambientacao) {
        if ((!genero.equalsIgnoreCase("comedia") && !genero.equalsIgnoreCase("drama")) ||
                (!ambientacao.equalsIgnoreCase("sci-fi") && !ambientacao.equalsIgnoreCase("medieval"))) {
            return "Opção inválida. O programa será encerrado.";
        }
        if (genero.equalsIgnoreCase("comedia") && ambientacao.equalsIgnoreCase("sci-fi")) {
            return "Recomendação: Homens de Preto";
        } else if (genero.equalsIgnoreCase("drama") && ambientacao.equalsIgnoreCase("sci-fi")) {
            return "Recomendação: Arrival";
        } else if (genero.equalsIgnoreCase("comedia") && ambientacao.equalsIgnoreCase("medieval")) {
            return "Recomendação: Shrek";
        } else if (genero.equalsIgnoreCase("drama") && ambientacao.equalsIgnoreCase("medieval")) {
            return "Recomendação: Gladiador";
        } else {
            return "Nenhuma recomendação disponível para essas opções.";
        }
    }
}

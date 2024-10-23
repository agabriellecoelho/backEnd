package com.exercicio.musica.controllers;

import com.exercicio.musica.models.ApiResponse;
import com.exercicio.musica.models.Artista;
import com.exercicio.musica.services.artista.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artistas")
public class ArtistaController {

    private final ArtistaService artistaService;

    @Autowired
    public ArtistaController(ArtistaService artistaService) {
        this.artistaService = artistaService;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createArtista(@RequestBody Artista artista) {
        return artistaService.createArtista(artista.getNome());
    }

    @GetMapping("/view")
    public ResponseEntity<List<Artista>> viewAllArtistas() {
        return artistaService.viewAllArtistas();
    }

    @GetMapping("/view/{nome}")
    public ResponseEntity<Artista> viewArtistaByName(@PathVariable String nome) {
        return artistaService.viewArtistaByName(nome);
    }

    @PatchMapping("/update")
    public ResponseEntity<ApiResponse> updateArtista(@RequestParam String antigoNome, @RequestParam String novoNome) {
        return artistaService.updateArtista(antigoNome, novoNome);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse> deleteArtista(@RequestParam String nome) {
        return artistaService.deleteArtista(nome);
    }
}

package com.exercicio.musica.controllers;

import com.exercicio.musica.models.ApiResponse;
import com.exercicio.musica.models.Artista;
import com.exercicio.musica.models.Musica;
import com.exercicio.musica.models.UpdateMusica;
import com.exercicio.musica.services.musica.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/musicas")
public class MusicaController {
    private final MusicaService musicaService;

    @Autowired
    public MusicaController(MusicaService musicaService) {
        this.musicaService = musicaService;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createMusic(@RequestBody Musica musica, @RequestParam String artistaNome) {
        return musicaService.createMusic(musica.getNome(), musica.getDuracao(), artistaNome);
    }

    @GetMapping("/view")
    public ResponseEntity<ApiResponse> viewMusics() {
        return musicaService.viewMusics();
    }

    @PatchMapping("/update")
    public ResponseEntity<ApiResponse> updateMusic(@RequestBody UpdateMusica updateMusica) {
        return musicaService.updateMusic(updateMusica.getAntigoNome(), updateMusica.getNovoNome());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse> deleteMusic(@RequestParam String nomeMusica, @RequestParam String nomeArtista) {
        return musicaService.deleteMusic(nomeMusica, nomeArtista);
    }
}

package com.exercicio.musica.services.musica;

import com.exercicio.musica.models.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface MusicaService {
    ResponseEntity<ApiResponse> createMusic(String nome, String duracao, String artistaNome);
    ResponseEntity<ApiResponse> viewMusics();
    ResponseEntity<ApiResponse> updateMusic(String antigoNome, String novoNome);
    ResponseEntity<ApiResponse> deleteMusic(String nomeMusica, String nomeArtista);
}

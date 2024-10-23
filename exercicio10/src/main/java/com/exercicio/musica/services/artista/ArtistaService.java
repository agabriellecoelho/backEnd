package com.exercicio.musica.services.artista;

import com.exercicio.musica.models.ApiResponse;
import com.exercicio.musica.models.Artista;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ArtistaService {
    ResponseEntity<ApiResponse> createArtista(String nome);
    ResponseEntity<List<Artista>> viewAllArtistas();
    ResponseEntity<Artista> viewArtistaByName(String nome);
    ResponseEntity<ApiResponse> updateArtista(String antigoNome, String novoNome);
    ResponseEntity<ApiResponse> deleteArtista(String nome);
    List<Artista> getAllArtistas();
}

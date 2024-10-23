package com.exercicio.musica.services.artista;

import com.exercicio.musica.models.ApiResponse;
import com.exercicio.musica.models.Artista;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtistaServiceImpl implements ArtistaService {

    private final List<Artista> artistas = new ArrayList<>();

    @Override
    public ResponseEntity<ApiResponse> createArtista(String nome) {
        for (Artista artista : artistas) {
            if (artista.getNome().equalsIgnoreCase(nome)) {
                return new ResponseEntity<>(new ApiResponse("Artista já existe!", false), HttpStatus.CONFLICT);
            }
        }

        Artista novoArtista = new Artista();
        novoArtista.setNome(nome);
        artistas.add(novoArtista);

        return new ResponseEntity<>(new ApiResponse("Artista criado com sucesso!", true), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Artista>> viewAllArtistas() {
        if (artistas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(artistas, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Artista> viewArtistaByName(String nome) {
        for (Artista artista : artistas) {
            if (artista.getNome().equalsIgnoreCase(nome)) {
                return new ResponseEntity<>(artista, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<ApiResponse> updateArtista(String antigoNome, String novoNome) {
        for (Artista artista : artistas) {
            if (artista.getNome().equalsIgnoreCase(antigoNome)) {
                artista.setNome(novoNome);
                return new ResponseEntity<>(new ApiResponse("Artista atualizado com sucesso!", true), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(new ApiResponse("Artista não encontrado.", false), HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<ApiResponse> deleteArtista(String nome) {
        boolean removed = artistas.removeIf(artista -> artista.getNome().equalsIgnoreCase(nome));
        if (!removed) {
            return new ResponseEntity<>(new ApiResponse("Artista não encontrado.", false), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ApiResponse("Artista removido com sucesso!", true), HttpStatus.OK);
    }

    // Novo método para retornar todos os artistas
    @Override
    public List<Artista> getAllArtistas() {
        return new ArrayList<>(artistas);  // Retorna uma cópia da lista de artistas
    }
}

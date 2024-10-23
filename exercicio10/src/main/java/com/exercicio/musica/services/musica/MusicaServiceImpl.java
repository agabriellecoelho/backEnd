package com.exercicio.musica.services.musica;

import com.exercicio.musica.models.ApiResponse;
import com.exercicio.musica.models.Artista;
import com.exercicio.musica.models.Musica;
import com.exercicio.musica.services.artista.ArtistaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicaServiceImpl implements MusicaService {

    private final ArtistaService artistaService;

    public MusicaServiceImpl(ArtistaService artistaService) {
        this.artistaService = artistaService;
    }

    @Override
    public ResponseEntity<ApiResponse> createMusic(String nome, String duracao, String artistaNome) {
        try {
            List<Artista> artistas = artistaService.getAllArtistas();
            Artista artistaEncontrado = artistas.stream()
                    .filter(artista -> artista.getNome().equalsIgnoreCase(artistaNome))
                    .findFirst()
                    .orElse(null);

            if (artistaEncontrado == null) {
                return new ResponseEntity<>(new ApiResponse("Artista não encontrado.", false), HttpStatus.NOT_FOUND);
            }

            Musica novaMusica = new Musica();
            novaMusica.setNome(nome);
            novaMusica.setDuracao(duracao);
            novaMusica.setArtista(artistaEncontrado);

            artistaEncontrado.addMusica(novaMusica);

            return new ResponseEntity<>(new ApiResponse("Música criada com sucesso!", true), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse("Erro ao criar a música.", false), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ApiResponse> viewMusics() {
        try {
            List<Artista> artistas = artistaService.getAllArtistas();
            StringBuilder sb = new StringBuilder("Músicas cadastradas: ");

            artistas.forEach(artista -> {
                artista.getMusicas().forEach(musica -> {
                    sb.append(musica.getNome()).append(" (Artista: ").append(artista.getNome()).append("), ");
                });
            });

            if (sb.length() <= 21) {
                return new ResponseEntity<>(new ApiResponse("Nenhuma música cadastrada.", false), HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(new ApiResponse(sb.substring(0, sb.length() - 2), true), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse("Erro ao visualizar as músicas.", false), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ApiResponse> updateMusic(String antigoNome, String novoNome) {
        try {
            List<Artista> artistas = artistaService.getAllArtistas();
            for (Artista artista : artistas) {
                for (Musica musica : artista.getMusicas()) {
                    if (musica.getNome().equalsIgnoreCase(antigoNome)) {
                        musica.setNome(novoNome);
                        return new ResponseEntity<>(new ApiResponse("Música atualizada com sucesso!", true), HttpStatus.OK);
                    }
                }
            }

            return new ResponseEntity<>(new ApiResponse("Música não encontrada!", false), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse("Erro ao atualizar a música.", false), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ApiResponse> deleteMusic(String nomeMusica, String nomeArtista) {
        try {
            List<Artista> artistas = artistaService.getAllArtistas();
            Artista artistaEncontrado = artistas.stream()
                    .filter(artista -> artista.getNome().equalsIgnoreCase(nomeArtista))
                    .findFirst()
                    .orElse(null);

            if (artistaEncontrado == null) {
                return new ResponseEntity<>(new ApiResponse("Artista não encontrado.", false), HttpStatus.NOT_FOUND);
            }

            boolean musicaRemovida = artistaEncontrado.getMusicas().removeIf(musica -> musica.getNome().equalsIgnoreCase(nomeMusica));

            if (!musicaRemovida) {
                return new ResponseEntity<>(new ApiResponse("Música não encontrada!", false), HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(new ApiResponse("Música removida com sucesso!", true), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse("Erro ao remover a música.", false), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

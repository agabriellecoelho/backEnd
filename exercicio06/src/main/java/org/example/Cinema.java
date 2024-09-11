package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private List<Filme> filmesDisponiveis;
    private List<Ingresso> ingressosVendidos;
    private List<String> assentosDisponiveis;

    public Cinema() {
        this.filmesDisponiveis = new ArrayList<>();
        this.ingressosVendidos = new ArrayList<>();
        this.assentosDisponiveis = new ArrayList<>();


        for (char row = 'A'; row <= 'F'; row++) {
            for (int col = 1; col <= 5; col++) {
                assentosDisponiveis.add(row + String.valueOf(col));
            }
        }
    }

    public void adicionarFilme(Filme filme) {
        filmesDisponiveis.add(filme);
    }

    public Filme buscarFilme(String nome) {
        for (Filme filme : filmesDisponiveis) {
            if (filme.getNome().equalsIgnoreCase(nome)) {
                return filme;
            }
        }
        return null;
    }

    public boolean verificarAssentoDisponivel(String assento) {
        return assentosDisponiveis.contains(assento);
    }

    public void venderIngresso(Ingresso ingresso) throws Exception {
        if (!verificarAssentoDisponivel(ingresso.getAssento())) {
            throw new Exception("O ingresso não pode ser vendido pois seu assento não está mais disponível!");
        }

        if (ingresso.getCliente().getIdade() < ingresso.getFilme().getIdadeMinima()) {
            throw new Exception("O ingresso não pode ser vendido pois sua idade não permite!");
        }

        ingressosVendidos.add(ingresso);
        assentosDisponiveis.remove(ingresso.getAssento());
        System.out.println("Ingresso vendido com sucesso! " + ingresso.getFilme().getNome() + " - " + ingresso.getAssento() + " - " + ingresso.getCliente().getNome());
    }
}


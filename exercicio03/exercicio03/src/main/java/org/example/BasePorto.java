package org.example;

import java.util.ArrayList;

public class BasePorto {
    protected String nome;
    protected ArrayList<Barco> atracados;

    public BasePorto(String nome) {
        this.nome = nome;
        this.atracados = new ArrayList<>();
    }

    public void atracarBarco(Barco barco) {
        atracados.add(barco);
        System.out.println("Barco " + barco.getNome() + " atracado no porto " + nome + ".");
    }

    public void desatracarBarco(Barco barco) {
        if (atracados.remove(barco)) {
            System.out.println("Barco " + barco.getNome() + " desatracado do porto " + nome + ".");
        } else {
            System.out.println("Barco " + barco.getNome() + " não encontrado no porto " + nome + ".");
        }
    }
}
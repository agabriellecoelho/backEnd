package org.example;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Barco barco1 = new Barco("Barco 1", 2);
        Barco barco2 = new Barco("Barco 2", 5);
        Barco barco3 = new Barco("Barco 3", 7);
        Barco barco4 = new Barco("Barco 4", 12);
        Barco barco5 = new Barco("Barco 5", 20);

        ArrayList<Barco> listaDeBarcos = new ArrayList<>();
        listaDeBarcos.add(barco1);
        listaDeBarcos.add(barco2);
        listaDeBarcos.add(barco3);
        listaDeBarcos.add(barco4);
        listaDeBarcos.add(barco5);

        PortoPequeno portoPequeno = new PortoPequeno("Porto Pequeno");
        PortoGrande portoGrande = new PortoGrande("Porto Grande");

        for (Barco barco : listaDeBarcos) {
            portoPequeno.atracarBarco(barco);
            if (!portoPequeno.atracados.contains(barco)) {
                portoGrande.atracarBarco(barco);
            }
        }
    }
}
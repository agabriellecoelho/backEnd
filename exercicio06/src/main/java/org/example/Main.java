package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criar instância do Cinema
        Cinema cinema = new Cinema();

        // Adicionar filmes disponíveis
        cinema.adicionarFilme(new Filme("Homem Aranha", 25.0, 12));
        cinema.adicionarFilme(new Filme("Vingadores", 30.0, 12));
        cinema.adicionarFilme(new Filme("It: A Coisa", 20.0, 18));
        cinema.adicionarFilme(new Filme("Toy Story", 15.0, 0));
        cinema.adicionarFilme(new Filme("Matrix", 25.0, 16));

        while (true) {
            try {
                // Perguntar qual filme deseja assistir
                System.out.println("Que filme você deseja assistir?");
                String nomeFilme = scanner.nextLine();
                Filme filme = cinema.buscarFilme(nomeFilme);

                if (filme == null) {
                    System.out.println("Filme não encontrado!");
                    continue;
                }

                // Perguntar qual assento deseja
                System.out.println("Qual assento você deseja?");
                String assento = scanner.nextLine();

                // Perguntar nome e idade do cliente
                System.out.println("Qual o seu nome?");
                String nomeCliente = scanner.nextLine();
                System.out.println("Qual a sua idade?");
                int idade = scanner.nextInt();
                scanner.nextLine(); // Consumir nova linha

                Cliente cliente = new Cliente(nomeCliente, idade);
                Ingresso ingresso = new Ingresso(cliente, filme, assento);

                // Tentar vender ingresso
                cinema.venderIngresso(ingresso);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            // Perguntar se deseja continuar
            System.out.println("Deseja continuar? (s/n)");
            String continuar = scanner.nextLine();
            if (continuar.equalsIgnoreCase("n")) {
                break;
            }
        }

        scanner.close();
    }
}

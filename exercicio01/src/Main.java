package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[] filmes = {"Homens de Preto", "Arrival", "Shrek", "Gladiador"};

        Scanner scan = new Scanner(System.in);
        System.out.println("Pergunta 1: Que ambientação você prefere?");
        System.out.println("1. Sci-fi");
        System.out.println("2. Medieval");
        String r1 = scan.nextLine();

        System.out.println("Pergunta 2: Que gênero você prefere?");
        System.out.println("1. Comédia");
        System.out.println("2. Drama");
        String r2 = scan.nextLine();

        String stringResultado = "Você deveria assistir ";
        String soma = r1 + r2;

        switch (soma) {
            case "11":
                System.out.println(stringResultado + filmes[0]);
                break;
            case "12":
                System.out.println(stringResultado + filmes[1]);
                break;
            case "21":
                System.out.println(stringResultado + filmes[2]);
                break;
            case "22":
                System.out.println(stringResultado + filmes[3]);
                break;
            default:
                System.out.println("Infelizmente não encontramos nenhum filme o qual você possa assistir.");
                break;
        }

    }
}
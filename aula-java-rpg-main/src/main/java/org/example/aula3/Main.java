package org.example.aula3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        exibirTitulo();

        System.out.println(" Digite o nome do seu heroí: ️");
        String nomeHeroi = scanner.next();

        Heroi heroi = new Heroi(nomeHeroi, 1000,35,5);

        // Adicionando itens ao inventário do herói
        heroi.adicionarItem(new Item("Poção ", "cura", 20));
        heroi.adicionarItem(new Item("Poção Grande", "cura", 50));
        heroi.adicionarItem(new Item("Amuleto de Força", "ataque", 5));


        System.out.println("\n Herói criado com sucesso!");
        heroi.exibirStatus();

        Monstro[] monstros = {
                new Monstro("Goblin",  40,12,2,20),
                new Monstro("Orc Guerreiro", 70,12,2,20),
                new Monstro("Dragão Negro", 95,20,10,100),
                //novos monstros
                new Monstro("Golem", 120,30,15,500),
                new Monstro("Deric", 200, 40,30,0)
        };

        int vitorias = 0;

        for(Monstro monstro: monstros) {
            System.out.println("\n\n Você avança pela dungeon...");
            System.out.println(" Um " + monstro.getNome() + " bloqueia o caminho!");
            System.out.println("\n [1] Lutar");
            System.out.println(" [2] Fugir (pula essa batalha)");
            System.out.println(" Escolha: ");

            int opcao;
            try {
                opcao = scanner.nextInt();
            } catch (Exception e ){
                opcao = 1;
                scanner.nextLine();
            }

            if (opcao == 2) {
                System.out.println("  Você fugiu para o proximo corredor...");
                continue;
            }

            Batalha batalha = new Batalha(heroi, monstro, scanner);
            boolean venceu = batalha.iniciar();

            //recompensa por vencer a batalha
            heroi.adicionarItem(new Item("Ouro do " + monstro.getNome(), "Cura", monstro.getXpRecompensa()));
            heroi.ganharXp(monstro.getXpRecompensa());

            if (venceu) {
                vitorias++;
                System.out.println("\n [Pressione ENTER para continuar]");
                scanner.nextLine();
                scanner.nextLine();
            } else {
                exibirGameOver(nomeHeroi, vitorias, heroi.getXp());
                scanner.close();
                return;
            }

        }

        exibirVitoria(heroi, vitorias);
        scanner.close();
    }

    private static void exibirTitulo() {
        System.out.println("-------------------------------------------");
        System.out.println("-          DUNGEON QUEST                -");
        System.out.println("-  Programação Orientação a Objeto        -");
        System.out.println("-------------------------------------------");
        System.out.println();
    }

    private static void exibirGameOver(String nome, int vitorias, int xp) {
        System.out.println("-------------------------------------------");
        System.out.println("-             GAME OVER                 -");
        System.out.println("-------------------------------------------");
        System.out.println(" Fim da Jornada de " + nome);
        System.out.println(" Vitórias: "+ vitorias);
        System.out.println(" XP Total: " + xp);
        System.out.println();
    }

    private static void exibirVitoria(Heroi heroi, int vitorias) {
        System.out.println("-----------------------------------------------");
        System.out.println("-           DUNGEON COMPLETA!              -");
        System.out.println("-----------------------------------------------");
        System.out.println(" Parabéns, " + heroi.getNome() + "!");
        System.out.println(" Vitórias: " + vitorias);
        System.out.println(" XP Total: " + heroi.getXp());
        heroi.exibirStatus();
    }
}
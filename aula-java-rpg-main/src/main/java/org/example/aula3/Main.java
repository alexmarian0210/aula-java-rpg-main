package org.example.aula3;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        exibirTitulo();

        System.out.println("Digite o nome do herói:");
        String nomeHeroi = scanner.next();

        Heroi heroi = new Heroi(nomeHeroi, 100, 35, 10);

        System.out.println(" Heroi criado com sucesso!");
        heroi.exibirStatus();

        Monstro[] monstros = {
                new Monstro("Goblin", 50, 15, 5, 20),
                new Monstro("Orc", 39, 25, 10, 40),
                new Monstro("Troll", 80, 30, 15, 60)
        };
        int vitorias = 0;

        for(Monstro monstro: monstros) {
            System.out.println("\n você avança pela masmorra...");
            System.out.println(" um " + monstro.getNome() + " aparece!");
            System.out.println(" Prepare-se para a batalha!");
            System.out.println("\n [1] para lutar");
            System.out.println(" [2] para fugir");
            System.out.print("Escolha: ");

            int opcao;
            try{
                opcao = scanner.nextInt();
            }catch (Exception e){
                opcao = 1;
                scanner.nextLine();
            }

            if (opcao == 2) {
                System.out.println(" Você fugiu da batalha!");
                continue;
            }

            Batalha batalha = new Batalha(heroi, monstro, scanner);
            boolean venceu = batalha.inicia();

            if(venceu) {
                vitorias++;
                System.out.println("Precione [ENTER] para continuar...");
                scanner.nextLine();
                scanner.nextLine();
            }else {
                exibirGameOver(nomeHeroi, vitorias, heroi.getXp());
                scanner.close();
                break;
            }
       }
        exibirVitorias(nomeHeroi, vitorias);
        scanner.close();
    }

    private static void exibirTitulo() {
        System.out.println("--------------------------------");
        System.out.println( "   BEM-VINDO AO RPG DE CONSOLE!   ");
        System.out.println("     Prepare-se para a aventura!      ");
        System.out.println("-------------------------------- ");

    }

    private static void exibirGameOver(String nomeHeroi, int vitorias, int xp) {
        System.out.println("--------------------------------");
        System.out.println("           GAME OVER!            ");
        System.out.println("---------------------------------");
        System.out.println("fim da jornada de " + nomeHeroi);
        System.out.println("Vitorias: " + vitorias);
        System.out.println("XP acumulada: " + xp);
    }

    private static void exibirVitorias(String nomeHeroi, int vitorias) {
        System.out.println("--------------------------------");
        System.out.println("     PARABÉNS, " + nomeHeroi.toUpperCase() + "!     ");
        System.out.println("   Você venceu todos os monstros!   ");
        System.out.println("Vitorias: " + vitorias);
        System.out.println("--------------------------------");
    }



    
    

       


}
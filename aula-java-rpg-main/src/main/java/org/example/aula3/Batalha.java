package org.example.aula3;

import java.util.Scanner;

public class Batalha {

    private Heroi heroi;
    private Monstro monstro;    
    private Scanner scanner;

    public Batalha(Heroi heroi, Monstro monstro, Scanner scanner) {
        this.heroi = heroi;
        this.monstro = monstro;
        this.scanner = scanner;
    }

    //inicia e controla o loop da batalha

    public boolean inicia() {
        exibirCabecalhoBatalha();

        int turno = 1;
        while (heroi.estaVivo() && monstro.estaVivo()) {
        System.out.println("-----------  Turno  " + turno + " -----------");
        exibirStatusBatalha();

        turnoHeroi();

        if (monstro.estaVivo()) {
            turnoMonstro();
        }

        turno++;
    }

    return resolverFinal();
    

}

 //metodos privados 

 private void turnoHeroi(){
    System.out.println("\n o que " + heroi.getNome() + " faz?");
    System.out.println(" [1] Atacar");
    System.out.println(" [2] Usar Poção (" + heroi.getPocoes() + " restantes)");
    System.out.print("Escolha: ");


    int escolha = lerEscolha();

        switch (escolha) {
         case 1:
            int dano = heroi.atacar();
            System.out.println(heroi.getNome() + " atacou o monstro com " + dano + " de dano!");
            monstro.receberDano(dano);
            break;

        case 2:
            heroi.usarPocao();
            break;
        default:
            System.out.println("Escolha inválida! Você perdeu a vez.");
           
    
 }
    
}
 

 private void turnoMonstro() {
    int dano = monstro.atacar();
    System.out.println(monstro.getNome() + " atacou o herói com " + dano + " de dano!");
    heroi.receberDano(dano);
    }

    private boolean resolverFinal() {


        if (heroi.estaVivo()) {
            System.out.println("\n " + heroi.getNome() + " venceu a batalha!");
            heroi.ganharXp(monstro.getXpRecompensa());
            return true;
        } else {
            System.out.println("\n " + heroi.getNome() + " foi derrotado...");
            return false;
        }
    }


private void exibirCabecalhoBatalha() {
    System.out.println("===================================");
    System.out.println(" BATALHA: " + heroi.getNome() + " VS " + monstro.getNome());
    System.out.println("===================================");
}      
private void exibirStatusBatalha() {
    heroi.exibirStatus();
    System.out.println();
    monstro.exibirStatus();


}
private int lerEscolha(){
    try {
        return scanner.nextInt();
    } catch (Exception e) {
        scanner.nextLine(); // Limpa o buffer de entrada
        return -1; // Retorna um valor inválido para indicar erro
    }

}



}
package org.example.aula3;

public class Monstro {
    private String nome;
    private int vida;
    private int ataque;
    private int defesa;
    private int xpRecompensa;

    public Monstro(String nome, int vida, int ataque, int defesa, int xpRecompensa) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.xpRecompensa = xpRecompensa;
    }

    public String getNome() { return nome; }
    public int getVida() { return vida;}
    public int getXpRecompensa() {return  xpRecompensa; }

    public int atacar() {
        int variacao = (int)(Math.random() * 8);
        return ataque + variacao;
    }

    public void receberDano(int dano) {
        int danoReal = dano - defesa;
        if(danoReal < 1) danoReal = 1;

        vida -= danoReal;
        if(vida < 0) vida = 0;

        System.out.println( nome + " recebeu " + danoReal + " de dano! " +
              "vida restante:" + vida +  "]");

    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void exibirStatus() {
        System.out.println(" " + nome);
        System.out.println( "Vida: " + vida);
        System.out.println("Ataque: " + ataque);
        System.out.println("Defesa: " + defesa);
    }
}

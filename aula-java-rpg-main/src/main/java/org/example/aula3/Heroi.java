package org.example.aula3;

public class Heroi {

    private String nome;
    private int vidaMaxima;
    private int vidaAtual;
    private int ataque;
    private int defesa;
    private int pocoes;
    private int xp;

    public Heroi(String nome, int vida, int ataque, int defesa) {
        this.nome = nome;
        this.vidaMaxima = vida;
        this.vidaAtual = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.pocoes = 3;
        this.xp = 0;
    }

    public String getNome() {return nome;}
    public int getVida()    { return  vidaAtual; }
    public int getAtaque()  { return ataque; }
    public int getDefesa()  { return defesa; }
    public int getPocoes()  { return pocoes; }
    public int getXp()      { return xp; }

    public int atacar() {
        int variacao = (int)(Math.random() * 10) - 5;
        return ataque + variacao;
    }

    public void receberDano(int dano) {
        int danoReal = dano - defesa;
        if(danoReal < 1) danoReal = 1;

        vidaAtual -= danoReal;
        if(vidaAtual < 0) vidaAtual = 0;

        System.out.println( nome + " recebeu " + danoReal + " de dano! "
         + vidaAtual + "/" + vidaMaxima + "]");

    }

    public boolean usarPocao() {
        if (pocoes <= 0) {
            System.out.println("  Sem poções!");
            return false;
        }
        if (vidaAtual == vidaMaxima){
            System.out.println("  Vida já está cheia! Poção não foi usada.");
            return false;
        }

        int cura = 30;
        vidaAtual += cura;
        if ( vidaAtual > vidaMaxima) vidaAtual = vidaMaxima;

        pocoes--;
        System.out.println( nome + " usou poção! +30  "
                 + vidaAtual + "/" + vidaMaxima + "] [Poções: " + pocoes + "]");
        return true;
    }

    public void ganharXp(int quantidade) {
        xp += quantidade;
        System.out.println( quantidade + " XP! [Total: " + xp + "]");
    }

    public boolean estaVivo() {
        return vidaAtual > 0;
    }

    public void exibirStatus() {
        System.out.println("\n" + nome);
        System.out.println("  Vida: " + vidaAtual + "/" + vidaMaxima);
        System.out.println(" Ataque: " + ataque);
        System.out.println(" Defesa: " + defesa);
        System.out.println(" Poções: " + pocoes);
        System.out.println(" XP: " + xp);

    }
}

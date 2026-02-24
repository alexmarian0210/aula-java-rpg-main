package org.example.aula3;

public class Item {

    private String nome;
    private String tipo;
    private int valor;

    public Item(String nome, String tipo, int valor) {
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    public void usar(Heroi heroi) {
        System.out.println("\nUsando " + nome + "...");
        if (tipo.equals("cura")) {
            heroi.receberCura(valor);
        } else if (tipo.equals("ataque")) {
            heroi.aumentarAtaque(valor);
        }
    }

    public String getDescricao() {
        return nome + " [" + tipo + " +" + valor + "]";
    }

    public String getNome() { return nome; }
    public String getTipo() { return tipo; }
    public int getValor() { return valor; }
}
package partecentraljogo;

import java.util.Scanner;

public class Jogador {

    private String NomeJogador;
    public Baralho baralho;

    public Jogador(String NomeJogador, Baralho baralho) {
        this.NomeJogador = NomeJogador;
        this.baralho = baralho;

    }

    public Baralho getBaralho() {
        return baralho;
    }

    public void setBaralho(Baralho baralho) {
        this.baralho = baralho;
    }

    public String getNomeJogador() {
        return NomeJogador;
    }

    public void setNomeJogador(String val) {
        this.NomeJogador = val;
    }

    //PRIMEIRA RODADA-----------------------------------------------------------------------
    public final void escolherCartaMao(Carta baralho0, int i) {
        System.out.println("Carta escolhida Nome: " + baralho0.getNomeCarta() + " Forca: "+ baralho0.getForca() + "\n");
    }

    public void AdicionaVivoMao(int i, Carta baralho0) {
        baralho.ListaMonteVivosNaMesa.add(baralho0);
        RemoveVivoMao(i, baralho0);
    }

    public void RemoveVivoMao(int i, Carta baralho0) {
        baralho.ListaNaMao.remove(i);
    }

    //SEGUNDA RODADA--------------------------------------------------------------------------
    public void escolherCartaMesa1(Carta baralho0, int i) {
        System.out.println("Carta escolhida Nome: " + baralho0.getNomeCarta() + " Forca: "+ baralho0.getForca() + "\n");
    }

    public void AdicionaVivoMesa1(int i, Carta baralho0) {
        baralho.ListaMonteVivosNaMesa.add(baralho0);
        RemoveVivoMesa1(i, baralho0);
    }

    public void RemoveVivoMesa1(int i, Carta baralho0) {
        baralho.ListaMesa1.remove(i);
    }

    //TERCEIRA RODADA--------------------------------------------------------------------------
    public void escolherCartaMesa2(Carta baralho0, int i) {
        System.out.println("Carta escolhida Nome: " + baralho0.getNomeCarta() + " Forca: "+ baralho0.getForca() + "\n");
    }

    public void AdicionaVivoMesa2(int i, Carta baralho0) {
        baralho.ListaMonteVivosNaMesa.add(baralho0);
        RemoveVivoMesa2(i, baralho0);
    }

    public void RemoveVivoMesa2(int i, Carta baralho0) {
        baralho.ListaMesa2.remove(i);
    }
    
    //QUARTA E DEMAIS RODADAS------------------------------------------------------------------
    public void escolherCartaMonteVivosNaMao(Carta baralho0, int i) {
        System.out.println("Carta escolhida Nome: " + baralho0.getNomeCarta() + " Forca: "+ baralho0.getForca() + "\n");
    }

    public void AdicionaMonteVivosNaMao(int i, Carta baralho0) {
        baralho.ListaMonteVivosNaMesa.add(baralho0);
        RemoveMonteVivosNaMao(i, baralho0);
    }

    public void RemoveMonteVivosNaMao(int i, Carta baralho0) {
        baralho.ListaMonteVivosNaMao.remove(i);
    }  
      
}

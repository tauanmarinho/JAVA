package partecentraljogo;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Jogador {
    Scanner input = new Scanner(System.in);
    
    private String NomeJogador;
    public Baralho baralho;
    List<Carta> mao = new ArrayList<>();
    List<Carta> monte1 = new ArrayList<>();
    List<Carta> monte2 = new ArrayList<>();
    List<Carta> monte3 = new ArrayList<>();
    List<Carta> monteVivos = new ArrayList<>();
    
    
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
    
    public void mostraMao(){
        System.out.println("Suas cartas em mao sao: ");
        for (int i = 0; i < this.mao.size(); i++) {
            System.out.println(i + " - Nome: " + this.mao.get(i).getNomeCarta() + "\n    Forca: " + this.mao.get(i).getForca());
        }
    }
    
    public ArrayList getMontesDisponiveis(){
        ArrayList montes = new ArrayList();
        
        if(!this.monte1.isEmpty()) montes.add(1);
        if(!this.monte2.isEmpty()) montes.add(2);
        if(!this.monte3.isEmpty()) montes.add(3);
        if(!this.monteVivos.isEmpty()) montes.add(4);
            
        return montes;
    }    
}

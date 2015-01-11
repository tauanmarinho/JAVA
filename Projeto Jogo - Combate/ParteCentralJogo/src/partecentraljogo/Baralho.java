package partecentraljogo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.TreeSet;

public class Baralho {

    private boolean naMao;
    private Carta carta;
    ArrayList<Carta> ListaCarta = new ArrayList<Carta>();//todas as cartas do jogo
    ArrayList<Carta> ListaNaMao = new ArrayList<Carta>();//as cartas na mao 15
    ArrayList<Carta> ListaMesa1 = new ArrayList<Carta>();//as cartas na mesa 15
    ArrayList<Carta> ListaMesa2 = new ArrayList<Carta>();//as outras cartas na mesa 15
    ArrayList<Carta> ListaMonteVivosNaMesa = new ArrayList<Carta>();//monte que vai aumentando com o decorer da partida e serao usadas na 4 rodade
    ArrayList<Carta> ListaMonteVivosNaMao = new ArrayList<Carta>();
    
    Baralho(Carta MinasTerrestres, Carta AgenteSecreto, Carta Soldado, Carta Cabo, Carta Sargento,
            Carta Subtenente, Carta Tenente, Carta Capitao, Carta Major, Carta Coronel, Carta General) {


        ListaCarta.add(MinasTerrestres);
        ListaCarta.add(MinasTerrestres);
        ListaCarta.add(MinasTerrestres);
        ListaCarta.add(MinasTerrestres);
        ListaCarta.add(MinasTerrestres);
        ListaCarta.add(MinasTerrestres);
        ListaCarta.add(AgenteSecreto);
        ListaCarta.add(AgenteSecreto);
        ListaCarta.add(Soldado);
        ListaCarta.add(Soldado);
        ListaCarta.add(Soldado);
        ListaCarta.add(Soldado);
        ListaCarta.add(Soldado);
        ListaCarta.add(Soldado);
        ListaCarta.add(Soldado);
        ListaCarta.add(Soldado);
        ListaCarta.add(Cabo);
        ListaCarta.add(Cabo);
        ListaCarta.add(Cabo);
        ListaCarta.add(Cabo);
        ListaCarta.add(Cabo);
        ListaCarta.add(Cabo);
        ListaCarta.add(Cabo);
        ListaCarta.add(Sargento);
        ListaCarta.add(Sargento);
        ListaCarta.add(Sargento);
        ListaCarta.add(Sargento);
        ListaCarta.add(Sargento);
        ListaCarta.add(Subtenente);
        ListaCarta.add(Subtenente);
        ListaCarta.add(Subtenente);
        ListaCarta.add(Subtenente);
        ListaCarta.add(Subtenente);
        ListaCarta.add(Tenente);
        ListaCarta.add(Tenente);
        ListaCarta.add(Tenente);
        ListaCarta.add(Tenente);
        ListaCarta.add(Tenente);
        ListaCarta.add(Capitao);
        ListaCarta.add(Capitao);
        ListaCarta.add(Capitao);
        ListaCarta.add(Major);
        ListaCarta.add(Major);
        ListaCarta.add(Coronel);
        ListaCarta.add(General);


    }

    public void embaralhar() {

        Collections.shuffle(ListaCarta);

        for (int j = 0; j < 15; j++) {
            ListaNaMao.add(ListaCarta.get(j));
        }
        
        for (int j = 15; j < 30; j++) {
            ListaMesa1.add(ListaCarta.get(j));
        }
        
        for (int j = 30; j < 45; j++) {
            ListaMesa2.add(ListaCarta.get(j));
        }

    }

    public void MostraCartaMao() {
        System.out.println("Suas cartas em maos sao: ");
        for (int i = 0; i < ListaNaMao.size(); i++) {
            System.out.println(i + " - Nome: " + ListaNaMao.get(i).getNomeCarta() + "\n    Forca: " + ListaNaMao.get(i).getForca());
        }
    }

    public void MostraCartaMesa1() {
        System.out.println("Suas cartas em maos sao: ");
        for (int i = 0; i < ListaMesa1.size(); i++) {
            System.out.println(i + " - Nome: " + ListaMesa1.get(i).getNomeCarta() + "\n    Forca: " + ListaMesa1.get(i).getForca());
        }
    }

    public void MostraCartaMesa2() {
        System.out.println("Suas cartas em maos sao: ");
        for (int i = 0; i < ListaMesa2.size(); i++) {
            System.out.println(i + " - Nome: " + ListaMesa2.get(i).getNomeCarta() + "\n    Forca: " + ListaMesa2.get(i).getForca());
        }
    }
    
    public void MostraCartaMonteVivosMao() {
        System.out.println("Suas cartas em maos sao: ");
        for (int i = 0; i < ListaMonteVivosNaMao.size(); i++) {
            System.out.println(i + " - Nome: " + ListaMonteVivosNaMao.get(i).getNomeCarta() + "\n    Forca: " + ListaMonteVivosNaMao.get(i).getForca());
        }
    }

    public Carta getCartaMao(int i) {
        return ListaNaMao.get(i);
    }

    public Carta getCartaMesa1(int i) {
        return ListaMesa1.get(i);
    }

    public Carta getCartaMesa2(int i) {
        return ListaMesa2.get(i);
    }
    
    public Carta getCartaMonteVivosMao(int i){
        return ListaMonteVivosNaMao.get(i);
    }
}

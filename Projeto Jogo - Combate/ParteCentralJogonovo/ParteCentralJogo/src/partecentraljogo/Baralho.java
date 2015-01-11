package partecentraljogo;

import java.util.ArrayList;
import java.util.Collections;

public class Baralho {

    private Carta carta;
    ArrayList<Carta> baralho = new ArrayList<>();
        
    Carta AgenteSecreto = new Carta("Agente Secreto", 1);
    Carta Soldado = new Carta("Soldado", 2);
    Carta Cabo = new Carta("Cabo", 3);
    Carta Sargento = new Carta("Sargento", 4);
    Carta Subtenente = new Carta("Subtenente", 5);
    Carta Tenente = new Carta("Tenente", 6);
    Carta Capitao = new Carta("Capitao", 7);
    Carta Major = new Carta("Major", 8);
    Carta Coronel = new Carta("Coronel", 9);
    Carta General = new Carta("General", 10);
    Carta MinasTerrestres = new Carta("Minas Terrestres", 50);
    
    Baralho() {
        baralho.add(MinasTerrestres);
        baralho.add(MinasTerrestres);
        baralho.add(MinasTerrestres);
        baralho.add(MinasTerrestres);
        baralho.add(MinasTerrestres);
        baralho.add(MinasTerrestres);
        baralho.add(AgenteSecreto);
        baralho.add(AgenteSecreto);
        baralho.add(Soldado);
        baralho.add(Soldado);
        baralho.add(Soldado);
        baralho.add(Soldado);
        baralho.add(Soldado);
        baralho.add(Soldado);
        baralho.add(Soldado);
        baralho.add(Soldado);
        baralho.add(Cabo);
        baralho.add(Cabo);
        baralho.add(Cabo);
        baralho.add(Cabo);
        baralho.add(Cabo);
        baralho.add(Cabo);
        baralho.add(Cabo);
        baralho.add(Sargento);
        baralho.add(Sargento);
        baralho.add(Sargento);
        baralho.add(Sargento);
        baralho.add(Sargento);
        baralho.add(Subtenente);
        baralho.add(Subtenente);
        baralho.add(Subtenente);
        baralho.add(Subtenente);
        baralho.add(Subtenente);
        baralho.add(Tenente);
        baralho.add(Tenente);
        baralho.add(Tenente);
        baralho.add(Tenente);
        baralho.add(Tenente);
        baralho.add(Capitao);
        baralho.add(Capitao);
        baralho.add(Capitao);
        baralho.add(Major);
        baralho.add(Major);
        baralho.add(Coronel);
        baralho.add(General);
    }

    public void embaralhar() {
        Collections.shuffle(baralho);
    }        
}

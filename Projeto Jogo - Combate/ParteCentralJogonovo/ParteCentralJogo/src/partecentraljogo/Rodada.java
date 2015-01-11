package partecentraljogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rodada {

    Scanner input = new Scanner(System.in);
    int escolha;
    int rodada;

    public Rodada(Jogador jogador1, Jogador jogador2) {

        jogador1.baralho.embaralhar();
        jogador2.baralho.embaralhar();

        for (int n = 0; n < 15; n++) {
            jogador1.monte1.add(jogador1.baralho.baralho.get(n));
            jogador2.monte1.add(jogador2.baralho.baralho.get(n));
        }

        for (int n = 15; n < 30; n++) {
            jogador1.monte2.add(jogador1.baralho.baralho.get(n));
            jogador2.monte2.add(jogador2.baralho.baralho.get(n));
        }

        for (int n = 30; n < 45; n++) {
            jogador1.monte3.add(jogador1.baralho.baralho.get(n));
            jogador2.monte3.add(jogador2.baralho.baralho.get(n));
        }

        int rodada = 0;

        ArrayList montesJogador1;
        ArrayList montesJogador2;

        do {

            rodada = rodada + 1;
            montesJogador1 = jogador1.getMontesDisponiveis();
            montesJogador2 = jogador2.getMontesDisponiveis();

            if (rodada < 4) {
                montesJogador1.remove(new Integer(4));
                montesJogador2.remove(new Integer(4));
                getMonte(jogador1, montesJogador1);
                getMonte(jogador2, montesJogador2);
            } else {
                for (int n = 0; n < jogador1.monteVivos.size(); n++) {
                    jogador1.mao.add(jogador1.monteVivos.get(n));                    
                }
                jogador1.monteVivos.clear();
                        

                for (int n = 0; n < jogador2.monteVivos.size(); n++) {
                        
                    jogador2.mao.add(jogador2.monteVivos.get(n));                    
                }
                jogador2.monteVivos.clear();                
            }

            System.out.println("\n\nRodada " + rodada + ":");

            while ((!jogador1.mao.isEmpty()) && (!jogador2.mao.isEmpty())) {
                jogada(jogador1, jogador2);
            }
            
            if ((rodada >= 4)&&(!jogador1.mao.isEmpty())) {
                for (int n = 0; n < jogador1.mao.size(); n++) {
                    jogador1.monteVivos.add(jogador1.mao.get(n));                    
                }                
                jogador1.mao.clear();                             
            }

            if ((rodada >= 4)&&(!jogador2.mao.isEmpty())) {
                for (int n = 0; n < jogador2.mao.size(); n++) {
                    jogador2.monteVivos.add(jogador2.mao.get(n));
                }
                jogador2.mao.clear();                
            }
            
        } while ((!jogador1.monteVivos.isEmpty()) && (!jogador2.monteVivos.isEmpty())); 
        
        if(!jogador1.monteVivos.isEmpty()){
            System.out.println(jogador1.getNomeJogador() + " VENCEU A PARTIDA!");
            Menu menuu = new Menu();
        }else{
            if(!jogador2.monteVivos.isEmpty()){
                System.out.println(jogador2.getNomeJogador() + " VENCEU A PARTIDA!");
                Menu menuu = new Menu();
            }else{
                System.out.println("A PARTIDA EMPATOU!");
                Menu menuu = new Menu();                        
            }
        }        
    }

    public void jogada(Jogador jogador2, Jogador jogador1) {
        int escolhaJogador1 = selecionaCarta(jogador1, jogador1.mao);
        int escolhaJogador2 = selecionaCarta(jogador2, jogador2.mao);

        System.out.println("\n\n" + jogador1.getNomeJogador() + " escolheu a carta " + jogador1.mao.get(escolhaJogador1).getNomeCarta());
        System.out.println(jogador2.getNomeJogador() + " escolheu a carta " + jogador2.mao.get(escolhaJogador2).getNomeCarta());

        Carta carta;
        int ganhador = comparaCartas(jogador1.mao.get(escolhaJogador1), jogador2.mao.get(escolhaJogador2));

        switch (ganhador) {
            case -1:
                System.out.println("\n" + jogador1.getNomeJogador() + " ganhou a jogada!");
                jogador2.mao.remove(escolhaJogador2);
                if(jogador1.mao.get(escolhaJogador1).getForca()==50){
                    jogador1.mao.remove(escolhaJogador1);
                }else{
                    carta = jogador1.mao.remove(escolhaJogador1);
                    jogador1.monteVivos.add(carta);
                }
                break;
            case 0:
                jogador1.mao.remove(escolhaJogador1);
                jogador2.mao.remove(escolhaJogador2);
                System.out.println("\nA jogada empatou!");
                break;
            case 1:
                System.out.println("\n" + jogador2.getNomeJogador() + " ganhou a jogada!");
                jogador1.mao.remove(escolhaJogador1);
                if(jogador2.mao.get(escolhaJogador2).getForca()==50){
                    jogador2.mao.remove(escolhaJogador2);
                }else{
                    carta = jogador2.mao.remove(escolhaJogador2);
                    jogador2.monteVivos.add(carta);
                }
                break;            
            default:
                System.out.println("\nErro!");
                System.exit(1); //caso não exista a comparacao, sai do programa (deu erro no programa).
        }
    }

    public void getMonte(Jogador jogador, ArrayList montesDisponiveis) {

        System.out.println("\n" + jogador.getNomeJogador() + " escolha um monte: \n");

        for (int i = 0; i < montesDisponiveis.size(); i++) {
            System.out.println(montesDisponiveis.get(i) + " - Monte " + montesDisponiveis.get(i));
        }

        do {
            System.out.print("\nEscolha uma opção: ");
            escolha = input.nextInt();
        } while (!montesDisponiveis.contains(escolha));

        switch (escolha) {
            case 1:
                jogador.mao = jogador.monte1;
                break;
            case 2:
                jogador.mao = jogador.monte2;
                break;
            case 3:
                jogador.mao = jogador.monte3;
                break;
        }
    }

    public int selecionaCarta(Jogador jogador, List<Carta> listaCartas) {
        System.out.println("\n\nCartas de " + jogador.getNomeJogador() + ":");
        jogador.mostraMao();

        do {
            System.out.print("\nEscolha uma opcao: ");
            escolha = input.nextInt();
        } while ((escolha < 0) || (escolha > (listaCartas.size()) - 1));

        return escolha;
    }

    //retorno 0 = empatou.
    //retorno <0 = jogador1 ganhou.
    //retornou >0 = jogador2 ganhou.
    public int comparaCartas(Carta carta1, Carta carta2) {
        int forca1 = carta1.getForca();
        int forca2 = carta2.getForca();

        if (forca1 == forca2) {
            return 0;
        }

        if ((forca1 == 50) && (forca2 == 3)) {
            return 1;
        }

        if ((forca1 == 3) && (forca2 == 50)) {
            return -1;
        }

        if ((forca1 == 1) && (forca2 == 10)) {
            return -1;
        }

        if ((forca1 == 10) && (forca2 == 1)) {
            return 1;
        }

        if (forca1 > forca2) {
            return -1;
        }

        if (forca2 > forca1) {
            return 1;
        }
        return 3;
    }
}

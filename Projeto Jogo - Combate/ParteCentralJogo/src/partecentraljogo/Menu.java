/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package partecentraljogo;

import java.util.Scanner;

/**
 *
 * @author Tauan
 */
public class Menu {

    public Menu() {
        Iniciar();
    }

    public void Iniciar() {
        Carta MinasTerrestres = new Carta("Minas Terrestres", 0);
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
        
        System.out.print("Jogo Combate\n\n1 - Iniciar\n2 - Creditos\n3 - Regras\n4 - Sair\n\nEscolha uma das opcoes acima: ");
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();
       switch (i) {
            case 1:
                Baralho baralho1 = new Baralho(MinasTerrestres, AgenteSecreto, Soldado, Cabo, Sargento,
                        Subtenente, Tenente, Capitao, Major, Coronel, General);

                Baralho baralho2 = new Baralho(MinasTerrestres, AgenteSecreto, Soldado, Cabo, Sargento,
                        Subtenente, Tenente, Capitao, Major, Coronel, General);
                
                System.out.print("Digite o nome do Jogador 1: ");
                String Jogador1 = input.next();
                input.nextLine();
                
                System.out.print("Digite o nome do Jogador 2: ");
                String Jogador2 = input.next();
                input.nextLine();

                Jogador jogador1 = new Jogador(Jogador1, baralho1);
                Jogador jogador2 = new Jogador(Jogador2, baralho2);

                
                Rodada rodada = new Rodada(jogador1, jogador2);
                break;

            case 2:
                Creditos();
                break;

            case 3:
                Regras();
                break;

            case 4:
                Sair();

            default:
                System.out.println("Opcao invalida\n\n");
                Iniciar();
                break;
        }
    }

    public void Creditos() {
        System.out.println("Jogo Combate\nDesenvolvido por:\nTauan Marinho\nThiago Lemos\nMurilo");
        System.out.println("\n1 - Menu");
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();
       switch (i) {
            case 1:
                Iniciar();
                break;

            default:
                System.out.println("Entrada invalida!\n\n");
                Creditos();
        }
    }

    public void Sair() {
        System.exit(0);
    }

    public void Regras() {
        System.out.println("\nJogo Combate - REGRAS");
        System.out.println("\nVence o jogador que terminar com pelo menos uma carta.");
        System.out.println("O jogo consiste em comparacao de forcas, em que a maior forca vence a jogada.");
        System.out.println("As minas terrestres destroem todas as cartas porem a unica carta que destroi a mina terrestre eh a carta 'cabo'.");
        System.out.println("A unica carta que pode vencer a carta 'General' eh a carta 'Agente Secreto'.");
        System.out.println("Nas tres primeiras rodadas, cada jogador inicia com 15 cartas (sao tres montes).");
        System.out.println("Ao final da terceira rodada, os jogadores utilizam as cartas remanescentes (todas as cartas que venceram as tres rodadas anteriores).");

        System.out.print("\n\nDigite 1 para voltar ao menu inicial: ");
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();

        switch (i) {
            case 1:
                Iniciar();
                break;

            default:
                System.out.println("Entrada invalida!\n\n");
                Regras();
        }
    }
}

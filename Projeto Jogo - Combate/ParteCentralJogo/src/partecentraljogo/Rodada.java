package partecentraljogo;

import java.util.ArrayList;
import java.util.Scanner;

public class Rodada {

    public Rodada(Jogador jogador1, Jogador jogador2) {
        jogador1.baralho.embaralhar();//cartas jogador1 embaralhadas e distribuidas nos 3 montes de cartas
        jogador2.baralho.embaralhar();//cartas jogador2 embaralhadas e distribuidas nos 3 montes de cartas
        jogador1.setBaralho(jogador1.baralho);
        jogador2.setBaralho(jogador2.baralho);

        //USANDO BARALHO NA MAO------------------------------------------------- 1 BARALHO
        Scanner input = new Scanner(System.in);
        //JOGADOR 1
        int d, i, k, l, m, u, w, x, jogadasmaximas;

        for (int y = 0; y < 15; y++) {
            System.out.println("\n" + jogador1.getNomeJogador());//nome do jogador1
            jogador1.baralho.MostraCartaMao();//jogador1.baralho.MostraCartaMao();//mostra todas as cartas em maos do jogador1  
            System.out.println("Numeros de carta: " + jogador1.baralho.ListaNaMao.size());

            do {
                System.out.print("Digite o numero da carta: ");
                i = input.nextInt();
            } while ((i < 0) || (i > ((jogador1.baralho.ListaNaMao.size()) - 1)));
            
            
            jogador1.escolherCartaMao(jogador1.baralho.ListaNaMao.get(i), i);


            //JOGADOR 2
            System.out.println("\n" + jogador2.getNomeJogador());//nome do jogador2
            jogador2.baralho.MostraCartaMao();//mostra todas as cartas em maos do jogador2
            System.out.println("Numeros de carta: " + jogador2.baralho.ListaNaMao.size());

            do {
                System.out.print("Digite o numero da carta: ");
                x = input.nextInt();
            } while ((x < 0) || (x > ((jogador2.baralho.ListaNaMao.size()) - 1)));

            jogador2.escolherCartaMao(jogador2.baralho.ListaNaMao.get(x), x);
            AnalisaMao(jogador1, i, jogador2, x);

        }
        //USANDO 1 BARALHO NA Mesa------------------------------------------------ 2 BARALHO
        //JOGADOR 1
        for (int y = 0; y < 15; y++) {
            System.out.println("\n" + jogador1.getNomeJogador());//nome do jogador1
            jogador1.baralho.MostraCartaMesa1();//mostra todas as cartas em maos do jogador1  
            System.out.println("Numeros de carta: " + jogador1.baralho.ListaMesa1.size());

            do {
                System.out.print("\nDigite o numero da carta: ");
                u = input.nextInt();
            } while ((u < 0) || (u > ((jogador1.baralho.ListaMesa1.size()) - 1)));

            jogador1.escolherCartaMesa1(jogador1.baralho.ListaMesa1.get(u), u);

            //JOGADOR 2
            System.out.println("\n" + jogador2.getNomeJogador());//nome do jogador2
            jogador2.baralho.MostraCartaMesa1();//mostra todas as cartas em maos do jogador2
            System.out.println("Numeros de carta: " + jogador2.baralho.ListaMesa1.size());

            do {
                System.out.print("Digite o numero da carta: ");
                w = input.nextInt();
            } while ((w < 0) || (w > ((jogador2.baralho.ListaMesa1.size()) - 1)));

            jogador2.escolherCartaMesa1(jogador2.baralho.ListaMesa1.get(w), w);
            AnalisaMesa1(jogador1, u, jogador2, w);
        }

        //USANDO 2 BARALHO NA Mesa------------------------------------------------ 3 BARALHO
        //JOGADOR 1
        for (int y = 0; y < 15; y++) {
            System.out.println("\n" + jogador1.getNomeJogador());//nome do jogador1
            jogador1.baralho.MostraCartaMesa2();//mostra todas as cartas em maos do jogador1  
            System.out.println("Numero de cartas: " + jogador1.baralho.ListaMesa2.size());

            do {
                System.out.print("Digite o numero da carta: ");
                k = input.nextInt();
            } while ((k < 0) || (k > ((jogador1.baralho.ListaMesa2.size()) - 1)));

            jogador1.escolherCartaMao(jogador1.baralho.ListaMesa2.get(k), k);

            //JOGADOR 2
            System.out.println("\n" + jogador2.getNomeJogador());//nome do jogador2
            jogador2.baralho.MostraCartaMesa2();//mostra todas as cartas em maos do jogador2
            System.out.println("Numeros de carta: " + jogador2.baralho.ListaMesa2.size());

            do {
                System.out.print("Digite o numero da carta: ");
                d = input.nextInt();
            } while ((d < 0) || (d > ((jogador2.baralho.ListaMesa2.size()) - 1)));

            jogador2.escolherCartaMao(jogador2.baralho.ListaMesa2.get(d), d);
            AnalisaMesa2(jogador1, k, jogador2, d);
        }

        //USANDO BARALHO Monte vivo------------------------------------------------ 
        //Verifica se algum dos jogadores está sem cartas. Caso algum jogador já esteja zerado (em numero de cartas), nao entra no while.
        while (((jogador1.baralho.ListaMonteVivosNaMesa.size()) != 0) && ((jogador2.baralho.ListaMonteVivosNaMesa.size()) != 0)) {
            //imprime a quantidade de cartas do monte Vivo da Mesa de cada jogador
            System.out.println("\n\nNumeros de carta no monte Vivos do " + jogador1.getNomeJogador() + ": " + jogador1.baralho.ListaMonteVivosNaMesa.size());
            System.out.println("Numeros de carta no monte Vivos do " + jogador2.getNomeJogador() + ": " + jogador2.baralho.ListaMonteVivosNaMesa.size());

            //copia o arraylist MonteVivos da Mesa para a mao do jogador
            for (int n = 0; n < jogador1.baralho.ListaMonteVivosNaMesa.size(); n++) {
                jogador1.baralho.ListaMonteVivosNaMao.add(n, jogador1.baralho.ListaMonteVivosNaMesa.get(n));
            }
            System.out.println("vivos na mao do " + jogador1.getNomeJogador() + ": " + jogador1.baralho.ListaMonteVivosNaMao.size());

            for (int n = 0; n < jogador2.baralho.ListaMonteVivosNaMesa.size(); n++) {
                jogador2.baralho.ListaMonteVivosNaMao.add(n, jogador2.baralho.ListaMonteVivosNaMesa.get(n));
            }
            System.out.println("vivos na mao do " + jogador2.getNomeJogador() + ": " + jogador2.baralho.ListaMonteVivosNaMao.size());

            //limpa a mesa (já que as cartas agora estão na mao).
            jogador1.baralho.ListaMonteVivosNaMesa.clear();
            jogador2.baralho.ListaMonteVivosNaMesa.clear();

            //ve o jogador que possui menos cartas para tornar possivel um numero maximo de jogadas. (o numero de jogadas será o numero de cartas do jogador com menor numero de cartas).
            if ((jogador1.baralho.ListaMonteVivosNaMao.size()) < (jogador2.baralho.ListaMonteVivosNaMao.size())) {
                jogadasmaximas = jogador1.baralho.ListaMonteVivosNaMao.size();
            } else {
                jogadasmaximas = jogador2.baralho.ListaMonteVivosNaMao.size();
            }

            //repeticao (o mesmo das rodadas anteriores... para a quantidade de jogadas na rodada)
            for (int y = 0; y < jogadasmaximas; y++) {
                System.out.println("\n" + jogador1.getNomeJogador());//nome do jogador1
                jogador1.baralho.MostraCartaMonteVivosMao();//mostra todas as cartas em maos do jogador1  

                //mostra a quantidade de cartas na mao
                System.out.println("Numeros de carta: " + jogador1.baralho.ListaMonteVivosNaMao.size());

                do {
                    System.out.print("Digite o numero da carta: ");
                    l = input.nextInt();
                } while ((l < 0) || (l > ((jogador1.baralho.ListaMonteVivosNaMao.size()) - 1))); //faz verificação para que o jogador não entre com um numero invalido de carta

                jogador1.escolherCartaMao(jogador1.baralho.ListaMonteVivosNaMao.get(l), l);//mesma coisa das rodadas anteriores

                //JOGADOR 2
                System.out.println("\n" + jogador2.getNomeJogador());//nome do jogador2
                jogador2.baralho.MostraCartaMonteVivosMao();//mostra todas as cartas em maos do jogador2
                System.out.println("Numero de cartas: " + jogador2.baralho.ListaMonteVivosNaMao.size());
                do {
                    System.out.print("Digite o numero da carta: ");
                    m = input.nextInt();
                } while ((m < 0) || (m > ((jogador2.baralho.ListaMonteVivosNaMao.size()) - 1)));
                jogador2.escolherCartaMao(jogador2.baralho.ListaMonteVivosNaMao.get(m), m);
                AnalisaMonteVivosNaMao(jogador1, l, jogador2, m);
            }
        }

        if (((jogador1.baralho.ListaMonteVivosNaMao.isEmpty()) && (jogador1.baralho.ListaMonteVivosNaMesa.isEmpty())) && ((jogador2.baralho.ListaMonteVivosNaMao.isEmpty()) && ((jogador2.baralho.ListaMonteVivosNaMesa.isEmpty())))) {
            System.out.print("Empataram!");
            Menu menuu = new Menu();
        } else {
            if (((jogador1.baralho.ListaMonteVivosNaMao.isEmpty()) && (jogador1.baralho.ListaMonteVivosNaMesa.isEmpty())) && ((jogador2.baralho.ListaMonteVivosNaMao.size() != 0) || (jogador2.baralho.ListaMonteVivosNaMesa.size()) != 0)) {
                System.out.print(jogador2.getNomeJogador() + " Venceu a partida!");
                Menu menuu = new Menu();
            } else {
                System.out.print(jogador1.getNomeJogador() + " Venceu a partida!");
                Menu menuu = new Menu();
            }
        }
    }//FIM CONSTRUTOR

    public void AnalisaMao(Jogador jogador1, int i, Jogador jogador2, int x) {
        Carta carta1 = jogador1.baralho.ListaNaMao.get(i);
        Carta carta2 = jogador2.baralho.ListaNaMao.get(x);
        
        int forca1 = jogador1.baralho.ListaNaMao.get(i).getForca();
        int forca2 = jogador2.baralho.ListaNaMao.get(x).getForca();
        
        System.out.println(jogador1.getNomeJogador() + " jogou a carta: " + carta1.getNomeCarta());
        System.out.println(jogador2.getNomeJogador() + " jogou a carta: " + carta2.getNomeCarta());
                
        if ((forca1) == (forca2)) {
            jogador1.RemoveVivoMao(i, carta1);
            jogador2.RemoveVivoMao(x, carta2);
            System.out.println("Jogada Empatou!");
        } else {
            if (((forca1 == 0) || (forca1 == 1)) && (forca2 == 0) || (forca2 == 1)) {
                ComparaMinasComAgenteMao(jogador1, jogador2, carta1, carta2, forca1, forca2, i, x);
            } else {
                if ((forca1 == 0) || (forca2== 0)) {
                    ComparaMinasComDemaisCartasMao(jogador1, jogador2, carta1, carta2, forca1, forca2, i, x);
                } else {
                    if ((((forca1 == 1) || (forca1 == 10)))&&(((forca2 == 1) || (forca2 == 10)))) {
                        ComparaAgenteComGeneralMao(jogador1, jogador2, carta1, carta2, forca1, forca2, i, x);
                    }else{
                        if(forca1 > forca2){
                            jogador1.AdicionaVivoMao(i, carta1);
                            jogador2.RemoveVivoMao(x, carta2);
                            System.out.println(jogador1.getNomeJogador() + " ganhou a jogada!");
                        }else{
                            jogador2.AdicionaVivoMao(x, carta2);
                            jogador1.RemoveVivoMao(i, carta1);
                            System.out.println(jogador2.getNomeJogador() + " ganhou a jogada!");
                        }
                    }
                }
            }
        }
    }

    public void AnalisaMesa1(Jogador jogador1, int i, Jogador jogador2, int x) {
        Carta carta1 = jogador1.baralho.ListaMesa1.get(i);
        Carta carta2 = jogador2.baralho.ListaMesa1.get(x);
        
        int forca1 = jogador1.baralho.ListaMesa1.get(i).getForca();
        int forca2 = jogador2.baralho.ListaMesa1.get(x).getForca();
        
        System.out.println(jogador1.getNomeJogador() + " jogou a carta: " + carta1.getNomeCarta());
        System.out.println(jogador2.getNomeJogador() + " jogou a carta: " + carta2.getNomeCarta());
        
        if ((forca1) == (forca2)) {
            jogador1.RemoveVivoMesa1(i, carta1);
            jogador2.RemoveVivoMesa1(x, carta2);
            System.out.println("Jogada Empatou!");
        } else {
            if (((forca1 == 0) || (forca1 == 1)) && (forca2 == 0) || (forca2 == 1)) {
                ComparaMinasComAgenteMesa1(jogador1, jogador2, carta1, carta2, forca1, forca2, i, x);
            } else {
                if ((forca1 == 0) || (forca2== 0)) {
                    ComparaMinasComDemaisCartasMesa1(jogador1, jogador2, carta1, carta2, forca1, forca2, i, x);
                } else {
                    if ((((forca1 == 1) || (forca1 == 10)))&&(((forca2 == 1) || (forca2 == 10)))) {
                        ComparaAgenteComGeneralMesa1(jogador1, jogador2, carta1, carta2, forca1, forca2, i, x);
                    }else{
                        if(forca1 > forca2){
                            jogador1.AdicionaVivoMesa1(i, carta1);
                            jogador2.RemoveVivoMesa1(x, carta2);
                            System.out.println(jogador1.getNomeJogador() + " ganhou a jogada!");
                        }else{
                            jogador2.AdicionaVivoMesa1(x, carta2);
                            jogador1.RemoveVivoMesa1(i, carta1);
                            System.out.println(jogador2.getNomeJogador() + " ganhou a jogada!");
                        }
                    }
                }
            }
        }
    }

    public void AnalisaMesa2(Jogador jogador1, int i, Jogador jogador2, int x) {
        Carta carta1 = jogador1.baralho.ListaMesa2.get(i);
        Carta carta2 = jogador2.baralho.ListaMesa2.get(x);
        
        int forca1 = jogador1.baralho.ListaMesa2.get(i).getForca();
        int forca2 = jogador2.baralho.ListaMesa2.get(x).getForca();
        
        System.out.println(jogador1.getNomeJogador() + " jogou a carta: " + carta1.getNomeCarta());
        System.out.println(jogador2.getNomeJogador() + " jogou a carta: " + carta2.getNomeCarta());
        
        if ((forca1) == (forca2)) {
            jogador1.RemoveVivoMesa2(i, carta1);
            jogador2.RemoveVivoMesa2(x, carta2);
            System.out.println("Jogada Empatou!");
        } else {
            if (((forca1 == 0) || (forca1 == 1)) && (forca2 == 0) || (forca2 == 1)) {
                ComparaMinasComAgenteMesa2(jogador1, jogador2, carta1, carta2, forca1, forca2, i, x);
            } else {
                if ((forca1 == 0) || (forca2== 0)) {
                    ComparaMinasComDemaisCartasMesa2(jogador1, jogador2, carta1, carta2, forca1, forca2, i, x);
                } else {
                    if ((((forca1 == 1) || (forca1 == 10)))&&(((forca2 == 1) || (forca2 == 10)))) {
                        ComparaAgenteComGeneralMesa2(jogador1, jogador2, carta1, carta2, forca1, forca2, i, x);
                    }else{
                        if(forca1 > forca2){
                            jogador1.AdicionaVivoMesa2(i, carta1);
                            jogador2.RemoveVivoMesa2(x, carta2);
                            System.out.println(jogador1.getNomeJogador() + " ganhou a jogada!");
                        }else{
                            jogador2.AdicionaVivoMesa2(x, carta2);
                            jogador1.RemoveVivoMesa2(i, carta1);
                            System.out.println(jogador2.getNomeJogador() + " ganhou a jogada!");
                        }
                    }
                }
            }
        }
    }

    public void AnalisaMonteVivosNaMao(Jogador jogador1, int i, Jogador jogador2, int x) {
        Carta carta1 = jogador1.baralho.ListaMonteVivosNaMao.get(i);
        Carta carta2 = jogador2.baralho.ListaMonteVivosNaMao.get(x);
        
        int forca1 = jogador1.baralho.ListaMonteVivosNaMao.get(i).getForca();
        int forca2 = jogador2.baralho.ListaMonteVivosNaMao.get(x).getForca();
        
        System.out.println(jogador1.getNomeJogador() + " jogou a carta: " + carta1.getNomeCarta());
        System.out.println(jogador2.getNomeJogador() + " jogou a carta: " + carta2.getNomeCarta());
        
        if ((forca1) == (forca2)) {
            jogador1.RemoveMonteVivosNaMao(i, carta1);
            jogador2.RemoveMonteVivosNaMao(x, carta2);
            System.out.println("Jogada Empatou!");
        } else {
            if (((forca1 == 0) || (forca1 == 1)) && (forca2 == 0) || (forca2 == 1)) {
                ComparaMinasComAgenteMonteVivos(jogador1, jogador2, carta1, carta2, forca1, forca2, i, x);
            } else {
                if ((forca1 == 0) || (forca2== 0)) {
                    ComparaMinasComDemaisCartasMonteVivos(jogador1, jogador2, carta1, carta2, forca1, forca2, i, x);
                } else {
                    if ((((forca1 == 1) || (forca1 == 10)))&&(((forca2 == 1) || (forca2 == 10)))) {
                        ComparaAgenteComGeneralMMonteVivos(jogador1, jogador2, carta1, carta2, forca1, forca2, i, x);
                    }else{
                        if(forca1 > forca2){
                            jogador1.AdicionaMonteVivosNaMao(i, carta1);
                            jogador2.RemoveMonteVivosNaMao(x, carta2);
                            System.out.println(jogador1.getNomeJogador() + " ganhou a jogada!");
                        }else{
                            jogador2.AdicionaMonteVivosNaMao(x, carta2);
                            jogador1.RemoveMonteVivosNaMao(i, carta1);
                            System.out.println(jogador2.getNomeJogador() + " ganhou a jogada!");
                        }
                    }
                }
            }
        }
    }

    private void ComparaMinasComAgenteMao(Jogador jogador1, Jogador jogador2, Carta carta1, Carta carta2, int forca1, int forca2, int i, int x) {
        if ((forca1 == 0) && (forca2 == 1)) {
            jogador1.RemoveVivoMao(i, carta1);
            jogador2.RemoveVivoMao(x, carta2);
            System.out.println(jogador1.getNomeJogador() + " ganhou a jogada!");
        } else {
            if ((forca1 == 1) && (forca2 == 0)) {
                jogador1.RemoveVivoMao(i, carta1);
                jogador2.RemoveVivoMao(x, carta2);
                System.out.println(jogador2.getNomeJogador() + " ganhou a jogada!");
            }
        }
    }

    private void ComparaMinasComDemaisCartasMao(Jogador jogador1, Jogador jogador2, Carta carta1, Carta carta2, int forca1, int forca2, int i, int x) {
        if ((forca1 == 0) && (forca2 == 3)) {
            jogador1.RemoveVivoMao(i, carta1);
            jogador2.AdicionaVivoMao(x, carta2);
            System.out.println(jogador2.getNomeJogador() + " ganhou a jogada!");
        } else {
            if ((forca1 == 0) && (forca2 != 0) && (forca2 != 1)) {
                jogador1.RemoveVivoMao(i, carta1);
                jogador2.RemoveVivoMao(x, carta2);
                System.out.println(jogador1.getNomeJogador() + " ganhou a jogada!");
            }
        }

        if ((forca1 == 3) && (forca2 == 0)) {
            jogador1.AdicionaVivoMao(i, carta1);
            jogador2.RemoveVivoMao(x, carta2);
            System.out.println(jogador1.getNomeJogador() + " ganhou a jogada!");
        } else {
            if ((forca2 == 0) && (forca1 != 0) && (forca1 != 1)) {
                jogador1.RemoveVivoMao(i, carta1);
                jogador2.RemoveVivoMao(x, carta2);
                System.out.println(jogador2.getNomeJogador() + " ganhou a jogada!");
            }
        }
    }

    private void ComparaAgenteComGeneralMao(Jogador jogador1, Jogador jogador2, Carta carta1, Carta carta2, int forca1, int forca2, int i, int x) {
        if ((forca1 == 10) && (forca2 == 1)) {
            jogador1.RemoveVivoMao(i, carta1);
            jogador2.AdicionaVivoMao(x, carta2);
            System.out.println(jogador2.getNomeJogador() + " ganhou a jogada!");
        } else {
            if ((forca1 == 1) && (forca2 == 10)) {
                jogador2.RemoveVivoMao(i, carta1);
                jogador1.AdicionaVivoMao(x, carta2);
                System.out.println(jogador1.getNomeJogador() + " ganhou a jogada!");
            }
        }
    }
    
    private void ComparaMinasComAgenteMesa1(Jogador jogador1, Jogador jogador2, Carta carta1, Carta carta2, int forca1, int forca2, int i, int x) {
        if ((forca1 == 0) && (forca2 == 1)) {
            jogador1.RemoveVivoMesa1(i, carta1);
            jogador2.RemoveVivoMesa1(x, carta2);
            System.out.println(jogador1.getNomeJogador() + " ganhou a jogada!");
        } else {
            if ((forca1 == 1) && (forca2 == 0)) {
                jogador1.RemoveVivoMesa1(i, carta1);
                jogador2.RemoveVivoMesa1(x, carta2);
                System.out.println(jogador2.getNomeJogador() + " ganhou a jogada!");
            }
        }
    }

    private void ComparaMinasComDemaisCartasMesa1(Jogador jogador1, Jogador jogador2, Carta carta1, Carta carta2, int forca1, int forca2, int i, int x) {
        if ((forca1 == 0) && (forca2 == 3)) {
            jogador1.RemoveVivoMesa1(i, carta1);
            jogador2.AdicionaVivoMesa1(x, carta2);
            System.out.println(jogador2.getNomeJogador() + " ganhou a jogada!");
        } else {
            if ((forca1 == 0) && (forca2 != 0) && (forca2 != 1)) {
                jogador1.RemoveVivoMesa1(i, carta1);
                jogador2.RemoveVivoMesa1(x, carta2);
                System.out.println(jogador1.getNomeJogador() + " ganhou a jogada!");
            }
        }

        if ((forca1 == 3) && (forca2 == 0)) {
            jogador1.AdicionaVivoMesa1(i, carta1);
            jogador2.RemoveVivoMesa1(x, carta2);
            System.out.println(jogador1.getNomeJogador() + " ganhou a jogada!");
        } else {
            if ((forca2 == 0) && (forca1 != 0) && (forca1 != 1)) {
                jogador1.RemoveVivoMesa1(i, carta1);
                jogador2.RemoveVivoMesa1(x, carta2);
                System.out.println(jogador2.getNomeJogador() + " ganhou a jogada!");
            }
        }
    }

    private void ComparaAgenteComGeneralMesa1(Jogador jogador1, Jogador jogador2, Carta carta1, Carta carta2, int forca1, int forca2, int i, int x) {
        if ((forca1 == 10) && (forca2 == 1)) {
            jogador1.RemoveVivoMesa1(i, carta1);
            jogador2.AdicionaVivoMesa1(x, carta2);
            System.out.println(jogador2.getNomeJogador() + " ganhou a jogada!");
        } else {
            if ((forca1 == 1) && (forca2 == 10)) {
                jogador2.RemoveVivoMesa1(i, carta1);
                jogador1.AdicionaVivoMesa1(x, carta2);
                System.out.println(jogador1.getNomeJogador() + " ganhou a jogada!");
            }
        }
    }
    
    private void ComparaMinasComAgenteMesa2(Jogador jogador1, Jogador jogador2, Carta carta1, Carta carta2, int forca1, int forca2, int i, int x) {
        if ((forca1 == 0) && (forca2 == 1)) {
            jogador1.RemoveVivoMesa2(i, carta1);
            jogador2.RemoveVivoMesa2(x, carta2);
            System.out.println(jogador1.getNomeJogador() + " ganhou a jogada!");
        } else {
            if ((forca1 == 1) && (forca2 == 0)) {
                jogador1.RemoveVivoMesa2(i, carta1);
                jogador2.RemoveVivoMesa2(x, carta2);
                System.out.println(jogador2.getNomeJogador() + " ganhou a jogada!");
            }
        }
    }

    private void ComparaMinasComDemaisCartasMesa2(Jogador jogador1, Jogador jogador2, Carta carta1, Carta carta2, int forca1, int forca2, int i, int x) {
        if ((forca1 == 0) && (forca2 == 3)) {
            jogador1.RemoveVivoMesa2(i, carta1);
            jogador2.AdicionaVivoMesa2(x, carta2);
            System.out.println(jogador2.getNomeJogador() + " ganhou a jogada!");
        } else {
            if ((forca1 == 0) && (forca2 != 0) && (forca2 != 1)) {
                jogador1.RemoveVivoMesa2(i, carta1);
                jogador2.RemoveVivoMesa2(x, carta2);
                System.out.println(jogador1.getNomeJogador() + " ganhou a jogada!");
            }
        }

        if ((forca1 == 3) && (forca2 == 0)) {
            jogador1.AdicionaVivoMesa2(i, carta1);
            jogador2.RemoveVivoMesa2(x, carta2);
            System.out.println(jogador1.getNomeJogador() + " ganhou a jogada!");
        } else {
            if ((forca2 == 0) && (forca1 != 0) && (forca1 != 1)) {
                jogador1.RemoveVivoMesa2(i, carta1);
                jogador2.RemoveVivoMesa2(x, carta2);
                System.out.println(jogador2.getNomeJogador() + " ganhou a jogada!");
            }
        }
    }

    private void ComparaAgenteComGeneralMesa2(Jogador jogador1, Jogador jogador2, Carta carta1, Carta carta2, int forca1, int forca2, int i, int x) {
        if ((forca1 == 10) && (forca2 == 1)) {
            jogador1.RemoveVivoMesa2(i, carta1);
            jogador2.AdicionaVivoMesa2(x, carta2);
            System.out.println(jogador2.getNomeJogador() + " ganhou a jogada!");
        } else {
            if ((forca1 == 1) && (forca2 == 10)) {
                jogador2.RemoveVivoMesa2(i, carta1);
                jogador1.AdicionaVivoMesa2(x, carta2);
                System.out.println(jogador1.getNomeJogador() + " ganhou a jogada!");
            }
        }
    }
    
    private void ComparaMinasComAgenteMonteVivos(Jogador jogador1, Jogador jogador2, Carta carta1, Carta carta2, int forca1, int forca2, int i, int x) {
        if ((forca1 == 0) && (forca2 == 1)) {
            jogador1.RemoveMonteVivosNaMao(i, carta1);
            jogador2.RemoveMonteVivosNaMao(x, carta2);
            System.out.println(jogador1.getNomeJogador() + " ganhou a jogada!");
        } else {
            if ((forca1 == 1) && (forca2 == 0)) {
                jogador1.RemoveMonteVivosNaMao(i, carta1);
                jogador2.RemoveMonteVivosNaMao(x, carta2);
                System.out.println(jogador2.getNomeJogador() + " ganhou a jogada!");
            }
        }
    }

    private void ComparaMinasComDemaisCartasMonteVivos(Jogador jogador1, Jogador jogador2, Carta carta1, Carta carta2, int forca1, int forca2, int i, int x) {
        if ((forca1 == 0) && (forca2 == 3)) {
            jogador1.RemoveMonteVivosNaMao(i, carta1);
            jogador2.AdicionaMonteVivosNaMao(x, carta2);
            System.out.println(jogador2.getNomeJogador() + " ganhou a jogada!");
        } else {
            if ((forca1 == 0) && (forca2 != 0) && (forca2 != 1)) {
                jogador1.RemoveMonteVivosNaMao(i, carta1);
                jogador2.RemoveMonteVivosNaMao(x, carta2);
                System.out.println(jogador1.getNomeJogador() + " ganhou a jogada!");
            }
        }

        if ((forca1 == 3) && (forca2 == 0)) {
            jogador1.AdicionaMonteVivosNaMao(i, carta1);
            jogador2.RemoveMonteVivosNaMao(x, carta2);
            System.out.println(jogador1.getNomeJogador() + " ganhou a jogada!");
        } else {
            if ((forca2 == 0) && (forca1 != 0) && (forca1 != 1)) {
                jogador1.RemoveMonteVivosNaMao(i, carta1);
                jogador2.RemoveMonteVivosNaMao(x, carta2);
                System.out.println(jogador2.getNomeJogador() + " ganhou a jogada!");
            }
        }
    }

    private void ComparaAgenteComGeneralMMonteVivos(Jogador jogador1, Jogador jogador2, Carta carta1, Carta carta2, int forca1, int forca2, int i, int x) {
        if ((forca1 == 10) && (forca2 == 1)) {
            jogador1.RemoveMonteVivosNaMao(i, carta1);
            jogador2.AdicionaMonteVivosNaMao(x, carta2);
            System.out.println(jogador2.getNomeJogador() + " ganhou a jogada!");
        } else {
            if ((forca1 == 1) && (forca2 == 10)) {
                jogador2.RemoveMonteVivosNaMao(i, carta1);
                jogador1.AdicionaMonteVivosNaMao(x, carta2);
                System.out.println(jogador1.getNomeJogador() + " ganhou a jogada!");
            }
        }
    }    
}//FIM CLASS RODADA
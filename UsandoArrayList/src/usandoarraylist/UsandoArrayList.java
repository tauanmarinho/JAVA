/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usandoarraylist;

import java.util.ArrayList;

/**
 *
 * @author Tauan
 */
public class UsandoArrayList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<String> cores = new ArrayList<String>();
        
        cores.add("azul");
        cores.add(0,"branco");//adiciona na primeira posicao
        cores.add("verde");
        cores.add(1,"vermelho");//adiciona na segunda posicao
        
        System.out.println(cores.toString());//
        System.out.println(cores.size());//tamanho
        System.out.println(cores.get(2));//acha pelo indice 2, terceiro
        System.out.println(cores.indexOf("branco"));//acha qual é o indice de branco
        
        cores.remove("branco");//remove a cor branca
        System.out.println(cores.toString());
        
        System.out.println("Tem a cor vermelha?"+cores.contains("vermelho"));//procura se tem a cor vermelha em cores
        
    }
}

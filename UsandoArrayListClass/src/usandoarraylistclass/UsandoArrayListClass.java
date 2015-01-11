/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usandoarraylistclass;


import java.util.ArrayList;

/**
 *
 * @author Tauan
 */
public class UsandoArrayListClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Pessoa> Lista = new ArrayList<Pessoa>();
        
        Pessoa p;
        
        p=new Pessoa();
        
        p.setNome("Tauan");
       p.setIdade(22);
       Lista.add(p);
       
        p=new Pessoa();
       
       p.setIdade(18);
       p.setNome("Mariana");
       Lista.add(p);
       
       for(int i=0;i<Lista.size();i++)
       {
       System.out.println(Lista.get(i).getNome());
       System.out.println(Lista.get(i).getIdade());
       }
        
        
        
    }
}

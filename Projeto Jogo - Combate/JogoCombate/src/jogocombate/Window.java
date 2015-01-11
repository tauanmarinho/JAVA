/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogocombate;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JButton;
/**
 *
 * @author Tauan
 */
public class Window extends JFrame
{
        
public Window(){
    //title
        super("Combate");    
   //size
        setSize(640,480);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        Center();
        Inicio();
        Regras();
        Sair();
        Creditos();
    }
public void Center(){
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    
    int screenWidth = screenSize.width - this.getWidth();
    int screenHeight = screenSize.height - this.getHeight();
    
    setLocation(screenWidth/2, screenHeight/2);
    }

    public void Inicio(){
        JButton inicio=new JButton("Inicio");  
        setLayout(null);
        inicio.setBounds(245,50,150,50);
        add(inicio);
    }
    public void Creditos(){
        JButton creditos=new JButton("Creditos");  
        setLayout(null);
        creditos.setBounds(245,150,150,50);
        add(creditos);
        
    }
    
    public void Sair(){
        JButton sair=new JButton("Sair");  
        setLayout(null);
        sair.setBounds(245,350,150,50);
        add(sair);
    }
    
    public void Regras(){
        JButton regras=new JButton("Regras");  
        setLayout(null);
        regras.setBounds(245,250,150,50);
        add(regras);
    }
}

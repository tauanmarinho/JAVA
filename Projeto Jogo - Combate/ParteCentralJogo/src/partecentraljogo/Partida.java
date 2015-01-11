package partecentraljogo;


public class Partida {

private int NumeroRodada;
    public Partida (int NumeroRodada) {
        this.NumeroRodada=NumeroRodada;
        NumeroRodada=0;
        
    }



    
    public void setRodada(int i){ NumeroRodada=i+1;}
    
    public int getRodada(){return NumeroRodada;}

}


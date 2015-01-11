package partecentraljogo;

public class Carta {

    private String nomeCarta;
    private int forca;

    public Carta(String enomeCarta, int eforca) {
        nomeCarta = enomeCarta;
        forca = eforca;
    }

    public String getNomeCarta() {
        return nomeCarta;
    }

    public void setNomeCarta(String val) {
        this.nomeCarta = val;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int val) {
        this.forca = val;
    }
}

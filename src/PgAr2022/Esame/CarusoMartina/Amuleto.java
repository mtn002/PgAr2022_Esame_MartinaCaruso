package PgAr2022.Esame.CarusoMartina;

public class Amuleto extends Oggetto{
    private String effetto;

    public Amuleto(String nome, String effetto, String tipo, String descrizione) {
        super (nome, descrizione, tipo);
        this.effetto = effetto;
    }
    public String getEffetto() {
        return effetto;
    }

    public void sceltaEffetto(int n) {
        switch (n) {
            case 0:
                effetto = "Doppio Passo";
                break;
            case 1:
                effetto = "Invisibilità";
                break;
            case 2:
                effetto = "Forza e Resistenza";
                break;
        }
    }

}

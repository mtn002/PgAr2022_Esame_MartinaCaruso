package PgAr2022.Esame.CarusoMartina;

public class Arma extends Oggetto{
    private int potenza;

    public int getPotenza() {
        return potenza;
    }

    public void setPotenza(int potenza) {
        this.potenza = potenza;
    }

    public Arma (String nome, String descrizione, String tipo, int potenza) {
        super (nome, descrizione, tipo);
        this.potenza = potenza;

    }
}

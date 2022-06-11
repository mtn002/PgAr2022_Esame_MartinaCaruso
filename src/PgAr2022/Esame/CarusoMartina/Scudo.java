package PgAr2022.Esame.CarusoMartina;

public class Scudo extends Oggetto{
    private int vita;



    public Scudo(int vita, String nome, String descrizione, String tipo ) {
        super(nome, descrizione, tipo);
        this.vita = vita;
    }

    public int getVita() {
        return vita;
    }

    public void setVita(int vita) {
        this.vita = vita;
    }
}

package PgAr2022.Esame.CarusoMartina;

import java.util.Random;

public class Oggetto {
    private String nome;
    private String descrizione;
    private int potenza;

    public Oggetto() {}

    public Oggetto(String nome, String descrizione, String tipo) {
        super();
        this.nome = nome;
        this.descrizione = descrizione;
        this.tipo = tipo;
    }

    private String tipo;
    private int vita;

    public int getVita() {
        return vita;
    }

    public void setVita(int vita) {
        this.vita = vita;
    }

    public String getTipo() {
        return tipo;
    }

    public void setPotenza(int potenza) {
        this.potenza = potenza;
    }

    public int getPotenza() {
        return potenza;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void creaOggetto(){
        Random rand = new Random();
        setPotenza(rand.nextInt(35, 55));
        setVita(5);
    }



}

package PgAr2022.Esame.CarusoMartina;

import java.util.Random;

public class Personaggio {
    private String nome;
    private int vita;
    private int attacco = 5;
    private int difesa=5;

    private Arma inManodx = new Arma("", "","", 0);

    private Arma arma = new Arma("","","Arma", 0);

    public Personaggio(String nome, int vita) {
        this.nome = nome;
        this.vita = vita;
    }





    public String getNome() {
        return nome;
    }





    public void setNome(String nome) {
        this.nome = nome;
    }





    public int getVita() {
        return vita;
    }





    public void setVita(int vita) {
        this.vita = vita;
    }





    public int getAttacco() {
        return attacco;
    }





    public void setAttacco(int attacco) {
        this.attacco = attacco;
    }





    public int getDifesa() {
        return difesa;
    }





    public void setDifesa(int difesa) {
        this.difesa = difesa;
    }





    public Arma getInManodx() {
        return inManodx;
    }





    public void setInManodx(Arma inManodx) {
        this.inManodx = inManodx;
    }








    public Arma getArma() {
        return arma;
    }





    public void setArma(Arma arma) {
        this.arma = arma;
    }





    public double calcoloDanno (){
        Random rand = new Random();
        double modificatore = 1;
        if (rand.nextInt(0,1000)<76)
            modificatore = 1.5;
        return (((2*inManodx.getPotenza()*attacco)/(25*difesa))+2)*modificatore;

    }

}

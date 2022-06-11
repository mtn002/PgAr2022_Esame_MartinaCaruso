package PgAr2022.Esame.CarusoMartina;

import java.util.Random;

public class Mostro extends Personaggio{


    public Mostro (String nome, int vita) {
        super (nome, vita);
    }

    public void generaMostro(){
        Random rand = new Random();
        setVita (rand.nextInt(15, 25));
        getInManodx().setPotenza(rand.nextInt(35, 55));
        setNome ("Mostro base");
    }



    public void generaBoss(){
        Random rand = new Random();
        setVita(30);
        setAttacco(7);
        getInManodx().setPotenza(rand.nextInt(35, 55));
        setNome("Mini boss");
    }

    public void generaBossFinale(){
        setVita(40);
        setAttacco(10);
        setVita(10);
        setInManodx(new Arma("","","", 70));
        setNome ("SuperBoss");
    }

}

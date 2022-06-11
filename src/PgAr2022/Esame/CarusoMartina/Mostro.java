package PgAr2022.Esame.CarusoMartina;

import java.util.Random;

public class Mostro extends Personaggio{


    public void generaMostro(){
        Random rand = new Random();
        setVita (rand.nextInt(15, 25));
        getInMano().setPotenza(rand.nextInt(35, 55));
    }

    public void generaBoss(){
        Random rand = new Random();
        setVita(30);
        setAttacco(7);
        getInMano().setPotenza(rand.nextInt(35, 55));
    }

    public void generaBossFinale(){
        setVita(40);
        setAttacco(10);
        setVita(10);
        setInManodx(new Arma());
        getInMano().setPotenza(70);
    }

}

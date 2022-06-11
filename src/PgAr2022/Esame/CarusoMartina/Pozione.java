package PgAr2022.Esame.CarusoMartina;

public class Pozione extends Oggetto{
    private static final int VITAMAX = 20;
    private static final int RIPRISTINO = VITAMAX/2;
    public void ripristinaVita (Eroe e){
        if (e.getVita()+RIPRISTINO <=20)
            e.setVita(e.getVita()+RIPRISTINO);
        else System.out.println("Non è possibile prendere la pozione");
    }
}

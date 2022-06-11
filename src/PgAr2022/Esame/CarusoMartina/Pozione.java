package PgAr2022.Esame.CarusoMartina;

public class Pozione extends Oggetto{
    private static final int VITAMAX = 20;
    private static final int RIPRISTINO = VITAMAX/2;
    public int ripristinaVita (int  vita){
        if (vita+RIPRISTINO <=20)
            vita+= +RIPRISTINO;
        else System.out.println("Non Ã¨ possibile prendere la pozione");
        return vita;
    }


}

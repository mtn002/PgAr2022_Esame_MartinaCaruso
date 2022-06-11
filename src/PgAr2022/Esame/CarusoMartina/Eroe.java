package PgAr2022.Esame.CarusoMartina;

import java.util.LinkedList;

public class Eroe extends Personaggio{
    private LinkedList<Oggetto> oggettiRaccolti = new LinkedList<>();

    public LinkedList<Oggetto> getOggettiRaccolti() {
        return oggettiRaccolti;
    }
}

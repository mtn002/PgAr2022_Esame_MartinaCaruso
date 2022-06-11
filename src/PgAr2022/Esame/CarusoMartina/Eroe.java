package PgAr2022.Esame.CarusoMartina;

import java.util.ArrayList;
import java.util.LinkedList;

public class Eroe extends Personaggio{

    private Arma arma;
    private Scudo scudo;
    private LinkedList<Oggetto> amuletiEpozioni = new LinkedList<>();
    private Oggetto inManosx;

    private Amuleto amuleto = new Amuleto();

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public Scudo getScudo() {
        return scudo;
    }

    public void setScudo(Scudo scudo) {
        this.scudo = scudo;
    }

    public LinkedList<Oggetto> getAmuletiEpozioni() {
        return amuletiEpozioni;
    }

    public void setAmuletiEpozioni(LinkedList<Oggetto> amuletiEpozioni) {
        this.amuletiEpozioni = amuletiEpozioni;
    }

    public Amuleto getAmuleto() {
        return amuleto;
    }

    public void setAmuleto(Amuleto amuleto) {
        this.amuleto = amuleto;
    }

    public void setChiavi(LinkedList<Boolean> chiavi) {
        this.chiavi = chiavi;
    }

    private LinkedList <Boolean> chiavi = new LinkedList<>();

    public void setInManosx(Oggetto inManosx) {
        this.inManosx = inManosx;
    }

    public Oggetto getInManosx() {
        return inManosx;
    }

    public LinkedList<Boolean> getChiavi() {
        return chiavi;
    }

    public LinkedList<Oggetto> getOggettiRaccolti() {
        return amuletiEpozioni;
    }

    public char move (){
        char scelta;


        System.out.println("[W]. Avanti");
        System.out.println("[S]. Indietro");
        System.out.println("[D]. Destra");
        System.out.println("[A]. Sinistra");

        do {
            scelta = InputDati.leggiChar("Scegli la tua mossa: ");

        }while (scelta!='W'&&scelta!='A'&&scelta!='D'&&scelta!='S');
        return scelta;

    }

    public void ingaggia (int scelta){
        switch (scelta){
            case 1:
                if (!arma.equals(null)) {
                    setInManodx(arma);
                    return;
                }
                break;
            case 2:
                if (!scudo.equals(null)) {
                    setInManosx(scudo);
                    return;
                }
                break;
            case 3:
                for (int i=0; i< amuletiEpozioni.size(); i++){
                    if (amuletiEpozioni.get(i).getTipo().equals("Pozione")){
                        Pozione p = new Pozione();
                        p = (Pozione) amuletiEpozioni.get(i);
                        setVita(p.ripristinaVita(getVita()));
                        return;
                    }
                }
                break;
            case 4:
                String nome = InputDati.leggiStringaNonVuota("Inserire il nome dell'amuleto che si vuole ingaggiare");
                for (int i=0; i< amuletiEpozioni.size(); i++){
                    if (amuletiEpozioni.get(i).getNome().equals(nome)) {
                        this.amuleto = (Amuleto) amuletiEpozioni.get(i);
                        return;
                    }

                }
                break;

        }
        System.out.println("Oggetto inesistente!");

    }
}

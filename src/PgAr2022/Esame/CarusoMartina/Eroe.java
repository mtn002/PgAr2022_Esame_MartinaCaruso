package PgAr2022.Esame.CarusoMartina;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Eroe extends Personaggio{

    private Arma arma = new Arma("","","",0);
    private Scudo scudo = new Scudo(0,"","","Scudo");
    private LinkedList<Oggetto> amuletiEpozioni = new LinkedList<>();

    private Scudo inManosx = new Scudo(0, "", "","Scudo");

    public Eroe(String nome, int vita) {
        super (nome, vita);
    }

    public void setInManosx(Scudo inManosx) {
        this.inManosx = inManosx;
    }

    private Amuleto amuleto = new Amuleto("","","","Amuleto");

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



    public Oggetto getInManosx() {
        return inManosx;
    }

    public LinkedList<Boolean> getChiavi() {
        return chiavi;
    }

    public LinkedList<Oggetto> getOggettiRaccolti() {
        return amuletiEpozioni;
    }

    public String move (){
        String scelta;
        Scanner in = new Scanner (System.in);


        System.out.println("[W]. Avanti");
        System.out.println("[S]. Indietro");
        System.out.println("[D]. Destra");
        System.out.println("[A]. Sinistra");

        do {
            scelta = in.nextLine();

        }while ((!scelta.equals("W"))&&(!scelta.equals("A"))&&(!scelta.equals("D"))&&(!scelta.equals("S")));
        return scelta;

    }

    public void ingaggia (int scelta){
        switch (scelta){
            case 1:
                if (!arma.getNome().equals("")) {
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

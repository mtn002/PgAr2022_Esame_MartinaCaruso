package PgAr2022.Esame.CarusoMartina;
import java.util.*;

public class Menu {
    private Eroe eroe = new Eroe("", 0);
    Scanner in = new Scanner (System.in);
    private Battaglia scontro;
    private Character[][] mappaLiv1 = {{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},};
    private Character[][] mappaLiv2 = {{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},};
    private Character[][] mappaLiv3 = {{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},};
    private Character[][] mappaliv4 = {{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},};
    private Character[][] mappaliv5 = {{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},};
    public void menu(){
        System.out.println("Inserisci il tuo nome giocatore: ");

        eroe.setNome(in.next());

        eroe.setVita(20);
        int livello = 1;
        riempiMappa(mappaLiv1, livello, mappaLiv2);

        stampaMappa(mappaLiv1);





        if (!livello (mappaLiv1, livello).equals("0")) {
            livello++;
            riempiMappa(mappaLiv2, livello, mappaLiv1);
            if (!livello(mappaLiv2, livello).equals("0")){
                livello++;
                riempiMappa(mappaLiv3, livello, mappaLiv2);
                if (!livello(mappaLiv3, livello).equals("0")){
                    livello++;
                    riempiMappa(mappaliv4, livello, mappaLiv3);
                    if (!livello(mappaliv4, livello).equals("0")){
                        livello++;
                        riempiMappa(mappaliv5, livello, mappaliv4);
                        livello(mappaliv5, livello);

                    }
                }
            }
        }










    }

    public void stampaMappa (Character[][] mappa){
        for (int i=0; i< 10; i++){
            for (int j=0; j< 10; j++){
                System.out.print(mappa[i][j]);
                System.out.print("");
            }
            System.out.println();
        }
    }


    public void riempiMappa (Character[][] mappa, int piano, Character[][]mappaPrecedente){
        Random rand = new Random();




        int riga = 0;
        int colonna = 0;
        if (piano == 1) {

            colonna = rand.nextInt(0, 9);
            mappa[9][colonna] = 'O';
            colonna = rand.nextInt(0,9);
            mappa[0][colonna] = 'T';
        }

        if (piano ==5){
            do{
                riga = rand.nextInt(0,9);
                colonna = rand.nextInt(0,9);
            }while (mappa[riga][colonna]!= ' ');
            mappa[riga][colonna] = 'D';
        }

        if (piano!=1){
            for (int i=0; i< 9; i++)
                for (int j=0; j< 9; j++){
                    if (mappaPrecedente[i][j] == 'T'){
                        mappa[i][j] = 't';
                        if (j<5)
                            mappa[i][j+1] ='O';
                        else mappa[i][j-1] = 'O';
                    }

                }
        }



        if (piano ==5) {
            for (int i=0; i< 2; i++) {
                do{
                    riga = rand.nextInt(0,9);
                    colonna =  rand.nextInt(0,9);
                }while(mappa[riga][colonna]!= ' ');

                mappa[riga][colonna]='B';
            }
        }
        //generazione casuale delle posizioni dei muri
        for (int i=0; i< 16; i++) {
            riga = rand.nextInt(0, 9);
            colonna = rand.nextInt(0, 9);
            //se lo spazio scelto casualmente Ã¨ vuoto allora puÃ² essere inserito il muro, altrimenti bisognerÃ  fare un altro ciclo
            if (mappa[riga][colonna] == ' ')
                mappa[riga][colonna] = '#';
            else i--;
        }
        //generazione casuale delle posizioni dei mostri
        if (piano!=5) {
            for (int i=0; i< 2; i++) {
                riga = rand.nextInt(0, 9);
                colonna = rand.nextInt(0, 9);
                if (mappa[riga][colonna] == ' ')
                    mappa[riga][colonna] = 'M';
                else i--;
            }
        }

        //generazione casuale delle posizioni delle casse
        for (int i=0; i<2; i++){
            riga = rand.nextInt(0,9);
            colonna = rand.nextInt(0,9);
            if (mappa[riga][colonna] == ' ')
                mappa[riga][colonna]='C';
            else i--;
        }

        for (int i=0; i <10; i++){
            for (int j=0; j< 10; j++){
                if (mappa[i][j] == ' ')
                    mappa[i][j] = '.';
            }
        }


    }

    public Oggetto apriChest(){
        char o;
        Random rand = new Random();
        int indice = 0;
        indice = rand.nextInt(1,100);
        if (indice<20)
            o = 'P';
        else if (indice <55)
            o = 'S';
        else if (indice <95)
            o = 'A';
        else o = 'a';
        switch (o){
            case 'P':
                Pozione p = new Pozione();
                p.creaOggetto();
                return p;
            case 'S':
                Scudo s = new Scudo(5, in.next(), in.next(), "Scudo");
                s.creaOggetto();
                return s;
            case 'A':
                Arma a = new Arma(in.next(), in.next(), "Arma", rand.nextInt(35, 55));
                a.creaOggetto();
                return a;
            case 'a':
                Amuleto am = new Amuleto (in.next(), "", "Amuleto", in.next());
                am.sceltaEffetto(rand.nextInt(2));
                return am;
        }
        //non ritornerÃ  mai null
        return null;
    }

    public int turno(Character[][]mappa, int riga, int colonna, int livello, boolean invisibilita){
        int x=0, y=0;


        switch (eroe.move()) {
            case "W":
                if (riga + 1 != 10 && mappa[riga + 1][colonna] != '#') {
                    x = riga + 1;
                    y = colonna;
                }
                else System.out.println("Mossa non valida!");
                break;
            case "S":
                if (riga - 1 != 0 && mappa[riga - 1][colonna] != '#') {
                    x = riga - 1;
                    y = colonna;
                } else System.out.println("Mossa non valida!");
                break;
            case "D":
                if (colonna + 1 != 10 && mappa[riga][colonna + 1] != '#') {
                    x = riga;
                    y = colonna + 1;
                } else System.out.println("Mossa non valida!");
                break;

            case "A":
                if (colonna - 1 != 0 && mappa[riga][colonna - 1] != '#') {
                    x = riga;
                    y = colonna - 1;
                } else System.out.println("Mossa non valida");
                break;
        }
        //in questo blocca si valuta la posizione dell'eroe
        {
            if (mappa[x][y] == 'C') {
                do {
                } while (InputDati.leggiChar("Premere E per aprire la chest: ") != 'E');
                Oggetto o = apriChest();
                o.toString();

                Scanner in = new Scanner (System.in);
                if (o.getTipo().equals(eroe.getScudo().getTipo())||o.getTipo().equals(eroe.getArma().getTipo())){
                    System.out.println("Purtroppo hai giÃ  un arma di quel tipo");
                    System.out.println("[1]. Sostituisci");
                    System.out.println("[0]. Lasciala lÃ¬");
                    if (in.nextInt() == 1) {
                        if (o.getTipo().equals(eroe.getScudo()))
                            eroe.setScudo((Scudo)o);
                        else eroe.setArma((Arma)o);
                    }
                }
                else if (!o.getTipo().equals("Amuleto")&&!o.getTipo().equals("Pozione")) {
                    if (o.getTipo().equals("Scudo"))
                        eroe.setScudo((Scudo) o);
                    else eroe.setArma((Arma) o);
                }
                else{
                    int scelta = 0;
                    System.out.println("[1]. Metti nell'inventario");
                    System.out.println("[2]. Lascialo lÃ¬");
                    scelta = in.nextInt();
                    if (scelta == 1)
                        eroe.getOggettiRaccolti().add(o);
                    mappa[x][y] = 'O';
                    return 0;
                }

            } else if (mappa[x][y] == 'M') {
                if (invisibilita == false) {
                    Mostro m = new Mostro("", 0);
                    m.generaMostro();
                    scontro.lotta(eroe, m, 1);
                    if (scontro.vinto(eroe, m) == 1) {
                        return 0;
                    }
                    return -1;
                }
                else {
                    mappa[riga][colonna] = 'M';
                    mappa[x][y] = 'O';
                    return 0;
                }
            } else if (mappa[x][y] == 'B') {
                if (invisibilita == false) {
                    Mostro m = new Mostro("",0);
                    m.generaBoss();
                    scontro.lotta(eroe, m, 1);
                    if (scontro.vinto(eroe, m) == 1) {
                        System.out.println("Hai ottenuto la tua chiave, ora puoi accedere al livello " + livello);
                        eroe.getChiavi().add(true);
                        return 0;
                    }
                    return -1;
                }
                else {
                    mappa[riga][colonna] ='B';
                    mappa[x][y]='O';
                    return 0;
                }
            } else if (mappa[x][y] == 'K') {
                System.out.println("Complimenti hai salvato la principessa Kibo");
                return 2;
            } else if (mappa[x][y] == 'T') {
                if (eroe.getChiavi().get(livello-1).equals(true))
                    return 3;
                return 0;
            }
            else if (mappa[x][y].equals('D')){
                Mostro m = new Mostro("",0);
                m.generaBossFinale();
                scontro.lotta(eroe, m, 1);
                if (scontro.vinto(eroe, m)==1) {
                    return 5;
                }
                else return -1;
            }
        }

        return 0;
    }

    public int vediMenu(){
        Scanner in = new Scanner (System.in);
        int scelta = 0;
        System.out.println("[0]. Abbandona la partita");
        System.out.println("[1]. Statistiche personaggio");
        System.out.println("[2]. Inventario");
        System.out.println("[3]. Chiudi menu");
        System.out.println("[4]. Gioca");
        scelta = in.nextInt();

        return scelta;

    }

    public String livello (Character mappa[][], int livello){
        int riga=0, colonna=0;
        for (int i=0; i< 10;i++){
            for (int j=0; j< 10; j++){
                if (mappa[i][j]== 'O'){
                    colonna = j;
                    riga = i;
                }

            }
        }

        int turno = 0, contatore =0;
        String scelta = "";
        String scelta2="";
        while (turno == 0 && !scelta.equals("0")) {
            System.out.println("Menu");
            System.out.println("[M] Apri menu");
            System.out.println("[G] Per giocare direttamente");
            scelta = in.nextLine();
            //scelta = InputDati.leggiStringaNonVuota("Scegli cosa fare: ");
            if (scelta.equals("M")){

                scelta2 = String.valueOf(vediMenu());

                if (scelta2.equals("1"))
                    eroe.toString();
                else if (scelta2.equals("2")){
                    for (int i=0; i< eroe.getOggettiRaccolti().size(); i++){
                        System.out.println(eroe.getOggettiRaccolti().get(i).toString());
                    }
                    System.out.println("[1]. Prendi un arma");
                    System.out.println("[2]. Prendi uno scudo");
                    System.out.println("[3]. Prendi una pozione");
                    System.out.println("[4]. Prendi un amuleto");
                    System.out.println("[0]. Esci dall'inventario");
                    eroe.ingaggia(in.nextInt());
                }


            }

            if (!scelta2.equals("0")){
                boolean check = false;
                if (!eroe.getAmuleto().getNome().equals("")){
                    check = true;
                    contatore++;
                }
                if (eroe.getAmuleto().equals("Doppio passo")){
                    for (int i=0; i< 2; i++) {

                        turno = turno(mappa, riga, colonna, livello, check);
                        stampaMappa(mappa);
                        eroe.toString();
                    }
                }
                if (contatore ==3){
                    if (eroe.getAmuleto().getEffetto().equals("Forza e resistenza")){
                        eroe.setDifesa(eroe.getDifesa()/2);
                        eroe.setAttacco(eroe.getAttacco()/4);
                        check = false;
                    }

                    for (int i=0; i< eroe.getAmuletiEpozioni().size(); i++) {
                        if (eroe.getAmuletiEpozioni().get(i).getNome().equals(eroe.getAmuleto())) {
                            eroe.setAmuleto(new Amuleto ("", "","",""));
                            eroe.getAmuletiEpozioni().remove(i);
                        }
                    }
                }
                else {
                    turno = turno(mappa, riga, colonna, livello, check);
                    if(turno==5) {
                        System.out.println("Complimenti, sconfiggendo il SuperBoss hai salvato la principessa e finito il gioco");
                        scelta="0";
                    }

                }
            }
        }
        return scelta;

    }



}



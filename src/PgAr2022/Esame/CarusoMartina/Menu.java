package PgAr2022.Esame.CarusoMartina;
import java.util.*;

public class Menu {
    private Eroe eroe;
    private Battaglia scontro;
    private Character[][] mappaLiv1;
    private Character[][] mappaLiv2;
    private Character[][] mappaLiv3;
    private Character[][] mappaliv4;
    private Character[][] mappaliv5;
    public void menu(){
        eroe.setNome(InputDati.leggiStringa("Inserisci il tuo nome giocatore: "));
        eroe.setVita(20);
        int livello = 1;
        riempiMappa(mappaLiv1, livello, new Character [10][10]);

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
                            //gestire partita finale
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
        System.out.println("priva");



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


        do{
            riga = rand.nextInt(0,9);
            colonna =  rand.nextInt(0,9);
        }while(mappa[riga][colonna]!= ' ');

        mappa[riga][colonna] = 'T';

        do{
            riga = rand.nextInt(0,9);
            colonna =  rand.nextInt(0,9);
        }while(mappa[riga][colonna]!= ' ');

        mappa[riga][colonna]='B';

        //generazione casuale delle posizioni dei muri
        for (int i=0; i< 16; i++) {
            riga = rand.nextInt(0, 9);
            colonna = rand.nextInt(0, 9);
            //se lo spazio scelto casualmente è vuoto allora può essere inserito il muro, altrimenti bisognerà fare un altro ciclo
            if (mappa[riga][colonna] == ' ')
                mappa[riga][colonna] = '#';
            else i--;
        }
        //generazione casuale delle posizioni dei mostri
        for (int i=0; i< 2; i++) {
            riga = rand.nextInt(0, 9);
            colonna = rand.nextInt(0, 9);
            if (mappa[riga][colonna] == ' ')
                mappa[riga][colonna] = 'M';
            else i--;
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
        if (indice<25)
            o = 'P';
        else if (indice <60)
            o = 'S';
        else o = 'A';

        switch (o){
            case 'P':
                Pozione p = new Pozione();
                p.creaOggetto();
                return p;
            case 'S':
                Scudo s = new Scudo();
                s.creaOggetto();
                return s;
            case 'A':
                Arma a = new Arma();
                a.creaOggetto();
                return a;
        }
            //non ritornerà mai null
            return null;
        }

        public int turno(Character[][]mappa, int riga, int colonna, int livello, boolean invisibilità){
            int x=0, y=0;


            switch (eroe.move()) {
                case 'W':
                    if (riga + 1 != 10 && mappa[riga + 1][colonna] != '#') {
                        x = riga + 1;
                        y = colonna;
                    }
                    else System.out.println("Mossa non valida!");
                    break;
                case 'S':
                    if (riga - 1 != 0 && mappa[riga - 1][colonna] != '#') {
                        x = riga - 1;
                        y = colonna;
                    } else System.out.println("Mossa non valida!");
                    break;
                case 'D':
                    if (colonna + 1 != 10 && mappa[riga][colonna + 1] != '#') {
                        x = riga;
                        y = colonna + 1;
                    } else System.out.println("Mossa non valida!");
                    break;

                case 'A':
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


                    if (o.getTipo().equals(eroe.getScudo().getTipo())||o.getTipo().equals(eroe.getArma().getTipo())){
                        System.out.println("Purtroppo hai già un arma di quel tipo");
                        System.out.println("[1]. Sostituisci");
                        System.out.println("[0]. Lasciala lì");
                        if (InputDati.leggiIntero("Scegli cosa fare: ", 0, 1) ==1){
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
                    scelta = InputDati.leggiIntero("Premere 1 per aggiungerlo all'inventario, 0 per lasciarlo lì: ", 0, 1);
                    if (scelta == 1)
                        eroe.getOggettiRaccolti().add(o);
                    mappa[x][y] = 'O';
                    return 0;
                    }

                } else if (mappa[x][y] == 'M') {
                    if (invisibilità == false) {
                        Mostro m = new Mostro();
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
                    if (invisibilità == false) {
                        Mostro m = new Mostro();
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
                    Mostro m = new Mostro();
                    m.generaBossFinale();
                }
            }

        return 0;
    }

    public int vediMenu(){
        int scelta = 0;
        System.out.println("[0]. Abbandona la partita");
        System.out.println("[1]. Statistiche personaggio");
        System.out.println("[2]. Inventario");
        System.out.println("[3]. Chiudi menu");
        System.out.println("[4]. Gioca");
        scelta = InputDati.leggiIntero("Selezioni un'opzione: ", 0, 4);
        return scelta;

    }

    public String livello (Character mappa[][], int livello){
        int riga=0, colonna=0;
        for (int i=0; i< 9;i++){
            for (int j=0; j< 9; j++){
                if (mappa[i][j]== 'O'){
                    colonna = j;
                    riga = i;
                }

            }
        }
        int turno = 0, contatore =0;
        String scelta = "";
        while (turno == 0 && !scelta.equals("0")) {
            System.out.println("[M] Apri menu");
            System.out.println("[G] Per giocare direttamente");
            scelta = InputDati.leggiStringaNonVuota("Scegli cosa fare: ");
            if (scelta.equals("M")){
                scelta = String.valueOf(vediMenu());
                if (scelta.equals("1"))
                    eroe.toString();
                else if (scelta.equals("2")){
                    for (int i=0; i< eroe.getOggettiRaccolti().size(); i++){
                        System.out.println(eroe.getOggettiRaccolti().get(i).toString());
                    }
                    System.out.println("[1]. Prendi un arma");
                    System.out.println("[2]. Prendi uno scudo");
                    System.out.println("[3]. Prendi una pozione");
                    System.out.println("[4]. Prendi un amuleto");
                    System.out.println("[0]. Esci dall'inventario");
                    eroe.ingaggia(InputDati.leggiIntero("", 0, 4));
                }


            }

            if (!scelta.equals("0")){
                boolean check = false;
                if (!eroe.getAmuleto().equals(null)){
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
                    }

                    for (int i=0; i< eroe.getAmuletiEpozioni().size(); i++) {
                        if (eroe.getAmuletiEpozioni().get(i).getNome().equals(eroe.getAmuleto())) {
                            eroe.setAmuleto(null);
                            eroe.getAmuletiEpozioni().remove(i);
                        }
                    }
                }
            }
        }
        return scelta;

    }



    }



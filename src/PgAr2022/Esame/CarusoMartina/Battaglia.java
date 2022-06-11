package PgAr2022.Esame.CarusoMartina;

public class Battaglia {
    public int vinto (Eroe e, Mostro m){
        if (e.getVita()<=0)
            return -1;
        else if (m.getVita()<=0)
            return +1;
        else return 0;
    }

    public void lotta (Eroe e, Mostro m, int primo){
        if (primo ==1) {
            do {
                m.setVita(m.getVita() - (int) e.calcoloDanno());
                System.out.println(m.getNome()+ " ha ricevuto danni da "+e.getNome()+ "; ora ha: "+ m.getVita()+ " di vita!");
                if (e.getInManosx().getTipo().equals("Scudo")) {
                    if (e.getInManosx().getVita() > 0) {
                        e.getInManosx().setVita(e.getInManosx().getVita() - (int) m.calcoloDanno());
                        System.out.println(e.getInManosx().getNome() + " ha ricevuto danni da " + m.getNome() + "; ora ha: " + e.getInManosx().getVita() + " di vita!");
                    }
                }
                else {
                    e.setVita(e.getVita() - (int) m.calcoloDanno());
                    System.out.println(e.getNome()+ " ha ricevuto danni da "+m.getNome()+ "; ora ha: "+ e.getVita()+ " di vita!");

                }




            }while (vinto (e, m)==0);
        }
        else {
            do {

                if (e.getInManosx().getTipo().equals("Scudo")) {
                    if (e.getInManosx().getVita() > 0) {
                        e.getInManosx().setVita(e.getInManosx().getVita() - (int) m.calcoloDanno());
                        System.out.println(e.getInManosx().getNome() + " ha ricevuto danni da " + m.getNome() + "; ora ha: " + e.getInManosx().getVita() + " di vita!");
                    }
                }
                else {
                    e.setVita(e.getVita() - (int) m.calcoloDanno());
                    System.out.println(e.getNome()+ " ha ricevuto danni da "+m.getNome()+ "; ora ha: "+ e.getVita()+ " di vita!");

                }

                m.setVita(m.getVita() - (int) e.calcoloDanno());
                System.out.println(m.getNome()+ " ha ricevuto danni da "+e.getNome()+ "; ora ha: "+ m.getVita()+ " di vita!");



            }while (vinto (e, m)==0);
        }
        if (vinto(e, m) == 1)
            System.out.println("Hai vinto complimenti!");
        else System.out.println("Hai perso mi spiace!");
    }
}

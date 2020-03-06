package afrikantahti;

class Hevosenkenka extends Kiekko{

    public int annaArvo(){
        return 0;
    }

    public String annaToiminto(){
        return "Löysit Hevosenkengän!";
    }

    public String annaNimi(){
        return "Hevosenkenkä";
    }

    /**
     * Metodi tarkistaa ensin, onko toinen pelaaja jo löytänyt Afrikan tähden. Jos on,
     * metodi kutsuu pelaajan metodia "asetaHevosenkenka", joka muuttaa totuusarvon "onkoHevosenkenka" arvoksi true
     * @param vuorossa Vuorossa oleva pelaaja
     * @param eiVuorossa Toinen pelaaja
     */
    public void muutaStatus(Pelaaja pelaaja){
        pelaaja.asetaHevosenkenka();
        
    }
}
package afrikantahti;

class Afrikantahti extends Kiekko{

    public int annaArvo(){
        return 0;
    }

    public String annaToiminto(){
        return "Löysit Afrikan tähden! Palaa lähtökaupunkiin voittaaksesi pelin.";
    }

    public String annaNimi(){
        return "Afrikan tähti";
    }
    /**
     * Afrikan tähden löytyessä, tämä metodi kutsuu pelaajan metodia "asetaAfrikantahti" ja muuttaa totuusarvon
     * "onkoAfrikantahti" arvoksi true
     * @param Pelaaja p
     */
    public void muutaStatus(Pelaaja p){
        p.asetaAfrikantahti();
    }
}
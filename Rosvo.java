package afrikantahti;


class Rosvo extends Kiekko{

    public int annaArvo(){
        return 0;
    }

    public String annaToiminto(){
        return "Rosvo hyökkäsi kimppuusi! Menetit kaikki rahasi.";
    }

    public String annaNimi(){
        return "Rosvo";
    }

    /**
     * Kun pelaaja avaa kiekon ja sieltä tulee Rosvo, menettää pelaaja kaikki rahansa. Rosvo-luokan metodi "vieRahat"
     * kutsuu Pelaaja-luokan metodia "poistaRahat"
     * @param p Vuorossa oleva pelaaja
     */
    public void vieRahat(Pelaaja p){
        p.poistaRahat();
    }
}
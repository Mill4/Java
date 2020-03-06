package afrikantahti;

import afrikantahti.Jalokivi;
import afrikantahti.*;


class Topaasi extends Kiekko implements Jalokivi{
    public final int voitto = 300;

    /**
     * Topaasi on Afrikan tähti pelin jalokivi, joka on arvoltaan 300 pelirahaa.
     */
    public Topaasi(){

    }
    public int annaArvo(){
        return voitto;
    }
    public String annaToiminto(){
        return "Löysit Topaasin! Voitit 300 pelirahaa.";
    }

    public String annaNimi(){
        return "Topaasi";
    }

    public void lunastaVoitto(Pelaaja p){
        p.lisaaRahaa(this.voitto);
    }
}
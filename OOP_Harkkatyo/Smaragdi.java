package afrikantahti;

import afrikantahti.Jalokivi;

class Smaragdi extends Kiekko implements Jalokivi{
    public final int voitto = 600;

    /**
     * Smaragdi on Afrikan tähti pelin jalokivi, joka on arvoltaan 600 pelirahaa.
     */
    public Smaragdi(){

    }

    public int annaArvo(){
        return voitto;
    }

    public String annaToiminto(){
        return "Löysit Smaragdin! Voitit 600 pelirahaa";
    }

    public String annaNimi(){
        return "Smaragdi";
    }

    public void lunastaVoitto(Pelaaja p){
        p.lisaaRahaa(this.voitto);
    }
}
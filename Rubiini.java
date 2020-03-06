package afrikantahti;

import afrikantahti.Jalokivi;

class Rubiini extends Kiekko implements Jalokivi{
    public final int voitto = 1000;

    /**
     * Rubiini on Afrikan tähti pelin jalokivi, joka on arvoltaan 1000 pelirahaa.
     */
    public Rubiini(){

    }

    public int annaArvo(){
        return voitto;
    }

    public String annaToiminto(){
        return "Löysit Rubiinin! Voitit 1000 pelirahaa.";
    }

    public String annaNimi(){
        return "Rubiini";
    }

    public void lunastaVoitto(Pelaaja p){
        p.lisaaRahaa(this.voitto);
    }
}
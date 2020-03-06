package afrikantahti;

class Pelaaja{
    private int rahaTilanne;
    private int sijainti;
    private boolean hevosenkenka;
    private boolean afrikantahti;
    String nimi;

    /**
     * Kun uusi pelaaja-olio luodaan, rahatilanteeksi asetetaan 300. Arfikan tähti- ja hevosenkenkästatukset
     * ovat aluksi false.
     */
    public Pelaaja(String nimi){
        rahaTilanne = 300;
        this.afrikantahti = false;
        this.hevosenkenka = false;
        this.nimi = nimi;
    }
    
    /**
     * Metodi asetaa pelaajan aloitussijainnin aloituskaupungin mukaan. Voi olla joko Cairo (sijainti 1) 
     * tai Tanger (sijainti 78)
     * @param luku 1=Cairo, 2=Tanger
     */
    public void asetaAloituskaupunki(int luku){
        if(luku == 1){
            sijainti = 1;
        }
        else if(luku == 2){
            sijainti = 78;
        }
        
    }

    /**
     * Palauttaa pelaajan nimen, esim. "Pelaaja 1"
     * @return Pelaajan nimi/nimike
     */
    public String annaNimi(){
        return nimi;
    }


    /**
     * Metodi muuttaa pelaajan sijaintia pelilaudalla positiiviseen suuntaan, eli myötäpäivään.
     * @param askel lisätään pelaajan sijaintiin
     */
    public void siirraEteenpain(int askel){
        if(sijainti + askel > 86){
            sijainti = (sijainti + askel) - 86;
        }
        
        else{
            sijainti = sijainti + askel;
        }
    }

    /**
     * Metodi muuttaa pelaajan sijaintia pelilaudalla negatiiviseen suuntaan, eli vastapäivään.
     * @param askel vähennetään pelaajan sijainnista
     */
    public void siirraTaaksepain(int askel){
        if(sijainti - askel < 1){
            sijainti = (sijainti - askel) + 86;
        }
        else{
            sijainti = sijainti - askel;
        }
        
    }

    /**
     * Palauttaa pelaajan sijainnin pelilaudalla kokonaislukuna (peliruudun numero 1-86)
     * @return kokonaisluku, peliruudun numero
     */
    public int annaSijainti(){
        return sijainti;
    }

    /**
     * Palauttaa pelaajan rahatilanteen
     * @return Pelaajan rahat
     */
    public int annaRahat(){
        return rahaTilanne;
    }

    /**
     * Lisää pelaajalle pelirahaa, kun pelaaja löytää jalokiven tai vastaavasti vähentää rahaa, jos pelaaja
     * avaa esimerkiksi kiekon.
     * @param raha kokonaisluku
     */
    public void lisaaRahaa(int raha){
        rahaTilanne = rahaTilanne + raha;
    }

    /**
     * Poistaa pelaajan kaikki rahat, kun rosvo on hyökännyt pelaajan kimppuun
     */
    public void poistaRahat(){
        rahaTilanne = 0;
    }

    /**
     * Kun pelaaja löytää Afrikan tähden, metodi muuttaa totuusarvon "onkoAfrikantahti" arvoksi true
     */
    public void asetaAfrikantahti(){
        this.afrikantahti = true;
    }

    /**
     * Palauttaa pelaajan Afrikan tähti statuksen
     * @return true, jos pelaajalla on Afrikan tähti, false muulloin
     */
    public boolean onkoAfrikantahti(){
        return afrikantahti;
    }

    /**
     * Jos toinen pelaaja on löytänyt Afrikan tähden ja vuorossa oleva pelaaja löytää Hevosenkengän,
     * muutetaan totuusarvon "onkoHevosenkenka" arvoksi true
     */
    public void asetaHevosenkenka(){
        this.hevosenkenka = true;
    }

    /**
     * Palauttaa pelaajan Hevosenkenkä statuksen
     * @return true, jos pelaajalla on Hevosenkenkä, false muulloin
     */
    public boolean onkoHevosenkenka(){
        return hevosenkenka;
    }


}
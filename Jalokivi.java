package afrikantahti;

import afrikantahti.*;


public interface Jalokivi{

    /**
     * Pelaajan löytäessä jalokiven, hän saa siitä rahaa. Metodi kutsuu pelaajan metodia "lisaaRahaa"
     * joka lisää pelaajalle pelirahaa
     * @param Pelaaja
     */
    void lunastaVoitto(Pelaaja p);
}
package afrikantahti;

abstract class Kiekko{

    /**
     * Metodi palauttaa kiekon rahallisen arvon, voi myös olla nolla
     * @return Kokonaisluku, raha-arvo
     */
    abstract int annaArvo();

    /**
     * Metodi palauttaa merkkijonon joka kertoo mitä pelaaja löysi avatessaan kiekon
     * @return Merkkijono - kiekon toiminto
     */
    abstract String annaToiminto();

    /**
     * Metodi palauttaa kiekon nimen
     * @return Merkkijono - kiekon nimi
     */
    abstract String annaNimi();
    
}
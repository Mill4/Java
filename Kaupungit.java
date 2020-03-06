package afrikantahti;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.*;

class Kaupungit{
    ArrayList<Kiekko> kiekot;
    public final ArrayList<String> kaupungit; 

    /**
     * Kun uusi Kaupungit-olio luodaan, se luo 20 kiekkoa jotka tallenetaan ArrayList listaan.
     * Erilaisia kiekkoja ovat: Afrikan tähti (1), rubiini (2), smaragdi (3), topaasi (4), 
     * rosvo (5) tai hevosenkenkä (5). Pelilauta sisältää siten myös 20 kaupunkia (+2 aloituskaupunkia), jotka
     * alustetaan konstruktorissa. 
     */
    public Kaupungit(){
        
        Kiekko afrikantahti = new Afrikantahti();
        Kiekko rubiini = new Rubiini();
        Kiekko smaragdi = new Smaragdi();
        Kiekko topaasi = new Topaasi();
        Kiekko rosvo = new Rosvo();
        Kiekko hevosenkenka = new Hevosenkenka();
        kiekot = new ArrayList<Kiekko>(Arrays.asList(afrikantahti, rubiini, rubiini, smaragdi, smaragdi, smaragdi, topaasi,
        topaasi, topaasi, topaasi, rosvo, rosvo, rosvo, rosvo, rosvo, hevosenkenka, hevosenkenka, hevosenkenka, hevosenkenka, hevosenkenka));

        kaupungit = new ArrayList<>(Arrays.asList("Egypt", "Suakin", "Dar-Fur", "Cape Guardafui", "Daressalam", 
            "Ocompa", "Mozambique", "Dragon Mountain", "Capetown", "Whalefish Bay", 
            "Congo", "Kandjama", "Ain-Galaka", "Sahara", "Timbuktu", "Sierra Leione", 
            "Cape Verde", "Morocco", "Tunis", "Tripoli"));

        
    }


    /** 
     * Metodi ensin sekoittaa kiekot satunnaiseen järjestykseen, jonka jälkeen kaupungit
     * ja kiekot asetetaan HashMap listaan, missä Kaupungin nimi toimii avaimena.
     * @return HashMap<String, Kiekko> Lista kaupungeista, joissa arvoina kiekot
     */
    public HashMap<String, Kiekko> annaPeliSetti(){
        HashMap<String, Kiekko> peliSetti = new HashMap<>();
        Collections.shuffle(kiekot);
        for(int i = 0; i<kaupungit.size(); i++){
            peliSetti.put(kaupungit.get(i), kiekot.get(i));
        }
        return peliSetti;
    }

    
    /** 
     * Metodi palauttaa listan Kiekoista
     * @return ArrayList<Kiekko> Afrikan tähti- pelin kiekot, 20 kpl
     */
    public ArrayList<Kiekko> annaKiekot(){
        return kiekot;
    }

    
    /** 
     * Metodi palauttaa listan kaupungeistä
     * @return ArrayList<String> Afrikan tähti- pelin kaupungit
     */
    public ArrayList<String> annaKaupungit(){
        return kaupungit;
    }
    public String annaKaupunki(int sijainti){
        switch(sijainti){
            case 1: return "Cairo";
            case 4: return "Egypt";
            case 7: return "Suakin";
            case 10: return "Dar-Fur";
            case 15: return "Cape Guardafui";
            case 19: return "Daressalam";
            case 22: return "Ocomba";
            case 25: return "Mozambique";
            case 30: return "Dragon Mountain";
            case 36: return "Capetown";
            case 40: return "Whalefish Bay";
            case 43: return "Congo";
            case 48: return "Kandjama";
            case 54: return "Ain-Galaka";
            case 58: return "Sahara";
            case 62: return "Timbuktu";
            case 65: return "Sierra Leione";
            case 70: return "Cape Verde";
            case 75: return "Morocco";
            case 78: return "Tanger";
            case 81: return "Tunis";
            case 84: return "Tripoli";
            default: return "";

        }
    }



    
}
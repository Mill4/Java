package afrikantahti;


import afrikantahti.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.*;

class Pelilauta{
    private Noppa noppa;
    private Kaupungit kaupungit;
    private Pelaaja p1;
    private Pelaaja p2;
    public Pelaaja voittaja;
    public final int peliruudut = 86;
    private HashMap<String, Kiekko> kaupunkiKiekko;
    private ArrayList<String> kokoPelilauta;

    /**
     * Pelilauta-luokka alustaa Afrikan tähti pelin luomalla uuden nopan (silmäluku 6),
     * sekä luomalla Kaupungit, joihin on arvottu pelikiekot. Pelilauta-luokan konstruktori saa parametrikseen
     * kaksi pelaajaa.
     * Pelilauta-luokka sisältää myös kaikki 86 peliruutua Arraylist muodossa.
     */
    public Pelilauta(Pelaaja p1, Pelaaja p2){
        noppa = new Noppa(6);
        kaupungit = new Kaupungit();
        this.p1 = p1;
        this.p2 = p2;
        voittaja = null;
        kaupunkiKiekko = kaupungit.annaPeliSetti();
        kokoPelilauta = new ArrayList<>(Arrays.asList("Cairo", "Tyhjä", "Tyhjä", "Egypt", "Tyhjä", "Tyhjä", "Suakin", 
        "Tyhjä", "Tyhjä", "Dar-Fur", "Tyhjä", "Tyhjä", "Tyhjä", "Tyhjä", "Cape Guardafui","Tyhjä", "Tyhjä", "Tyhjä", "Daressalam", 
        "Tyhjä", "Tyhjä", "Ocompa", "Tyhjä", "Tyhjä", "Mozambique", "Tyhjä", "Tyhjä", "Tyhjä", "Tyhjä",
        "Dragon Mountain", "Tyhjä", "Tyhjä","Tyhjä", "Tyhjä","Tyhjä", "Capetown", "Tyhjä", "Tyhjä", "Tyhjä",
        "Whalefish Bay","Tyhjä", "Tyhjä", "Congo","Tyhjä", "Tyhjä","Tyhjä", "Tyhjä", "Kandjama","Tyhjä", "Tyhjä","Tyhjä", "Tyhjä", "Tyhjä",
        "Ain-Galaka", "Tyhjä", "Tyhjä", "Tyhjä", "Sahara", "Tyhjä", "Tyhjä","Tyhjä", "Timbuktu", "Tyhjä", "Tyhjä", 
        "Sierra Leione", "Tyhjä", "Tyhjä", "Tyhjä", "Tyhjä", "Cape Verde", "Tyhjä", "Tyhjä", "Tyhjä", "Tyhjä", 
        "Morocco", "Tyhjä", "Tyhjä", "Tanger", "Tyhjä", "Tyhjä", "Tunis", "Tyhjä", "Tyhjä", "Tripoli", "Tyhjä", "Tyhjä"));

    }

    /**
     * Palauttaa Afrikan tähti pelin nopan. Nopalla on metodi, "heitaNoppa"
     * @return Noppa, silmäluku 6
     */
    public Noppa annaNoppa(){
        return noppa;
    }

    /**
     * 
     * @return Pelaaja 1
     */
    public Pelaaja annaPelaaja1(){
        return p1;
    }

    /**
     * 
     * @return Pelaaja 2
     */
    public Pelaaja annaPelaaja2(){
        return p2;
    }

    public Pelaaja annaVoittaja(){
        return voittaja;
    }

    /**
     * Metodi tarkistaa onko peli loppunut, eli onko jompikumpi pelaajista voittanut pelin.
     * Pelin voittaa, jos on löytänyt Afrikan tähden ja palaa jompaan kumpaan lähtökaupunkiin ennen hevosenkengän löytänyttä
     * pelaajaa. Hevosenkengän löytämisesta on hyötyä vasta, kun Afrikan tähti on löytynyt ja hevosenkengän löytänyt pelaaja tulee
     * päästä lähtökaupunkiin ennen toista pelaajaa. 
     * @param tahti Pelaaja, joka on löytänyt Afrikan tähden
     * @param eiTahti Pelaaja, jolla ei ole Afrikan tähteä
     * @return true, jos peli on ratkennut, muute false
     */
    public boolean onkoPeliLoppu(Pelaaja tahti, Pelaaja eiTahti){
        int sijaintiT = tahti.annaSijainti();
        int sijaintiH = eiTahti.annaSijainti(); 
        if(sijaintiT == 1 || sijaintiT == 78){
            System.out.println(tahti.annaNimi() + " voitti pelin!");
            voittaja = tahti;
            return true;
        }
        boolean onkoKenka = eiTahti.onkoHevosenkenka();
        if(onkoKenka){
            if(sijaintiH == 1 || sijaintiH == 78){
                System.out.println(eiTahti.annaNimi() + " voitti pelin!");
                voittaja = eiTahti;
                return true;
            }
        }
        return false;
    }

    /**
     * Sijaintitoiminto-metodi palauttaa ne kaksi kaupunkia, joiden välissä pelaaja tällä hetkellä on.
     * Tämän avulla osataan siirtää pelaajaa oikeaan suuntaan.
     * @param sijainti Pelaajan sijainti pelilaudalla
     * @return Kaksi kaupunkia ArrayList muodossa
     */
    public ArrayList<String> sijaintiToiminto(int sijainti) {
        ArrayList<String> uusi = new ArrayList<String>();
        switch (sijainti) {
            case 1: 
            uusi.add("Egypt");
            uusi.add("Tripoli");
            return uusi;
            case 2: case 3:
            uusi.add("Egypt");
            uusi.add("Cairo");
            return uusi;
            case 4:
            uusi.add("Suakin");
            uusi.add("Cairo");
            return uusi;
            case 5: case 6:
            uusi.add("Suakin");
            uusi.add("Egypt");
            return uusi;
            case 7:
            uusi.add("Dar-Fur");
            uusi.add("Egypt");
            return uusi;
            case 8: case 9:
            uusi.add("Dar-Fur");
            uusi.add("Suakin");
            return uusi;
            case 10:
            uusi.add("Cape Guardafui");
            uusi.add("Suakin");
            return uusi;
            case 11: case 12: case 13: case 14:
            uusi.add("Cape Guardafui");
            uusi.add("Dar-Fur");
            return uusi;
            case 15:
            uusi.add("Daressamal");
            uusi.add("Dar-Fur");
            return uusi;
            case 16: case 17: case 18:
            uusi.add("Daressamal");
            uusi.add("Cape Guardafui");
            return uusi;
            case 19:
            uusi.add("Ocomba");
            uusi.add("Cape Guardafui");
            return uusi;
            case 20: case 21:
            uusi.add("Ocomba");
            uusi.add("Daressamal");
            return uusi;
            case 22:
            uusi.add("Mozambique");
            uusi.add("Daressamal");
            return uusi;
            case 23: case 24:
            uusi.add("Mozambique");
            uusi.add("Ocomba");
            return uusi;
            case 25:
            uusi.add("Dragon Mountain");
            uusi.add("Ocomba");
            return uusi;
            case 26: case 27: case 28: case 29:
            uusi.add("Dragon Mountain");
            uusi.add("Mozambique");
            return uusi;
            case 30:
            uusi.add("Capetown");
            uusi.add("Mozambique");
            return uusi;
            case 31: case 32: case 33: case 34: case 35:
            uusi.add("Capetown");
            uusi.add("Dragon Mountain");
            return uusi;
            case 36:
            uusi.add("Whalefish Bay");
            uusi.add("Dragon Mountain");
            return uusi;
            case 37: case 38: case 39:
            uusi.add("Whalefish Bay");
            uusi.add("Capetown");
            return uusi;
            case 40:
            uusi.add("Congo");
            uusi.add("Capetown");
            return uusi;
            case 41: case 42:
            uusi.add("Congo");
            uusi.add("Whalefish Bay");
            return uusi;
            case 43:
            uusi.add("Kandjama");
            uusi.add("Whalefish Bay");
            return uusi;
            case 44: case 45: case 46: case 47:
            uusi.add("Kandjama");
            uusi.add("Congo");
            return uusi;
            case 48: 
            uusi.add("Ain-Galaka");
            uusi.add("Congo");
            return uusi;
            case 49: case 50: case 51: case 52: case 53:
            uusi.add("Ain-Galaka");
            uusi.add("Kandjama");
            return uusi;
            case 54:
            uusi.add("Sahara");
            uusi.add("Kandjama");
            return uusi;
            case 55: case 56: case 57:
            uusi.add("Sahara");
            uusi.add("Ain-Galaka");
            return uusi;
            case 58:
            uusi.add("Timbuktu");
            uusi.add("Ain-Galaka");
            return uusi;
            case 59: case 60: case 61:
            uusi.add("Timbuktu");
            uusi.add("Sahara");
            return uusi;
            case 62:
            uusi.add("Sierra Leione");
            uusi.add("Sahara");
            return uusi;
            case 63: case 64:
            uusi.add("Sierra Leione");
            uusi.add("Timbuktu");
            return uusi;
            case 65:
            uusi.add("Cape Verde");
            uusi.add("Timbuktu");
            return uusi;
            case 66: case 67: case 68: case 69:
            uusi.add("Cape Verde");
            uusi.add("Sierra Leione");
            return uusi;
            case 70:
            uusi.add("Morocco");
            uusi.add("Sierra Leione");
            return uusi;
            case 71: case 72: case 73: case 74:
            uusi.add("Morocco");
            uusi.add("Cape Verde");
            return uusi;
            case 75:
            uusi.add("Tanger");
            uusi.add("Cape Verde");
            return uusi;
            case 76: case 77:
            uusi.add("Tanger");
            uusi.add("Morocco");
            return uusi;
            case 78:
            uusi.add("Tunis");
            uusi.add("Morocco");
            return uusi;
            case 79: case 80:
            uusi.add("Tunis");
            uusi.add("Tanger");
            return uusi;
            case 81:
            uusi.add("Tripoli");
            uusi.add("Tanger");
            return uusi;
            case 82: case 83:
            uusi.add("Tripoli");
            uusi.add("Tunis");
            return uusi;
            case 84:
            uusi.add("Cairo");
            uusi.add("Tunis");
            return uusi;
            case 85: case 86:
            uusi.add("Cairo");
            uusi.add("Tripoli");
            return uusi;

            default: return uusi;
        }
    }

    /**
     * Metodi kutsuu Kaupungit-luokan metodia "annaKaupunki", joka palauttaa kaupungin nimen, jossa pelaaja tällä hetkellä on.
     * Jos pelaaja ei ole kaupungissa, metodi palauttaa tyhjän merkkijonon.
     */
    public String mikaKaupunki(int sijainti){
        return kaupungit.annaKaupunki(sijainti);
    }

    /**
     * Pelaaja voi liikkua pelilaudalla haluamansa tavalla. Vaihtoehtoja ovat joko nopan silmäluku tai halutessaan tämä voi myös
     * pysähtyä seuraavaan kaupunkiin. Tämä metodi tarkistaa paljonko on matkaa siihen kaupunkiin, jonka pelaaja on valinnut suunnaksi. 
     * @param sijainti Pelaajan sijainti
     * @return Kuinka paljon matkaa pelaajan haluamaan kaupunkiin.
     */
    public int matkaaKaupunkiinEdessa(int sijainti){
        if(sijainti == 84){
            return 3;
        }
        if(sijainti == 85){
            return 2;
        }
        if(sijainti == 86){
            return 1;
        }
        int laskuri = 1;
        for(int i = sijainti; i<kokoPelilauta.size(); i++){
            String s = kokoPelilauta.get(i);
            if(s.equals("Tyhjä")){
                laskuri++;
            }
            else{
                return laskuri;
            }
        }
        return 0;
    }

    /**
     * Pelaaja voi liikkua pelilaudalla haluamansa tavalla. Vaihtoehtoja ovat joko nopan silmäluku tai halutessaan tämä voi myös
     * pysähtyä seuraavaan kaupunkiin. Tämä metodi tarkistaa paljonko on matkaa siihen kaupunkiin, jonka pelaaja on valinnut suunnaksi. 
     * @param sijainti Pelaajan sijainti
     * @return Kuinka paljon matkaa pelaajan haluamaan kaupunkiin.
     */
    public int matkaaKaupunkiinTakana(int sijainti){
        if(sijainti == 3){
            return 2;
        }
        if(sijainti == 2){
            return 1;
        }
        if(sijainti == 1){
            return 3;
        }
        int laskuri = 1;
        int indeksi = sijainti-2;
        for(int i = indeksi; i<kokoPelilauta.size(); i--){
            String s = kokoPelilauta.get(i);
            if(s.equals("Tyhjä")){
                laskuri++;
            }
            else{
                return laskuri;
            }
        }
        return 0;
    }

    /**
     * Kaupunkeihin on asetettu kiekkoja. Metodi onkoAarre-tarkistaa on kyseisessä kaupungissa kiekkoa, jota ei ole vielä avattu
     * @param kaupunki Kaupunki, jossa pelaaja on.
     * @return true, jos kaupungissa on avaamaton aarre, muuten false.
     */
    public boolean onkoAarre(String kaupunki){
        Kiekko k = kaupunkiKiekko.get(kaupunki);
        if(k==null){
            return false;
        }
        return true;
    }

    /**
     * Jos kaupungissa on avaamaton kiekko, tämä metodi avaa sen hakemalla Hashmap-listasta. Kiekkoa ei voi avata uudelleen.
     * @param kaupunki Kaupunki, johon kiekko on asetettu
     * @return Kiekko, joka kaupungissa oli
     */
    public Kiekko avaaKiekko(String kaupunki){
        Kiekko k = kaupunkiKiekko.get(kaupunki);
        kaupunkiKiekko.replace(kaupunki, null);
        return k;
    }

    /**
     * Kun pelaaja on avannut kiekon, metodi kiekonToiminto- suorittaa toiminnon jokaisen kiekon kohdalla erikseen. 
     * Erilaisia kiekkoja ovat: Afrikan tähti, Hevosenkenkä, Rubiini, Smaragdi, Topaasi ja Rosvo. 
     * Pelaaja voi esimerkiksi tämän toiminnon aikana menettää kaikki rahansa tai saada jalokivistä rahaa. 
     * @param k Pelaajan löytämä kiekko
     * @param p Vuorossa oleva pelaaja
     */
    public void kiekonToiminto(Kiekko k, Pelaaja p){
        String pelaaja = p.annaNimi();
        if(k instanceof Rosvo){
            Rosvo rosvo = (Rosvo)k;
            System.out.println(rosvo.annaToiminto() + "\n");
            rosvo.vieRahat(p);
        }
        else if(k instanceof Rubiini){
            Rubiini rubiini = (Rubiini)k;
            System.out.println(rubiini.annaToiminto() + "\n");
            rubiini.lunastaVoitto(p);
        }
        else if(k instanceof Smaragdi){
            Smaragdi smaragdi = (Smaragdi)k;
            System.out.println(smaragdi.annaToiminto() + "\n");
            smaragdi.lunastaVoitto(p);
        }
        else if(k instanceof Topaasi){
            Topaasi topaasi = (Topaasi)k;
            System.out.println(topaasi.annaToiminto() + "\n");
            topaasi.lunastaVoitto(p);
        }
        else if(k instanceof Hevosenkenka){
            Hevosenkenka h = (Hevosenkenka)k;
            System.out.println(h.annaToiminto());
            if(pelaaja.equals("Pelaaja 1")){
                boolean afrikantahti = p2.onkoAfrikantahti();
                if(afrikantahti == false){
                    System.out.println("Afrikan tähteä ei ole vielä löytynyt. Tätä hevosenkenkää ei voi käyttää." + "\n");
                }
                if(afrikantahti){
                    System.out.println("Palaa lähtökaupunkiin voittaaksesi pelin!" + "\n");
                    h.muutaStatus(p1);
                }
            }
            else if(pelaaja.equals("Pelaaja 2")){
                boolean afrikantahti = p1.onkoAfrikantahti();
                if(afrikantahti == false){
                    System.out.println("Afrikan tähteä ei ole vielä löytynyt. Tätä hevosenkenkää ei voi käyttää." + "\n");
                }
                else if(afrikantahti){
                    System.out.println("Palaa lähtökaupunkiin voittaaksesi pelin!" + "\n");
                    h.muutaStatus(p2);
                }
            }

        }

        else if(k instanceof Afrikantahti){
            Afrikantahti tahti = (Afrikantahti) k;
            System.out.println(tahti.annaToiminto());
            tahti.muutaStatus(p);
        }
    }





}
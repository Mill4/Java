package afrikantahti;
import java.util.*;
import afrikantahti.*; 

class Lukija{
    private Scanner s;
    private Pelilauta pelilauta;
    private Pelaaja p1;
    private Pelaaja p2;
    private Noppa noppa;

    /**
     * Lukija-luokka huolehtii käyttäjän syötteen lukemisesta erilaisissa pelitilanteissa. Peli on komentorivipohjainen
     * ja käyttäjä pystyy pelaamaan peliä antamalla numeroita annettujen vaihtoehtojen perusteella. 
     * @param p Pelilauta
     * @param p1 pelaaja 1
     * @param p2 pelaaja 2
     */
    public Lukija(Pelilauta p, Pelaaja p1, Pelaaja p2){
        s= new Scanner(System.in);
        this.pelilauta = p;
        this.p1 = p1;
        this.p2 = p2;
        noppa = pelilauta.annaNoppa();
    }

    /**
     * Metodissa käyttäjältä kysytään, mistä pelaajat haluavat aloittaa ja asettaa pelaajien sijainnit sen mukaisesti.
     * @param p Pelaaja
     */
    public void aloitusKaupunki(Pelaaja p){
        System.out.println(p.annaNimi() + ", mistä kaupungista haluat aloittaa?");
        System.out.println("1. Cairo");
        System.out.println("2. Tanger");
        int luku = 0;
        while(true){
            try{
                luku = Integer.parseInt(s.nextLine());
                if(luku == 1 || luku == 2){
                    break;
                }
                else{
                    System.out.println("Syötä luku 1 tai 2");
                }
            }
            catch(Exception e){
                System.out.println("Syötä kokonaisluku");
            }
        }
        p.asetaAloituskaupunki(luku);
    }
    
    /**
     * Metodi kutsun nopan metodia "heitaNoppaa" ja arpoo pelaajalle satunnaisen kokonaisluvun väliltä 1-6. 
     * Sen jälkeen ohjelma kysyy käyttäjältä, mitä tämä haluaa tehdä. Pelaaja voi nopan heitolla mm. liikkua, avata 
     * aarteen tai jäädä paikalleen. Metodi kutsuu toista metodia "vuoronAlku" joka palauttaa pelaajan sijainnin toimintojen jälkeen.
     * @param p vuorossa oleva pelaaja
     * @return Pelaaja sijainti nopan heiton jälkeen
     */
    public int nopanheitto(Pelaaja p){
        int silmaluku = noppa.heitaNoppa();
        System.out.println("Mitä haluat tehdä?");
        System.out.println("1. Etene nopan silmäluvun verran");
        System.out.println("2. Etene seuraavaan kaupunkiin");
        System.out.println("3. Jää paikalleen");
        if(silmaluku > 3){
            System.out.println("4. Lunasta aarre");
        }
        int valinta = 0;
        while(true){
            try{
                valinta = Integer.parseInt(s.nextLine());
                if(valinta == 4 && silmaluku <4){
                    System.out.println("Syötä luku 1, 2 tai 3");
                    continue;
                }
                if(valinta == 1 || valinta == 2 || valinta == 3 || valinta == 4){
                    break;
                }
                else{
                    System.out.println("Syötä luku 1, 2, 3 tai 4");
                }
            }
            catch(Exception e){
                System.out.println("Syötä kokonaisluku");
            }
        }
        if(valinta == 3){
            return p.annaSijainti();
        }
        int sijainti = vuoronAlku(p, valinta, silmaluku);
        return sijainti;


    }
    /**
     * nopanheitto kutsuu metodia ja antaa sille parametriksi vuorossa olevan pelaajan, käyttäjän antaman valinnan (1-4), 
     * sekä heitetyn nopan silmäluvun. vuononAlku- metodi voi siirtää pelaajaa käyttäjän valitsemaan suuntaan tai avata 
     * aarteen, jos silmäluku on tarpeeksi suuri. 
     * @param p Vuorossa oleva pelaaja
     * @param valinta Käyttäjän tekemä valinta nopan heiton jälkeen
     * @param silmaluku Heitetty nopan silmäluku tälllä vuorolla
     * @return Pelaajan sijainti toimintojen jälkeen. 
     */
    public int vuoronAlku(Pelaaja p, int valinta, int silmaluku){
        if(valinta == 4){
            String k = pelilauta.mikaKaupunki(p.annaSijainti());
            if(k.equals("")){
                System.out.println("Et ole kaupungissa.");
            }
            if(k.equals("Cairo") || k.equals("Tanger")){
                System.out.println("Aloituskaupungeissa ei ole aarretta.");
            }
            else{
                boolean onkoAarre = pelilauta.onkoAarre(k);
                if(onkoAarre == false){
                    System.out.println("Tämän kaupungin aarre on jo lunastettu.");
                }
                else{
                    Kiekko kiekko = pelilauta.avaaKiekko(k);
                    pelilauta.kiekonToiminto(kiekko, p);
                }
            }
            return p.annaSijainti();

        }
        System.out.println("Mihin suuntaan haluat edetä? Katso tarvittaessa karttaa.");
        int sijainti = p.annaSijainti();
        ArrayList<String> toiminto = pelilauta.sijaintiToiminto(sijainti);
        int i = 1;
        for(String s : toiminto){
            System.out.println(i + ". " + s);
            i++;
        }
        int luku = 0;
        while(true){
            try{
                luku = Integer.parseInt(s.nextLine());
                if(luku == 1 || luku == 2){
                    break;
                }
            }
            catch(Exception e){
                System.out.println("Syötä luku 1 tai 2");
            }
        }
        if(luku == 1 && valinta == 1){
            p.siirraEteenpain(silmaluku);
        }
        else if(luku == 2 && valinta == 1){
            p.siirraTaaksepain(silmaluku);
        }
        else if(luku == 1 && valinta == 2){
            int kaupunkiEdessa = pelilauta.matkaaKaupunkiinEdessa(sijainti);
            if(kaupunkiEdessa < silmaluku){
                p.siirraEteenpain(kaupunkiEdessa);
            }
            else{
                p.siirraEteenpain(silmaluku);
            }
        }
        else if(luku == 2 && valinta == 2){
            int kaupunkiTakana = pelilauta.matkaaKaupunkiinTakana(sijainti);
            if(kaupunkiTakana < silmaluku){
                p.siirraTaaksepain(kaupunkiTakana);
            }
            else{
                p.siirraTaaksepain(silmaluku);
            }

        }

        return p.annaSijainti();
    }
    
    /**
     * Tätä metodia kutsutaan, kun pelaaja saapuu kaupunkiin, jossa on aarre. Pelaaja pystyy lunastamaan aarteen 
     * maksamalla 100 pelirahaa tai odottamalla seuraavaa vuoroa, jos rahaa ei ole. 
     * @param p Vuorossa oleva pelaaja
     * @return käyttäjän tekemä valinta (1 tai 2)
     */
    public int avataankoKiekko(Pelaaja p){
        System.out.println("1. Maksa 100 pelirahaa ja lunasta aarre");
        System.out.println("2. Odota seuraavaa vuoroa");
        int luku = 0;
        while(true){
            try{
                luku = Integer.parseInt(s.nextLine());
                if(luku == 1 || luku == 2){
                    break;
                }
                else{
                    System.out.println("Syötä luku 1 tai 2");
                }
            }
            catch(Exception e){
                System.out.println("Syötä kokonaisluku");
            }
        }
        return luku;
        
    }


}
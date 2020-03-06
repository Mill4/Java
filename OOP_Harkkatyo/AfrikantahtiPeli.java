package afrikantahti;

import afrikantahti.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Locale;

public class AfrikantahtiPeli{
    public static void main(String[] args){

        Pelaaja p1 = new Pelaaja("Pelaaja 1");
        Pelaaja p2 = new Pelaaja("Pelaaja 2");
        Pelilauta pelilauta = new Pelilauta(p1, p2);
        Lukija lukija = new Lukija(pelilauta, p1, p2);

        ArrayList<Pelaaja> pelaajat = new ArrayList<Pelaaja>();
        pelaajat.add(p1);
        pelaajat.add(p2);

        lukija.aloitusKaupunki(p1);
        lukija.aloitusKaupunki(p2);

        Pelaaja onTahti = null;
        Pelaaja eiTahtea = null;
        Pelaaja voittaja = null;

        boolean p1Tahti = p1.onkoAfrikantahti();
        boolean p2Tahti = p2.onkoAfrikantahti();
        boolean peliLoppu = false;

        while(peliLoppu == false){
            for(Pelaaja p : pelaajat){
                System.out.println(p.annaNimi() + " vuorossa");
                System.out.println("Rahatilanne:" + p.annaRahat());
                System.out.println("Olet peliruudussa:" + p.annaSijainti() + "\n");

                int sijainti = lukija.nopanheitto(p);
                String kaupunki = pelilauta.mikaKaupunki(sijainti);
                if(kaupunki.equals("")){
                    System.out.println("\n" + "\n" + "----------- VUORO VAIHTUU ------------" + "\n" + "\n");
                    continue;
                }
                boolean aarre = pelilauta.onkoAarre(kaupunki);
                if(aarre){
                    System.out.println("Saavuit kaupunkiin " + kaupunki + ", missä on aarre. Mitä haluat tehdä?");
                    int avaus = lukija.avataankoKiekko(p);
                    if(avaus == 1){
                        if(p.annaRahat() < 100){
                            System.out.println("Rahat eivät riitä aarteen lunastamiseen");
                        }
                        else if(p.annaRahat() >= 100){
                            p.lisaaRahaa(-100);
                            Kiekko kiekko = pelilauta.avaaKiekko(kaupunki);
                            pelilauta.kiekonToiminto(kiekko, p);
                        }
                    }
                }
                if(aarre == false){
                    System.out.println("Saavuit kaupunkiin " + kaupunki + ". Ei aarretta");
                }

                p1Tahti = p1.onkoAfrikantahti();
                p2Tahti = p2.onkoAfrikantahti();
                if(p1Tahti){

                    onTahti = p1;
                    eiTahtea = p2;
                    peliLoppu = pelilauta.onkoPeliLoppu(onTahti, eiTahtea);
                }
                if(p2Tahti){
                    onTahti = p2;
                    eiTahtea = p1;
                    peliLoppu = pelilauta.onkoPeliLoppu(onTahti, eiTahtea);
                }
                
                if(peliLoppu){
                    System.out.println("\n" + "\n" + "----------- PELI LOPPUI ------------" + "\n" + "\n");
                    break;
                }
                else{
                    System.out.println("\n" + "\n" + "----------- VUORO VAIHTUU ------------" + "\n" + "\n");
                }
                
            }
        }

        /**
         * Tallennetaan lopuksi tiedostoon nykyinen päivä ja ajanhetki sekä kumpi pelaaja voitti pelin.
         */
        Date date = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");  
        String strDate = formatter.format(date);  
        voittaja = pelilauta.annaVoittaja();
        
        try{
            FileWriter fw = new FileWriter("Pelatut_pelit.json", true);

            fw.write(strDate + " " + "Pelin voitti " + voittaja.annaNimi() + " " + "\n" );

            fw.close();
        }
        catch(IOException ioe){
            System.err.println("IOException: " + ioe.getMessage());
        }

        try{
            FileReader fr = new FileReader("Pelatut_pelit.json");
            BufferedReader br = new BufferedReader(fr);

            String s;
            while((s = br.readLine()) != null){
                System.out.println(s);
            }   
            br.close();
        }
        catch(IOException e){
            System.out.println("Tiedostoa ei löytynyt");
        }

        
    }
}
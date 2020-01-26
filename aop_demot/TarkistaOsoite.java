import java.util.Scanner;


public class TarkistaOsoite{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("1. Tarkista verkkotunnus");
        System.out.println("2. Tarkista sähköposti");
        System.out.println("Anna valinta:");
        String syote = s.nextLine();

        if(syote.equals("1")){
            System.out.println("Syötä tarkistettava osoite");
            String tunnus = s.nextLine();
            onkoVerkkotunnus(tunnus);

        }
        if(syote.equals("2")){
            System.out.println("Syötä tarkistettava osoite");
            String sposti = s.nextLine();
            onkoSahkopostiosoite(sposti);
        }
    }


    public static boolean onkoSahkopostiosoite(String a){
        int laskeAt = 0; //lasketaan osoitteessa olevien @-merkkien määrä
        int laskePiste = 0; //lasketaan osoitteessa olevien pisteiden määrä
        int tarkistaAt = 0; //Tarkistetaan @-merkin indeksi
        int tarkistaPiste = 0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i) == '@'){
                tarkistaAt = i;
                laskeAt++;
            }
            if(a.charAt(i) == '.'){
                laskePiste++;
                tarkistaPiste = i;
                }
            }
        
        if(laskeAt==1 && laskePiste==1 && tarkistaAt < tarkistaPiste){
            System.out.println("Osoite on kelvollinen.");
            return true;
        }
        else{
            System.out.println("Annettu sähköposti on virheellinen");
            return false;
        }
    }



    public static boolean onkoVerkkotunnus(String a){
        int laskePisteet = 0; //lasketaan osoitteessa olevien pisteiden määrä
        for(int i=0; i<a.length(); i++){
            if(i<3){ // tarkistetaan, että kolme ensimmäistä merkkiä ovat www
                if(a.charAt(i) != 'w'){
                    System.out.println("Verkkotunnus on virheellinen");
                    return false;
                }
            }
            if(a.charAt(3)!='.'){ //tarkistetaan, että neljäs merkki on piste
                System.out.println("Verkkotunnus on virheellinen");
                return false; 
            }
            if(a.charAt(i) == '.'){
                laskePisteet++;
                if(a.charAt(i+1) == '.'){ //tarkistetaan ettei kahta pistettä ole peräkkäin 
                    System.out.println("Verkkotunnus on virheellinen");
                    return false;
                }
            }
    
        }
        if(laskePisteet == 2){
            System.out.println("Osoite on kelvollinen");
            return true;
        }
        else{
            System.out.println("Verkkotunnus on virheellinen");
            return false;
        }
    }

}


import java.util.Scanner;

public class sademittari{

    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        
        int kaupunkienMaara = kaupungit(); // kaupungit-metodi tarkistaa, että käyttäjän syöte on kokonaisluku ja pyytää uutta syötettä kunnes sellainen saadaan
        String[] kaupunkiTaulukko = new String[kaupunkienMaara];

        for(int i = 0; i<kaupunkienMaara; i++){
            String sade = laskeSademaarat(); // laskeSademaarat - metodi laskee kunkin kaupungin sademäärät ja palauttaa kaupungin nimen sekä yhteenlasketut sademäärät
            kaupunkiTaulukko[i] = sade;
        }
        for(int j = 0; j<kaupunkiTaulukko.length; j++){
            System.out.println(kaupunkiTaulukko[j]);
        }
    }
    public static int kaupungit(){
        Scanner s = new Scanner(System.in);
        int maara = 0;
        System.out.println("Syötä kaupunkien lukumäärä:");
        while(true){
            try{
                maara = Integer.parseInt(s.nextLine());
                return maara;
            }
            catch(Exception e){
                System.out.println("Syötä kokonaisluku");
            }
        }
    }

    public static String laskeSademaarat(){
        Scanner s = new Scanner(System.in);
        System.out.println("Syötä kaupungin nimi:");
        String kaupunki = s.nextLine();
        int summa = 0;
        int sadeMaara = 0;
        String tulos = kaupunki;
        System.out.println("Syötä sademäärä kokonaisina millimetreinä ja syötä -1 kun haluat lopettaa;");
        while(true){
            try{
                sadeMaara = Integer.parseInt(s.nextLine());
                if(sadeMaara == -1){
                    break;
                }
                summa = summa + sadeMaara;
            }
            catch(Exception e){
                System.out.println("Syötä kokonaisluku");
            }
        }
        tulos = tulos + ": " + Integer.toString(summa);
        return tulos;
    }
}
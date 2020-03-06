package afrikantahti;

import java.lang.Math;


class Noppa{
    private int maxSilmaluku;
    private int minSilmaluku = 1;
    /**
     * Noppa-luokan avulla voidaan luoda uusia Noppa-oliota esimerkiksi pelejä varten.
     * @param silmaluku Asetetaan nopan maksimi silmäluku konstruktorissa
     */
    public Noppa(int maxSilmaluku){
        this.maxSilmaluku = maxSilmaluku;
    
    }
    
    /**
     * Metodilla voidaan heittää noppaa. Metodi palauttaa satunnaisen luvun 1 ja 
     * makisimi silmäluvun väliltä. Esimerkiksi väliltä 1-6. 
     * @return Satunnainen kokonaisluku välilta 1-n, missä n on mikä tahansa positiivinen kokoanisluku
     */
    public int heitaNoppa(){
        int max = maxSilmaluku; 
        int min = minSilmaluku;
        int range = max - min + 1; 
        int rand = (int)(Math.random() * range) + min;
        System.out.println("Heitit silmäluvun " + rand + "\n"); 
        return rand;
    }

}
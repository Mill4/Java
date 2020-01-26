import java.util.Random;
import java.util.Scanner;

public class Apumetodit2 {
	

	//Metodi lukee käyttäjän antaman merkkijonon
	public String lueMerkkijono() {
		System.out.println("Odotetaan syötettä:");
		return new Scanner(System.in).nextLine();
	}
	
	//Metodi lukee käyttäjän antaman kokonaisluvun
	public int lueKokonaisluku() {
		System.out.println("Odotetaan syötettä:");
		return new Scanner(System.in).nextInt();
	}
	
	/**
	 * Metodi palauttaa satunnaisen kokonaisluvun väliltä [0,ylaraja[,
	 * poislukien ylärajan.
	 */
	public int satunnainenKokonaisluku(int ylaraja) {
		return new Scanner(System.in).nextInt(ylaraja);
	}

	
	 //Metodi tulostaa annetun ristinollalaudan.
	 public void tulostaLauta(String[][] lauta) {
	    if(lauta == null){ // tarkistaa onko annettu lauta tyhjä
	        System.out.println("Lautaasi ei ole alustettu!");
	        return;
	    }
	    if(lauta.length != 3 || lauta[0].length != 3){ // tarkistaa, että laudan koko on oikea
	        System.out.println("Laudallasi on väärät dimensiot. Pitäisi olla 3x3.");
	        return;
	    }
		 /* Tulostaa laudan seuraavassa muodossa, kun merkkijonoina on "x" tai "o"
        x|o|o
        o|x|x
        x|o|x
        */
		
		System.out.println(lauta[0][0]+"|"+lauta[0][1]+"|"+lauta[0][2]);
		System.out.println("-|-|-");
		System.out.println(lauta[1][0]+"|"+lauta[1][1]+"|"+lauta[1][2]);
		System.out.println("-|-|-");
		System.out.println(lauta[2][0]+"|"+lauta[2][1]+"|"+lauta[2][2]);
	}
}

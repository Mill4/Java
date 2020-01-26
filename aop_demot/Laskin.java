public class Laskin{
    
        // Laskin ohjelma saa komentoriviparamterinaan kolme merkkiä, joista ensimmäinen ja viimeinen ovat kokoanislukuja
        // Keskimmäinen parametri on laskutoimitusta kuvaava symboli (summa +, erotus -, tulo x tai osamäärä /)
		public static void main(String[] args){
			if(args.length !=3){
				System.out.println("Anna parametriksi kaksi kokonaislukua ja haluttu laskutoimitus!");
				System.exit(0); 
			}
			
			//muutetaan parametrinä saadut merkkijonot luvuiksi
			//HUOM! ohjelma kaatuu jos parametrit eivät ole kokonaislukuja!
			int luku1 = Integer.parseInt(args[0]);
			int luku2 = Integer.parseInt(args[2]);
			String syote = args[1];
            int summa = luku1+luku2;
            int erotus = luku1-luku2;
            int tulo = luku1*luku2;
            int jako = luku1/luku2;

            //tulostetaan summa
			if (syote.equals("+")){
                System.out.println("Lukujen "+ luku1 + " ja " + luku2+" summa on: " +summa);
            }
			//tulostetaan erotus
            else if (syote.equals("-")){
                System.out.println("Lukujen "+ luku1 + " ja " + luku2+" erotus on: " +erotus);
            }
			//tulostetaan tulo
            else if (syote.equals("x")){
                System.out.println("Lukujen "+ luku1 + " ja " + luku2+" tulo on: " +tulo);
            }
            //tulostetaan jakolasku
            else if (syote.equals("/")){
                System.out.println("Lukujen "+ luku1 + " ja " + luku2+" osamäärä on: " +jako);
            }
			
		}
	
}
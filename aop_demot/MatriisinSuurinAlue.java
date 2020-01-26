import java.util.Random;

// main metodi alustaa 5x5 matriiseja ja asettaa soluihin arvon 1 tai 0 satunnaisesti

public class MatriisinSuurinAlue{
    public static void main(String[] args){
        final Random r = new Random();
        
        
        for(int kerrat = 0; kerrat<10; kerrat++){
            int[][] alkioTaulukko = new int[5][5];
            
            System.out.println("Matriisin");
            for(int i=0; i<alkioTaulukko.length; i++){
                System.out.print("");
                for(int j=0; j<alkioTaulukko[i].length; j++){
                    alkioTaulukko[i][j] = r.nextInt(2);
                    System.out.print(""+alkioTaulukko[i][j]+" ");
                }
                System.out.println("");
            }
            
            System.out.print("suurimman yhtenäisen alueen koko on ");
            System.out.println(laskeSuurinAlue(alkioTaulukko));
            System.out.println("");
        }

    }
    //laskeSuurinAlue saa paramterikseen neliömatriisin, joka sisältää ykkösiä ja nollia 
    // metodi laskee suurimman yhteisen alueen joka koostuu ykkösistä
    public static int laskeSuurinAlue(int[][] matriisi){
    int suurinAlue = 0;
    for(int i = 0; i<matriisi.length; i++){
        for(int j = 0; j<matriisi[i].length; j++){
            if(matriisi[i][j] == 1){
                int alueenKoko = laskeAlue(matriisi,i,j);
                if(suurinAlue < alueenKoko){
                    suurinAlue = alueenKoko;
                }
            }
        }
    }
    return suurinAlue;

}
//LaskeAlue saa paramterikseen neliömatriisin ja matriisin solun ja metodi tarkistaa onko solun
// yläpuolella, alapuolella tai jommallakummalla sivulla ykköstä
public static int laskeAlue(int[][] m, int i, int j){
    try{
        if(m[i][j]==0){
            return 0;
        }
    }
    catch(Exception e){
        return 0;
    }
    int alue = 1;
    m[i][j] = 0;
    
    alue += laskeAlue(m, i+1, j);
    alue += laskeAlue(m, i-1, j);
    alue += laskeAlue(m,i,j+1);
    alue += laskeAlue(m,i,j-1);
    return alue;
}

}
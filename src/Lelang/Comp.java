package Lelang;

import java.util.Random;

public class Comp {
    public int generateHarga(int hargaSebelum){
        Random rand = new Random();
        int lelang = rand.nextInt(4);
        if(lelang != 0){
            int hargaBot = rand.nextInt(hargaSebelum) + (hargaSebelum);
            return hargaBot;
        }else{
            return 0;
        }
    }
}

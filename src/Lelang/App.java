package Lelang;
import java.util.Scanner;
public class App {
    
        // membuat objek dari setiap class
    static Masyarakat masyarakat = new Masyarakat();
    static Barang barangLelang = new Barang();
    static Petugas petugas = new Petugas("Petugas01", "Jasa Lelang Terpercaya007", "0112352234");

    // membuat scanner
    static Scanner userInput = new Scanner(System.in);
    static Scanner ulang = new Scanner(System.in);

    //membuat variabel
    static String jawab = "";
    static String user_input = "";
    static int Pilihan;

    static String loginName = "";
    static Comp opponent = new Comp();
    static int currentHarga;

    static int bot_harga;
    static int user_harga;

    public static void main(String[] args) {
        //pemanggilan method
        login();
        askGeneratebarang();
        askAjukanBarang();
        System.out.println("Daftar barang");
        System.out.println();//jarak
        barangLelang.tampilBarang();
    
        //Proses Lelang
        System.out.print("barang mana yang ingin anda tawar ? : ");
        Pilihan = userInput.nextInt();
        if (Pilihan > barangLelang.idBarang.size() || !barangLelang.getStatus(Pilihan)){
            System.out.println("nomor barang tidak valid");
        }else{
            System.out.println("Barang : " + barangLelang.getNamaBarang(Pilihan));
            System.out.println("harga awal : " + barangLelang.getHargaAwal(Pilihan));
            System.out.println("Status : " + barangLelang.getStatus(Pilihan));
            barangLelang.addPenawar(masyarakat.getIdMasyarakat(masyarakat.getIndexFromName(loginName)));
            barangLelang.overrideHargaTawar();
            barangLelang.addHargaTawar(barangLelang.getHargaAwal(Pilihan));

            AduNasib();
        }
        Report();
    }

    static boolean UserAnswerIsYes(String input){
        return input.equalsIgnoreCase("y");
    }

    static void login(){
        System.out.println("++ LOGIN DULU BOSS ++");
        System.out.print("Masukkin Nama Boss : ");
        String nama = userInput.nextLine();
        loginName = nama;
        System.out.print("Dimana ente tinggal ? : ");
        String alamat = userInput.nextLine();
        System.out.print("Bagi Nomer Telpon dong : ");
        String telp = userInput.nextLine();
        masyarakat.Masyarakat(nama, alamat, telp);
    }

    static void askGeneratebarang(){
        //ask for generate
        System.out.print("Generate Barang ? (Y/N) : ");
        user_input = userInput.nextLine();

        if (UserAnswerIsYes(user_input)){
            generatebarang();
            System.out.println("Barang Lelang dibuat");
        }else{
            System.out.println("LANJUUTT OM");
        }
    }

    static void askAjukanBarang(){
        //menjual barang
        System.out.print("Ente Mau Jual gak boss ? (Y/N) : ");
        user_input = userInput.nextLine();
        if (UserAnswerIsYes(user_input)){
            petugas.MengjualBarang(barangLelang);
            System.out.println("barang ditambahkan");
        }else{
            System.out.println("LANJUUTT OM");
        }
    }

    static void AduNasib() {
        do {

            //memasukkan harga tawaran
            currentHarga = barangLelang.getHargaTertinggi();
            System.out.println("harga Sekarang : " + currentHarga);
            System.out.println();//jarak
            System.out.print("Masukkan Harga : ");
            int harga = userInput.nextInt();
            System.out.println();//jarak
            if (harga <= barangLelang.getHargaTertinggi()){
                System.out.println("lebih mahal doong, yakali cuman "+harga);
            }else {
                barangLelang.addHargaTawar(harga);
                user_harga = harga;
            }
            currentHarga = barangLelang.getHargaTertinggi();

            //Pengacakan harga untuk lawan
            bot_harga = opponent.generateHarga(currentHarga);
            if (bot_harga <= barangLelang.getHargaTertinggi()){
                System.out.println("Computer :  Ampun Gan, Kukira Cupu Ternyata Suhu");
                System.out.println();//jarak
            }else {
                barangLelang.addHargaTawar(bot_harga);
                System.out.println("Computer : " + bot_harga);
                currentHarga = barangLelang.getHargaTertinggi();
                System.out.println("Computer Says : Mwehehehe, Cuman " +harga+" Doang Bosss ?? "+bot_harga+" nih Boss, Senggol Dong !!" );
                System.out.println();//jarak               
                System.out.print("Lawan nggak, Lawan nggak ?, LAWAN LAHH MASA ENGGAKK!!! (Y/N) : ");
                jawab = ulang.nextLine();
                System.out.println();
            }
        
        } 
        while((bot_harga >= currentHarga) && UserAnswerIsYes(jawab));
    }

    static void generatebarang() {
        
        //menambahkan barang 1
        barangLelang.addNamaBarang("Kaos Kaki");
        barangLelang.addHargaAwal(10000);
        barangLelang.addHargaTawar(10000);
        barangLelang.setStatus(true); 
        //menambahkan barang 2
        barangLelang.addNamaBarang("Sepatu");
        barangLelang.addHargaAwal(400000);
        barangLelang.addHargaTawar(400000);
        barangLelang.setStatus(true);
        //menambahkan barang 3
        barangLelang.addNamaBarang("Sandal Supreme");
        barangLelang.addHargaAwal(200000);
        barangLelang.addHargaTawar(200000);
        barangLelang.setStatus(true);
        //menambahkan barang 4
        barangLelang.addNamaBarang("Tas Ransel");
        barangLelang.addHargaAwal(150000);
        barangLelang.addHargaTawar(150000);
        barangLelang.setStatus(true);
        //menambahkan barang 5
        barangLelang.addNamaBarang("Headset");
        barangLelang.addHargaAwal(250000);
        barangLelang.addHargaTawar(250000);
        barangLelang.setStatus(true);
    }

    static void Report(){
        barangLelang.setStatus(Pilihan, false);
        if (currentHarga == user_harga){
            System.out.print("Pemenang " + barangLelang.getNamaBarang(Pilihan));
            System.out.println(" Adalah : " + loginName);
            System.out.println("Dengan harga : " + currentHarga);
        }else {
            System.out.print("Pemenang " + barangLelang.getNamaBarang(Pilihan));
            System.out.println(" Adalah : Computer");
            System.out.println("Dengan harga : " + currentHarga);
            System.out.println("Bot Says : Gw menang nih Boss, really uang "+currentHarga+" aja Lu gak berani lawan ?, waokwoakwakwkk");
        } 
    }
}

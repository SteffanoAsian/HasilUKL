package Lelang;
 
import java.util.ArrayList;
//import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Barang extends Lelang {
    static Scanner input = new Scanner(System.in);

    private ArrayList<Integer> idMasyarakat = new ArrayList<Integer>();
    private ArrayList<String> namaBarang = new ArrayList<String>();
    private ArrayList<Integer> hargaAwal = new ArrayList<Integer>();

    public int getIdMasyarakat(int index) {
        return idMasyarakat.get(index); //mengambil id masyarakat dari dalam array list
    }

    void overrideHargaTawar(){
        this.hargaTawar.clear(); //mengosongkan harga tawar
    }

    @Override
    public int getHargaTertinggi() {
        return Collections.max(hargaTawar); // mengambil nilai tertinggi dalam array list hargaTawar
    }

    public void addIdMasyarakat(int ID) {
        this.idMasyarakat.add(ID); //menambahkan ID masyarakat kedalam ArrayList
    }

    public String getNamaBarang(int index) {
        return namaBarang.get(index); //mengambil nama masyarakat dari dalam array list berdasarkan Index
    }

    public void addNamaBarang(String nama) {
        this.namaBarang.add(nama); //menambahkan nama barang kedalam ArrayList
    }

    public int getHargaAwal(int index) {
        return hargaAwal.get(index); //mengambil harga awal dari ArrayList barang berdasarkan Index
    }

    public void addHargaAwal(int harga) {
        this.hargaAwal.add(harga); //menambahkan harga awal kedalam ArrayList
    }
    public void setStatus(int index, boolean status){
        Status.add(index, status); // meng-set status suatu barang berdasarkan Index
    }
    
    public int getIdMasyarakat() {
        int index = input.nextInt();
        return idMasyarakat.get(index);
    }

    public void addIdMasyarakat() {
        int ID = input.nextInt();
        this.idMasyarakat.add(ID);
    }

    
    public String getNamaBarang() {
        int index = input.nextInt();
        return namaBarang.get(index); 
    }

    public void addNamaBarang() {
        String nama = input.nextLine();
        this.namaBarang.add(nama);
    }

    public void addHargaAwal() {
        int harga = input.nextInt();
        this.hargaAwal.add(harga);
    }

    @Override
    public void addIdBarang(int ID) {
        super.addIdBarang(ID);
    }

    //method untuk menampilkan barang
    public void tampilBarang(){
        int i, n = namaBarang.size();
        if(n == 0){
            System.out.println("DISINI NGGAK ADA BARANG OM !!");
            
        }else{
        for (i=0; i<n; i++){
            System.out.println("---------------");
            System.out.println("ID : " + namaBarang.indexOf(getNamaBarang(i)));
            addIdBarang(namaBarang.indexOf(getNamaBarang(i)));
            System.out.println("Nama Barang : " +getNamaBarang(i));
            System.out.println("Harga awal : "+getHargaAwal(i));
            System.out.println("Dapat dilelang? : "+getStatus(i));
            System.out.println("+-------------+");
            System.out.println();
        }
    }
}
}

package Lelang;

import java.util.ArrayList;

public class Masyarakat extends User{
    private ArrayList<String> namaMasyarakat = new ArrayList<String>();
    private ArrayList<String> alamat = new ArrayList<String>();
    private ArrayList<String> telepon = new ArrayList<String>();
    private ArrayList<Integer> idMasyarakat = new ArrayList<Integer>();

    public void Masyarakat(String nama, String alamat, String telp){ //method yang berisi identitas masyarakat
        setNama(nama);
        setAlamat(alamat);
        setTelepon(telp);
        setIdMasyarakat(namaMasyarakat.indexOf(nama));
    }

    public int getIndexFromName(String nama){
        return namaMasyarakat.indexOf(nama); //Mengambil Index dari dalam array list berdasarkan Nama 
    }
    public int getIdMasyarakat(int id) {
        return idMasyarakat.get(id); // mengambil ID masyarakat dari Array List
    }

    public void setIdMasyarakat(int id) {
        this.idMasyarakat.add(id); // meng-set ID masyarakat
    }

    @Override
    public void setNama(String nama) {
        this.namaMasyarakat.add(nama); // men-set nama dalam array list
    }

    @Override
    public void setAlamat(String Alamat) {
        this.alamat.add(Alamat); //men-set alamat dalam array list
    }

    @Override
    public void setTelepon(String telp) {
        this.telepon.add(telp); // men-set telepon dalam array list
    }

    @Override
    public String getNama(int ID) {
        return namaMasyarakat.get(ID); // mengambil data nama masyarakat di array list berdasarkan ID
    }

    @Override
    public String getAlamat(int ID) {
        return alamat.get(ID); // mengambil data alamat di array list berdasarkan ID
    }

    @Override
    public String getTelepon(int ID) {
        return alamat.get(ID); // mengambil data telpon di array list berdasarkan ID
    }
}

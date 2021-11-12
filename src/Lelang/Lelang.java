package Lelang;

import java.util.ArrayList;

public class Lelang implements intrfc{
    ArrayList<Boolean> Status = new ArrayList<Boolean>();
    ArrayList<Integer> idPenawar = new ArrayList<>();
    ArrayList<Integer> idBarang = new ArrayList<>();
    ArrayList<Integer> hargaTawar = new ArrayList<>();

    @Override
    public void addPenawar(int ID) {
        this.idPenawar.add(ID); //menambahkan ID penawar kedalam Array List
    }

    @Override
    public void addIdBarang(int ID) {
        this.idBarang.add(ID); //menambahkan ID barang kedalam Array List
    }

    @Override
    public void addHargaTawar(int harga) {
        this.hargaTawar.add(harga); //menambahkan harga tawar kedalam Array List
    }

    @Override
    public void setStatus(boolean status) {
        this.Status.add(status); //menambahkan Status Barang kedalam Array List
    }

    @Override
    public int getHargaTertinggi() {
        return 0; 
    }

    @Override
    public boolean getStatus(int id) {
        return this.Status.get(id);
    }
}

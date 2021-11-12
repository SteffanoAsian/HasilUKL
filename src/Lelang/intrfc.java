package Lelang;

public interface intrfc {   
    void addPenawar(int ID);
    void addIdBarang(int ID); 
    void addHargaTawar(int harga); 
    void setStatus(boolean status); 

    int getHargaTertinggi(); 
    boolean getStatus(int id); 
}

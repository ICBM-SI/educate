/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP VICTUS
 */
public class LatihanSoal {
    private int idLatihanSoal;
    private String pertanyaan;
    private Materi materi;
    private PaketSoal paketSoal;
    private List<Jawaban> daftarJawaban = new ArrayList<>();

    public LatihanSoal(int idLatihanSoal, String pertanyaan, Materi materi, PaketSoal paketSoal) {
        this.idLatihanSoal = idLatihanSoal;
        this.pertanyaan = pertanyaan;
        this.materi = materi;
        this.paketSoal = paketSoal;
    }

    public LatihanSoal() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getIdLatihanSoal() {
        return idLatihanSoal;
    }

    public void setIdLatihanSoal(int idLatihanSoal) {
        this.idLatihanSoal = idLatihanSoal;
    }

    public String getPertanyaan() {
        return pertanyaan;
    }

    public void setPertanyaan(String pertanyaan) {
        this.pertanyaan = pertanyaan;
    }

    public Materi getMateri() {
        return materi;
    }

    public void setMateri(Materi materi) {
        this.materi = materi;
    }

    public PaketSoal getPaketSoal() {
        return paketSoal;
    }

    public void setPaketSoal(PaketSoal paketSoal) {
        this.paketSoal = paketSoal;
    }

    public List getDaftarJawaban() {
        return daftarJawaban;
    }

    public void setDaftarJawaban(List daftarJawaban) {
        this.daftarJawaban = daftarJawaban;
    } 

    public int getMateriIdMateri() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getPaketSoalIdPaketSoal() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setMateriIdMateri(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setPaketSoalIdPaketSoal(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
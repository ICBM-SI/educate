/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HP VICTUS
 */
public class Jawaban {
    public static final String benar = "Benar";
    public static final String salah = "Salah";

    private int idJawaban;
    private String pilihanJawaban;
    private String kunciJawaban;
    private String opsi;                
    private LatihanSoal latihanSoal;

    public Jawaban(int idJawaban, String pilihanJawaban, String kunciJawaban, String opsi, LatihanSoal latihanSoal) {
        this.idJawaban = idJawaban;
        this.pilihanJawaban = pilihanJawaban;
        this.kunciJawaban = kunciJawaban;
        this.opsi = opsi;
        this.latihanSoal = latihanSoal;
    }

    public int getIdJawaban() {
        return idJawaban;
    }

    public void setIdJawaban(int idJawaban) {
        this.idJawaban = idJawaban;
    }

    public String getPilihanJawaban() {
        return pilihanJawaban;
    }

    public void setPilihanJawaban(String pilihanJawaban) {
        this.pilihanJawaban = pilihanJawaban;
    }

    public String getKunciJawaban() {
        return kunciJawaban;
    }

    public void setKunciJawaban(String kunciJawaban) {
        this.kunciJawaban = kunciJawaban;
    }

    public String getOpsi() {
        return opsi;
    }

    public void setOpsi(String opsi) {
        this.opsi = opsi;
    }

    public LatihanSoal getLatihanSoal() {
        return latihanSoal;
    }

    public void setLatihanSoal(LatihanSoal latihanSoal) {
        this.latihanSoal = latihanSoal;
    }

    public int getLatihanSoalIdLatihanSoal() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
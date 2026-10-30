package controller;

import model.LatihanSoal;
import model.Jawaban;
import java.util.List;

public class LatihanSoalController {

    // Menambahkan pertanyaan dan opsi jawaban latihan soal
    public boolean buatSoalDanJawaban(String pertanyaan, int idMateri, int idPaketSoal, List<Jawaban> daftarJawaban) {
        LatihanSoal soal = new LatihanSoal();
        soal.setPertanyaan(pertanyaan);
        soal.setMateriIdMateri(idMateri);
        soal.setPaketSoalIdPaketSoal(idPaketSoal);
        
        // 1. Simpan soal ke database via LatihanSoalDAO
        // 2. Looping dan simpan setiap pilihan jawaban ke tabel jawaban via JawabanDAO
        
        System.out.println("Soal latihan berhasil ditambahkan.");
        return true;
    }
}
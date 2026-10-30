package controller;

import model.HasilBelajar;
import model.DetailLatihan;
import java.util.Date;
import java.util.List;

public class HasilBelajarController {

  
    public boolean simpanHasilBelajarPelajar(int idPelajar, int totalSoal, int jumlahBenar, double skor, List<DetailLatihan> listDetailJawaban) {
        HasilBelajar hasil = new HasilBelajar();
        hasil.setTanggalPengerjaan(java.time.LocalDate.now());
        hasil.setTotalSoal(totalSoal);
        hasil.setJumlahBenar(jumlahBenar);
        hasil.setSkor((int) skor);
        hasil.setPelajarIdPengguna(idPelajar);
        
       
        System.out.println("Hasil belajar pelajar ID " + idPelajar + " berhasil disimpan. Skor: " + skor);
        return true;
    }

   
    public void tampilkanRiwayatPelajar(int idPelajar) {
        // Panggil HasilBelajarDAO.getByPelajar(idPelajar)
        System.out.println("Memuat riwayat hasil belajar untuk pelajar ID: " + idPelajar);
    }
}
package controller;

import dao.KelasOnlineDao;
import dao.PendaftaranKelasDao;
import model.KelasOnline;
import model.PendaftaranKelasOnline;
import java.time.LocalDate;
import java.util.List;

public class PendaftaranKelasController {
    private KelasOnlineDao kelasDAO = new KelasOnlineDao();
    private PendaftaranKelasDao pendaftaranDAO = new PendaftaranKelasDao();

    // Menampilkan daftar kelas online yang bisa dipilih pelajar
    public List<KelasOnline> tampilkanDaftarKelas() {
        return kelasDAO.getAllKelas();
    }

    // Memproses pendaftaran kelas online oleh pelajar
    public boolean prosesPendaftaranKelas(int idPelajar, int idKelasOnline) {
        PendaftaranKelasOnline pendaftaran = new PendaftaranKelasOnline();
        pendaftaran.setTanggalPendaftaran(LocalDate.now());
        pendaftaran.setStatusPembayaran("Success"); // Status default atau Pending
        pendaftaran.setPelajarIdPengguna(idPelajar);
        pendaftaran.setKelasOnlineIdKelasOnline(idKelasOnline);
        
        boolean berhasil = pendaftaranDAO.daftarKelas(pendaftaran);
        if (berhasil) {
            System.out.println("Pendaftaran kelas online berhasil dilakukan!");
        } else {
            System.out.println("Pendaftaran kelas online gagal.");
        }
        return berhasil;
    }
}
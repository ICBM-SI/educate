package controller;

import dao.KelasOnlineDao;
import dao.PendaftaranKelasDao;
import model.KelasOnline;
import model.PendaftaranKelasOnline;
import model.Pelajar;
import java.time.LocalDate;
import java.util.List;

public class PendaftaranKelasController {
    private KelasOnlineDao kelasDAO = new KelasOnlineDao();
    private PendaftaranKelasDao pendaftaranDAO = new PendaftaranKelasDao();


    public List<KelasOnline> tampilkanDaftarKelas() {
        return kelasDAO.getAllKelas();
    }


    public boolean prosesPendaftaranKelas(int idPelajar, int idKelasOnline) {
        PendaftaranKelasOnline pendaftaran = new PendaftaranKelasOnline();
        pendaftaran.setTanggalDaftar(LocalDate.now()); // Menggunakan setTanggalDaftar()
        pendaftaran.setStatusPembayaran("Pending");    // Status awal pendaftaran
        

        Pelajar pelajar = new Pelajar();
        pelajar.setIdPengguna(idPelajar);
        pendaftaran.setPelajar(pelajar);
        

        KelasOnline kelas = new KelasOnline();
        kelas.setIdKelas(idKelasOnline); 
        pendaftaran.setKelasOnline(kelas);
        
        boolean berhasil = pendaftaranDAO.daftarKelas(pendaftaran);
        if (berhasil) {
            System.out.println("Pendaftaran kelas online berhasil dilakukan!");
        } else {
            System.out.println("Pendaftaran kelas online gagal.");
        }
        return berhasil;
    }
}
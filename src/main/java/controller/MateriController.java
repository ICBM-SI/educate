package controller;

import model.Materi;
import java.util.List;
import java.util.ArrayList;

public class MateriController {
    
    // Tambah Materi Baru
    public boolean tambahMateri(String namaMateri, String topik, String tipeMateri, String deskripsi, int idPengajar) {
        Materi m = new Materi();
        m.setNamaMateri(namaMateri);
        m.setTopik(topik);
        m.setTipeMateri(tipeMateri);
        m.setDeskripsiMateri(deskripsi);
        m.setPengajarIdPengguna(idPengajar);
        
        // Di sini Anda bisa memanggil MateriDAO.insert(m);
        System.out.println("Materi '" + namaMateri + "' berhasil diproses oleh Controller.");
        return true;
    }

    // Tampilkan Semua Materi (untuk View tabel materi)
    public List<Materi> tampilkanMateri() {
        List<Materi> listMateri = new ArrayList<>();
        // Di sini Anda memanggil MateriDAO.getAll();
        return listMateri;
    }
}
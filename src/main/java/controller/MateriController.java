package controller;

import model.Materi;
import model.Pengajar; 
import dao.MateriDao;  
import java.util.List;
import java.util.ArrayList;

public class MateriController {
    
    
    private MateriDao materiDao = new MateriDao();


    public boolean tambahMateri(String namaMateri, String topik, String tipeMateri, String deskripsi, int idPengajar) {
        Materi m = new Materi();
        m.setNamaMateri(namaMateri);
        m.setTopik(topik);
        m.setTipeMateri(tipeMateri);
        m.setDeskripsiMateri(deskripsi);
        
        Pengajar pengajar = new Pengajar();
        pengajar.setIdPengguna(idPengajar);
        m.setPengajar(pengajar);
        
        boolean berhasil = materiDao.insert(m);
        if (berhasil) {
            System.out.println("Materi " + namaMateri + " berhasil disimpan ke database.");
        } else {
            System.out.println("Gagal menyimpan materi.");
        }
        
        return berhasil;
    }

    // Tampilkan Semua Materi (untuk View tabel materi)
    public List<Materi> tampilkanMateri() {
        return materiDao.getAll();
    }
}
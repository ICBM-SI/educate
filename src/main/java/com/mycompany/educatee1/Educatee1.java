package com.mycompany.educatee1;

import controller.PendaftaranKelasController;
import controller.MateriController;

public class Educatee1 {

    public static void main(String[] args) {
        System.out.println("Aplikasi Educatee1 Berhasil Dijalankan!");
        
        // Contoh uji coba panggil controller untuk memastikan koneksi antar layer aman
        PendaftaranKelasController pendaftaranController = new PendaftaranKelasController();
        System.out.println("Jumlah kelas tersedia: " + pendaftaranController.tampilkanDaftarKelas().size());
    }
}
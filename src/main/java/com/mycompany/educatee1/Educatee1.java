package com.mycompany.educatee1;

import controller.PendaftaranKelasController;
import java.util.Scanner;

public class Educatee1 {

    public static void main(String[] args) {
        System.out.println("Aplikasi Educatee1 Berhasil Dijalankan!");
        
        PendaftaranKelasController pendaftaranController = new PendaftaranKelasController();
        System.out.println("Jumlah kelas tersedia: " + pendaftaranController.tampilkanDaftarKelas().size());
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n--- MENU PENDAFTARAN KELAS ONLINE ---");
        System.out.print("Masukkan ID Pendaftaran (angka bebas/unik, misal: 101): ");
        int idPendaftaran = scanner.nextInt();
        
        System.out.print("Masukkan ID Pelajar (contoh: 4): ");
        int idPelajar = scanner.nextInt();
        
        System.out.print("Masukkan ID Kelas Online (contoh: 1): ");
        int idKelas = scanner.nextInt();
        
        // PENTING: Panggil controller untuk memproses data yang sudah Anda ketik ini!
        boolean hasilInput = pendaftaranController.prosesPendaftaranKelas(idPendaftaran, idPelajar, idKelas);
        
        if (hasilInput) {
            System.out.println("Data berhasil di-input ke database!");
        } else {
            System.out.println("Gagal meng-input data. Periksa kembali ID yang dimasukkan.");
        }
        
        scanner.close();
    }
}
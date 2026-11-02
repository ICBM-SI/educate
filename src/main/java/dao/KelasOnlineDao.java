/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.EducateDB;
import model.KelasOnline;
import model.Pengajar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KelasOnlineDao {

    public List<KelasOnline> getAllKelas() {
        List<KelasOnline> listKelas = new ArrayList<>();
        String sql = "SELECT * FROM kelas_online";
        
        try (Connection conn = EducateDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                KelasOnline kelas = new KelasOnline();
                kelas.setIdKelas(rs.getInt("id_kelas"));
                kelas.setNamaKelas(rs.getString("nama_kelas"));
                kelas.setDeskripsiKelas(rs.getString("deskripsi_kelas"));
                

                if (rs.getDate("tanggal_kelas") != null) {
                    kelas.setTanggalKelas(rs.getDate("tanggal_kelas").toLocalDate());
                }
                if (rs.getString("waktu_mulai") != null) {
                String waktuMulaiStr = rs.getString("waktu_mulai").replaceAll("[^0-9:]", "").trim();
                if (!waktuMulaiStr.isEmpty()) {
                 kelas.setWaktuMulai(java.time.LocalTime.parse(waktuMulaiStr));
    }
}
                if (rs.getString("waktu_selesai") != null) {
                String waktuSelesaiStr = rs.getString("waktu_selesai").replaceAll("[^0-9:]", "").trim();
                if (!waktuSelesaiStr.isEmpty()) {
                kelas.setWaktuSelesai(java.time.LocalTime.parse(waktuSelesaiStr));
    }
}
                kelas.setLinkKelas(rs.getString("link_kelas"));
                String hargaStr = rs.getString("harga");
                if (hargaStr != null) {
                String bersihHarga = hargaStr.replaceAll("[^0-9]", "");
                if (!bersihHarga.isEmpty()) {
                kelas.setHarga(Double.parseDouble(bersihHarga));
              } else {
                kelas.setHarga(0.0);
    }
}
                kelas.setStatusKelas(rs.getString("status_kelas"));
                kelas.setKuotaMaksimal(rs.getInt("kuota_maksimal"));
                
                Pengajar pengajar = new Pengajar();
                pengajar.setIdPengguna(rs.getInt("pengajar_id_pengguna"));
                kelas.setPengajar(pengajar);
                
                listKelas.add(kelas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listKelas;
    }
}
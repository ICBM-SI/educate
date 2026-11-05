/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.EducateDB;
import model.HasilBelajar;
import model.DetailLatihan;
import model.Pelajar;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HasilBelajarDao {


    public boolean insertHasil(HasilBelajar hb) {
        String sql = "INSERT INTO hasil_belajar (tanggal_pengerjaan, total_soal, jumlah_benar, skor, pelajar_id_pengguna) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = EducateDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setDate(1, java.sql.Date.valueOf(hb.getTanggalPengerjaan()));
            stmt.setInt(2, hb.getTotalSoal());
            stmt.setInt(3, hb.getJumlahBenar());
            stmt.setDouble(4, hb.getSkor());
            stmt.setInt(5, hb.getPelajar().getIdPengguna());
            stmt.executeUpdate();
            

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                hb.setIdHasil(rs.getInt(1));
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean insertDetail(DetailLatihan dl) {
        String sql = "INSERT INTO detail_latihan (jawaban_pelajar, status_jawaban, latihan_soal_id_latihan_soal, hasil_belajar_id_hasil) VALUES (?, ?, ?, ?)";
        try (Connection conn = EducateDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, dl.getJawabanPelajar());
            stmt.setString(2, dl.getStatusJawaban());
            stmt.setInt(3, dl.getLatihanSoal().getIdLatihanSoal()); // Mengambil ID dari objek LatihanSoal
            stmt.setInt(4, dl.getHasilBelajar().getIdHasil());     // Mengambil ID dari objek HasilBelajar
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public List<HasilBelajar> getByPelajar(int idPelajar) {
        List<HasilBelajar> list = new ArrayList<>();
        String sql = "SELECT * FROM hasil_belajar WHERE pelajar_id_pengguna = ?";
        try (Connection conn = EducateDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPelajar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                HasilBelajar hb = new HasilBelajar();
                hb.setIdHasil(rs.getInt("id_hasil"));
                hb.setTanggalPengerjaan(rs.getDate("tanggal_pengerjaan").toLocalDate());
                hb.setTotalSoal(rs.getInt("total_soal"));
                hb.setJumlahBenar(rs.getInt("jumlah_benar"));
                hb.setSkor((int) rs.getDouble("skor")); // Sesuaikan jika tipenya double di model
                
                // Set objek Pelajar beserta ID-nya
                Pelajar pelajar = new Pelajar();
                pelajar.setIdPengguna(rs.getInt("pelajar_id_pengguna"));
                hb.setPelajar(pelajar);
                
                list.add(hb);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
package dao;

import config.EducateDB;
import model.HasilBelajar;
import model.DetailLatihan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HasilBelajarDao {

    // CREATE / Simpan Rekap Hasil Belajar Pelajar
    public boolean insertHasil(HasilBelajar hb) {
        String sql = "INSERT INTO hasil_belajar (tanggal_pengerjaan, total_soal, jumlah_benar, skor, pelajar_id_pengguna) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = EducateDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setDate(1, java.sql.Date.valueOf(hb.getTanggalPengerjaan()));
            stmt.setInt(2, hb.getTotalSoal());
            stmt.setInt(3, hb.getJumlahBenar());
            stmt.setDouble(4, hb.getSkor());
            stmt.setInt(5, hb.getPelajarIdPengguna());
            stmt.executeUpdate();
            
            // Mengambil ID hasil belajar yang baru saja digenerate otomatis oleh database
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

    // CREATE / Simpan Detail Jawaban Per Soal
    public boolean insertDetail(DetailLatihan dl) {
        String sql = "INSERT INTO detail_latihan (jawaban_pelajar, status_jawaban, latihan_soal_id_latihan_soal, hasil_belajar_id_hasil) VALUES (?, ?, ?, ?)";
        try (Connection conn = EducateDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, dl.getJawabanPelajar());
            stmt.setString(2, dl.getStatusJawaban());
            stmt.setInt(3, dl.getLatihanSoalIdLatihanSoal());
            stmt.setInt(4, dl.getHasilBelajarIdHasil());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // READ / Tampilkan Riwayat Hasil Belajar Berdasarkan ID Pelajar
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
                hb.setSkor((int) rs.getDouble("skor"));
                hb.setPelajarIdPengguna(rs.getInt("pelajar_id_pengguna"));
                list.add(hb);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
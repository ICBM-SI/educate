package dao;

import config.EducateDB;
import model.LatihanSoal;
import model.Jawaban;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LatihanSoalDao {

    // CREATE / Tambah Pertanyaan Latihan Soal
    public boolean insertSoal(LatihanSoal ls) {
        String sql = "INSERT INTO latihan_soal (pertanyaan, materi_id_materi, paket_soal_id_paket_soal) VALUES (?, ?, ?)";
        try (Connection conn = EducateDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ls.getPertanyaan());
            stmt.setInt(2, ls.getMateriIdMateri());
            stmt.setInt(3, ls.getPaketSoalIdPaketSoal());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // CREATE / Tambah Opsi Jawaban untuk Soal
    public boolean insertJawaban(Jawaban j) {
        String sql = "INSERT INTO jawaban (pilihan_jawaban, kunci_jawaban, latihan_soal_id_latihan_soal, opsi) VALUES (?, ?, ?, ?)";
        try (Connection conn = EducateDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, j.getPilihanJawaban());
            stmt.setString(2, j.getKunciJawaban());
            stmt.setInt(3, j.getLatihanSoalIdLatihanSoal());
            stmt.setString(4, j.getOpsi());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // READ / Ambil soal berdasarkan Paket Soal
    public List<LatihanSoal> getByPaketSoal(int idPaketSoal) {
        List<LatihanSoal> list = new ArrayList<>();
        String sql = "SELECT * FROM latihan_soal WHERE paket_soal_id_paket_soal = ?";
        try (Connection conn = EducateDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPaketSoal);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                LatihanSoal ls = new LatihanSoal();
                ls.setIdLatihanSoal(rs.getInt("id_latihan_soal"));
                ls.setPertanyaan(rs.getString("pertanyaan"));
                ls.setMateriIdMateri(rs.getInt("materi_id_materi"));
                ls.setPaketSoalIdPaketSoal(rs.getInt("paket_soal_id_paket_soal"));
                list.add(ls);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
package dao;

import config.EducateDB;
import model.LatihanSoal;
import model.Materi;
import model.PaketSoal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LatihanSoalDao {


    public boolean insert(LatihanSoal latihan) {
        String sql = "INSERT INTO latihan_soal (pertanyaan, materi_id_materi, paket_soal_id_paket_soal) VALUES (?, ?, ?)";
        try (Connection conn = EducateDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {          
            stmt.setString(1, latihan.getPertanyaan());
            stmt.setInt(2, latihan.getMateri().getIdMateri()); // Mengambil ID dari objek Materi
            stmt.setInt(3, latihan.getPaketSoal().getIdPaketSoal()); // Mengambil ID dari objek PaketSoal
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<LatihanSoal> getAll() {
        List<LatihanSoal> list = new ArrayList<>();
        String sql = "SELECT * FROM latihan_soal";
        try (Connection conn = EducateDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                LatihanSoal latihan = new LatihanSoal();
                latihan.setIdLatihanSoal(rs.getInt("id_latihan_soal"));
                latihan.setPertanyaan(rs.getString("pertanyaan"));
                
                Materi materi = new Materi();
                materi.setIdMateri(rs.getInt("materi_id_materi"));
                latihan.setMateri(materi);
                
                PaketSoal paketSoal = new PaketSoal();
                paketSoal.setIdPaketSoal(rs.getInt("paket_soal_id_paket_soal"));
                latihan.setPaketSoal(paketSoal);
                
                list.add(latihan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
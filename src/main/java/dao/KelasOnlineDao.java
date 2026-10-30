package dao;

import config.EducateDB;
import model.KelasOnline;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KelasOnlineDao {

    // Mengambil daftar seluruh kelas online yang tersedia
    public List<KelasOnline> getAllKelas() {
        List<KelasOnline> listKelas = new ArrayList<>();
        String sql = "SELECT * FROM kelas_online";
        
        try (Connection conn = EducateDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                KelasOnline kelas = new KelasOnline();
                kelas.setIdKelasOnline(rs.getInt("id_kelas_online"));
                kelas.setNamaKelas(rs.getString("nama_kelas"));
                kelas.setDeskripsi(rs.getString("deskripsi"));
                kelas.setHarga(rs.getDouble("harga"));
                listKelas.add(kelas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listKelas;
    }
}
package dao;

import config.EducateDB;
import model.Materi;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Pengajar;

public class MateriDao {
    public boolean insert(Materi m) {
        String sql = "INSERT INTO materi (nama_materi, topik, tipe_materi, deskripsi_materi, pengajar_id_pengguna) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = EducateDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, m.getNamaMateri());
            stmt.setString(2, m.getTopik());
            stmt.setString(3, m.getTipeMateri());
            stmt.setString(4, m.getDeskripsiMateri());
            stmt.setInt(5, m.getPengajar().getIdPengguna()); // Mengambil ID dari objek Pengajar
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Materi> getAll() {
        List<Materi> list = new ArrayList<>();
        String sql = "SELECT * FROM materi";
        try (Connection conn = EducateDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Materi m = new Materi();
                m.setIdMateri(rs.getInt("id_materi"));
                m.setNamaMateri(rs.getString("nama_materi"));
                m.setTopik(rs.getString("topik"));
                m.setTipeMateri(rs.getString("tipe_materi"));
                m.setDeskripsiMateri(rs.getString("deskripsi_materi"));
                Pengajar p = new Pengajar();
                p.setIdPengguna(rs.getInt("pengajar_id_pengguna"));
                m.setPengajar(p);
                list.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean delete(int idMateri) {
        String sql = "DELETE FROM materi WHERE id_materi = ?";
        try (Connection conn = EducateDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idMateri);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
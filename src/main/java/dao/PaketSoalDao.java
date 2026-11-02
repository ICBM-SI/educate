package dao;

import config.EducateDB;
import model.PaketSoal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaketSoalDao {

    public List<PaketSoal> getAll() {
        List<PaketSoal> list = new ArrayList<>();
        String sql = "SELECT * FROM paket_soal ORDER BY id_paket_soal";
        try (Connection conn = EducateDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) list.add(map(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public PaketSoal getById(int idPaket) {
        String sql = "SELECT * FROM paket_soal WHERE id_paket_soal = ?";
        try (Connection conn = EducateDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPaket);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) return map(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private PaketSoal map(ResultSet rs) throws SQLException {
        PaketSoal p = new PaketSoal();
        p.setIdPaketSoal(rs.getInt("id_paket_soal"));
        p.setNamaPaketSoal(rs.getString("nama_paket_soal"));
        p.setTingkatKesulitan(rs.getString("tingkat_kesulitan"));
        return p;
    }
}

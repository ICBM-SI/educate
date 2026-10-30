package dao;

import config.EducateDB;
import model.PendaftaranKelasOnline;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PendaftaranKelasDao {

    // Menyimpan data pendaftaran/pembelian kelas online oleh pelajar
    public boolean daftarKelas(PendaftaranKelasOnline pendaftaran) {
        String sql = "INSERT INTO pendaftaran_kelas_online (tanggal_pendaftaran, status_pembayaran, pelajar_id_pengguna, kelas_online_id_kelas_online) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = EducateDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setDate(1, java.sql.Date.valueOf(pendaftaran.getTanggalPendaftaran()));
            stmt.setString(2, pendaftaran.getStatusPembayaran());
            stmt.setInt(3, pendaftaran.getPelajarIdPengguna());
            stmt.setInt(4, pendaftaran.getKelasOnlineIdKelasOnline());
            
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
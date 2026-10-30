package dao;

import config.EducateDB; // Sesuaikan dengan nama kelas koneksi database Anda
import model.Pengguna;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PenggunaDao {

    // Fungsi untuk proses Login berdasarkan username dan password
    public Pengguna login(String username, String password) {
        Pengguna pengguna = null;
        String sql = "SELECT * FROM pengguna WHERE username = ? AND password = ?";
        
        try (Connection conn = EducateDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                pengguna = new Pengguna();
                pengguna.setIdPengguna(rs.getInt("id_pengguna"));
                pengguna.setNama(rs.getString("nama"));
                pengguna.setEmail(rs.getString("email"));
                pengguna.setUsername(rs.getString("username"));
                pengguna.setRole(rs.getString("role")); // Admin, Pengajar, atau Pelajar
                pengguna.setJenisKelamin(rs.getString("jenis_kelamin"));
                pengguna.setTanggalLahir(rs.getDate("tanggal_lahir").toLocalDate());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pengguna; // Mengembalikan objek pengguna jika ditemukan, atau null jika gagal
    }
}
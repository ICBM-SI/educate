package dao;

import config.EducateDB;
import model.Jawaban;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JawabanDao {
    private Connection connection;

    public JawabanDao() {
        this.connection = EducateDB.getConnection();
    }


    public boolean insert(Jawaban jawaban) {
        String query = "INSERT INTO jawaban (id_jawaban, id_latihan, id_pelajar, pilihan_jawaban, status) VALUES (?, ?, ?, ?, ?)";;
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, jawaban.getIdJawaban());
            stmt.setInt(2, jawaban.getIdLatihan());
            stmt.setInt(3, jawaban.getIdPelajar());
            stmt.setString(4, jawaban.getPilihanJawaban());
            stmt.setString(5, jawaban.getStatus());
            
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
            
        } catch (SQLException e) {
            System.out.println("Gagal menyimpan jawaban: " + e.getMessage());
            return false;
        }
    }


    public List<Jawaban> getByPelajar(int idPelajar) {
        List<Jawaban> listJawaban = new ArrayList<>();
        String query = "SELECT * FROM jawaban WHERE id_pelajar = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idPelajar);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Jawaban jwb = new Jawaban();
                jwb.setIdJawaban(rs.getInt("id_jawaban"));
                jwb.setIdLatihan(rs.getInt("id_latihan"));
                jwb.setIdPelajar(rs.getInt("id_pelajar"));
                jwb.setPilihanJawaban(rs.getString("pilihan_jawaban"));
                jwb.setStatus(rs.getString("status"));
                
                listJawaban.add(jwb);
            }
        } catch (SQLException e) {
            System.out.println("Gagal mengambil data jawaban: " + e.getMessage());
        }
        
        return listJawaban;
    }
}
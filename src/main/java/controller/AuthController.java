package controller;

import dao.PenggunaDao;
import model.Pengguna;

public class AuthController {
    private PenggunaDao dao = new PenggunaDao();

    // Logika pengecekan login dari Form Login (View)
    public Pengguna prosesLogin(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Username dan Password tidak boleh kosong!");
            return null;
        }
        
        Pengguna user = dao.login(username, password);
        if (user != null) {
            System.out.println("Login Berhasil! Selamat datang, " + user.getNama() + " (" + user.getRole() + ")");
        } else {
            System.out.println("Login Gagal! Username atau Password salah.");
        }
        return user;
    }
}
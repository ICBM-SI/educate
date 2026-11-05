package controller;

import dao.PenggunaDao;
import model.Pengguna;

public class AuthController {
    private PenggunaDao dao = new PenggunaDao();

    public Pengguna prosesLogin(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Username dan Password tidak boleh kosong!");
            return null;
        }

        Pengguna user = dao.login(username, password);
        if (user != null) {
            SessionManagerController.masuk(user);   // simpan siapa yang login
            System.out.println("Login Berhasil! Selamat datang, " + user.getNama() + " (" + user.getRole() + ")");
        } else {
            System.out.println("Login Gagal! Username atau Password salah.");
        }
        return user;
    }

    public void logout() {
        SessionManagerController.keluar();
    }
}
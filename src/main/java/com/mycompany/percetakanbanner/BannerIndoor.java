/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.percetakanbanner;

/**
 *
 * @author acer
 */
public class BannerIndoor extends PesananBanner {
    private String tipeLaminasi;
    private static final double HARGA_PER_METER = 45000;

    public BannerIndoor(String namaPelanggan, double panjang, double lebar, int jumlah, String tipeLaminasi) {
        super(namaPelanggan, panjang, lebar, jumlah);
        this.tipeLaminasi = tipeLaminasi;
    }

    public String getTipeLaminasi() {
        return this.tipeLaminasi;
    }

    public void setTipeLaminasi(String tipeLaminasi) {
        this.tipeLaminasi = tipeLaminasi;
    }

    @Override
    public double hitungTotalHarga() {
        double hargaDasar = hitungLuas() * HARGA_PER_METER * getJumlah();
        if (!tipeLaminasi.equalsIgnoreCase("Tanpa Laminasi")) {
            hargaDasar += (10000 * hitungLuas() * getJumlah());
        }
        return hargaDasar;
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[INDOOR]  Pelanggan: %-12s | Laminasi: %-12s | Ukuran: %.1fm x %.1fm | Jml: %d | Total: Rp%.0f%n",
                getNamaPelanggan(), this.tipeLaminasi, getPanjang(), getLebar(), getJumlah(), hitungTotalHarga());
    }

    @Override
    public void prosesCetak() {
        System.out.println(" -> Proses: Dicetak dengan Mesin Ecosolvent High-Res + Finishing Laminasi " + this.tipeLaminasi + ".");
    }
}

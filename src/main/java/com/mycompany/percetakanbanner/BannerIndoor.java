/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.percetakanbanner;

/**
 *
 * @author acer
 */
public class BannerIndoor extends PesananBanner implements DapatDinilai {
    private String tipeLaminasi;
    private static final double HARGA_PER_METER = 45000;

    public BannerIndoor(String namaPelanggan, double panjang, double lebar, int jumlah, String tipeLaminasi) throws Exception {
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
    public void hitungDendaKeterlambatan() {
        System.out.println(" -> Aturan Denda Keterlambatan Ambil: Rp15.000 / hari");
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[INDOOR]      Pelanggan: %-12s | Laminasi: %-12s | Ukuran: %.1fm x %.1fm | Jml: %d | Total: Rp%.0f%n",
                getNamaPelanggan(), this.tipeLaminasi, getPanjang(), getLebar(), getJumlah(), hitungTotalHarga());
    }

    @Override
    public void prosesCetak() {
        System.out.println(" -> Proses: Dicetak Mesin Ecosolvent High-Res + Press Finishing Laminasi " + this.tipeLaminasi + ".");
    }

    @Override
    public void beriRating(int bintang) {
        System.out.println(" -> Rating Pelanggan: Ketinggian resolusi indoor diberi rating " + bintang + "/5 bintang!");
    }
}

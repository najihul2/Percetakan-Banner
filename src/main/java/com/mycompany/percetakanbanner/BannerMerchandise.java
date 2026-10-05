/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.percetakanbanner;

/**
 *
 * @author acer
 */
public class BannerMerchandise extends PesananBanner {
    private String jenisKain;
    private static final double HARGA_PER_METER = 35000;

    public BannerMerchandise(String namaPelanggan, double panjang, double lebar, int jumlah, String jenisKain) {
        super(namaPelanggan, panjang, lebar, jumlah);
        this.jenisKain = jenisKain;
    }

    public String getJenisKain() {
        return this.jenisKain;
    }

    public void setJenisKain(String jenisKain) {
        this.jenisKain = jenisKain;
    }

    @Override
    public double hitungTotalHarga() {
        return hitungLuas() * HARGA_PER_METER * getJumlah();
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[MERCH/KAIN]  Pelanggan: %-12s | Kain: %-16s | Ukuran: %.1fm x %.1fm | Jml: %d | Total: Rp%.0f%n",
                getNamaPelanggan(), this.jenisKain, getPanjang(), getLebar(), getJumlah(), hitungTotalHarga());
    }

    @Override
    public void prosesCetak() {
        System.out.println(" -> Proses: Dicetak Tekstil Sublimasi & Finishing Jahit Obras Keliling.");
    }
}

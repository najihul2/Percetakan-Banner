/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.percetakanbanner;

/**
 *
 * @author acer
 */
public class BannerOutdoor extends PesananBanner implements DapatDipasang, DapatDinilai {
    private String jenisBahan;
    private static final double HARGA_PER_METER = 25000;

    public BannerOutdoor(String namaPelanggan, double panjang, double lebar, int jumlah, String jenisBahan) throws Exception {
        super(namaPelanggan, panjang, lebar, jumlah);
        this.jenisBahan = jenisBahan;
    }

    public String getJenisBahan() {
        return this.jenisBahan;
    }

    public void setJenisBahan(String jenisBahan) {
        this.jenisBahan = jenisBahan;
    }

    @Override
    public double hitungTotalHarga() {
        return hitungLuas() * HARGA_PER_METER * getJumlah();
    }

    @Override
    public void hitungDendaKeterlambatan() {
        System.out.println(" -> Aturan Denda Keterlambatan Ambil: Rp10.000 / hari");
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[OUTDOOR]     Pelanggan: %-12s | Bahan: %-15s | Ukuran: %.1fm x %.1fm | Jml: %d | Total: Rp%.0f%n",
                getNamaPelanggan(), this.jenisBahan, getPanjang(), getLebar(), getJumlah(), hitungTotalHarga());
    }

    @Override
    public void prosesCetak() {
        System.out.println(" -> Proses: Dicetak menggunakan Mesin Solvent Outdoor (Tahan Hujan & Panas Terik).");
    }

    @Override
    public void prosesPemasanganFisik() {
        System.out.println(" -> Pemasangan: Tim teknisi memasang banner outdoor di lokasi pelanggan.");
    }

    @Override
    public void beriRating(int bintang) {
        System.out.println(" -> Rating Pelanggan: Kualitas outdoor diberi rating " + bintang + "/5 bintang!");
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.percetakanbanner;

/**
 *
 * @author acer
 */
public abstract class PesananBanner {
    private String namaPelanggan;
    private double panjang;
    private double lebar;
    private int jumlah;

    public static int totalPesanan = 0;

    public PesananBanner(String namaPelanggan, double panjang, double lebar, int jumlah) throws Exception {
        if (panjang <= 0 || lebar <= 0) {
            throw new Exception("Ukuran panjang dan lebar banner harus lebih dari 0 meter!");
        }
        if (jumlah <= 0) {
            throw new Exception("Jumlah pemesanan banner minimal 1 pcs!");
        }
        this.namaPelanggan = namaPelanggan;
        this.panjang = panjang;
        this.lebar = lebar;
        this.jumlah = jumlah;
        totalPesanan++;
    }

    public String getNamaPelanggan() {
        return this.namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public double getPanjang() {
        return this.panjang;
    }

    public void setPanjang(double panjang) throws Exception {
        if (panjang <= 0) {
            throw new Exception("Panjang harus lebih dari 0!");
        }
        this.panjang = panjang;
    }

    public double getLebar() {
        return this.lebar;
    }

    public void setLebar(double lebar) throws Exception {
        if (lebar <= 0) {
            throw new Exception("Lebar harus lebih dari 0!");
        }
        this.lebar = lebar;
    }

    public int getJumlah() {
        return this.jumlah;
    }

    public void setJumlah(int jumlah) throws Exception {
        if (jumlah <= 0) {
            throw new Exception("Jumlah minimal 1!");
        }
        this.jumlah = jumlah;
    }

    public double hitungLuas() {
        return this.panjang * this.lebar;
    }

    public abstract double hitungTotalHarga();

    public abstract void hitungDendaKeterlambatan();

    public void tampilkanInfo() {
        System.out.printf("Pelanggan: %-15s | Ukuran: %.1fm x %.1fm | Jml: %d", 
                this.namaPelanggan, this.panjang, this.lebar, this.jumlah);
    }

    public void prosesCetak() {
        System.out.println(" -> Proses: Pesanan sedang dicetak pada mesin standar.");
    }
}

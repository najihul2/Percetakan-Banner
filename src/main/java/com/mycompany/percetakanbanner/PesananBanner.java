/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.percetakanbanner;

/**
 *
 * @author acer
 */
public class PesananBanner {
    private String namaPelanggan;
    private double panjang;
    private double lebar;
    private int jumlah;

    public static int totalPesanan = 0;

    public PesananBanner(String namaPelanggan, double panjang, double lebar, int jumlah) {
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

    public void setPanjang(double panjang) {
        if (panjang > 0) {
            this.panjang = panjang;
        } else {
            System.out.println("Panjang harus lebih dari 0!");
        }
    }

    public double getLebar() {
        return this.lebar;
    }

    public void setLebar(double lebar) {
        if (lebar > 0) {
            this.lebar = lebar;
        } else {
            System.out.println("Lebar harus lebih dari 0!");
        }
    }

    public int getJumlah() {
        return this.jumlah;
    }

    public void setJumlah(int jumlah) {
        if (jumlah > 0) {
            this.jumlah = jumlah;
        } else {
            System.out.println("Jumlah minimal 1!");
        }
    }

    public double hitungLuas() {
        return this.panjang * this.lebar;
    }

    public double hitungTotalHarga() {
        return 0;
    }

    public void tampilkanInfo() {
        System.out.printf("Pelanggan: %-15s | Ukuran: %.1fm x %.1fm | Jml: %d", 
                this.namaPelanggan, this.panjang, this.lebar, this.jumlah);
    }

    public void prosesCetak() {
        System.out.println("Pesanan sedang diproses di mesin cetak.");
    }
}

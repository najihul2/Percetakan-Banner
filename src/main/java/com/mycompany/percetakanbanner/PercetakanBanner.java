/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.percetakanbanner;
import java.util.Scanner;
/**
 *
 * @author acer
 */

public class PercetakanBanner {

    public static void cariPesanan(String nama, PesananBanner[] daftar, int jumlahData) {
        System.out.println("\n--- Hasil Pencarian Pelanggan: " + nama + " ---");
        boolean ditemukan = false;
        for (int i = 0; i < jumlahData; i++) {
            if (daftar[i].getNamaPelanggan().equalsIgnoreCase(nama)) {
                System.out.print((i + 1) + ". ");
                daftar[i].tampilkanInfo();
                daftar[i].prosesCetak();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Pesanan atas nama '" + nama + "' tidak ditemukan.");
        }
    }

    public static void cariPesanan(double minHarga, PesananBanner[] daftar, int jumlahData) {
        System.out.printf("\n--- Hasil Pencarian Pesanan dengan Total Harga >= Rp%.0f ---%n", minHarga);
        boolean ditemukan = false;
        for (int i = 0; i < jumlahData; i++) {
            if (daftar[i].hitungTotalHarga() >= minHarga) {
                System.out.print((i + 1) + ". ");
                daftar[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Tidak ada pesanan dengan total harga di atas nominal tersebut.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PesananBanner[] daftarPesanan = new PesananBanner[20];
        int jumlahPesanan = 0;
        boolean isRunning = true;

//        daftarPesanan[jumlahPesanan++] = new BannerOutdoor("Kedai Azkia", 3.0, 1.0, 2, "Flexi China 280g");
//        daftarPesanan[jumlahPesanan++] = new BannerIndoor("Toko Komputer", 2.0, 0.8, 1, "Glossy");
//        daftarPesanan[jumlahPesanan++] = new BannerOutdoor("Soto Bening", 4.0, 1.2, 1, "Flexi Korchin 380g");

        System.out.println("=================================================");
        System.out.println("   SELAMAT DATANG DI SISTEM PERCETAKAN BANNER   ");
        System.out.println("=================================================");

        while (isRunning) {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Tambah Pesanan Baru");
            System.out.println("2. Lihat Semua Pesanan");
            System.out.println("3. Cari Pesanan (Fitur Overloading)");
            System.out.println("4. Keluar");
            System.out.print("Pilih Menu (1-4): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> {
                    if (jumlahPesanan < daftarPesanan.length) {
                        System.out.println("\n--- Pilih Tipe Banner ---");
                        System.out.println("1. Banner Outdoor (Flexi Standard/Korchin)");
                        System.out.println("2. Banner Indoor (High-Res + Laminasi)");
                        System.out.print("Pilihan (1/2): ");
                        int tipe = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Masukkan Nama Pelanggan: ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan Panjang Banner (meter): ");
                        double panjang = scanner.nextDouble();
                        System.out.print("Masukkan Lebar Banner (meter): ");
                        double lebar = scanner.nextDouble();
                        System.out.print("Masukkan Jumlah (pcs): ");
                        int jumlah = scanner.nextInt();
                        scanner.nextLine();

                        if (tipe == 1) {
                            System.out.print("Masukkan Jenis Bahan (Flexi 280g / Korchin 380g): ");
                            String bahan = scanner.nextLine();
                            daftarPesanan[jumlahPesanan] = new BannerOutdoor(nama, panjang, lebar, jumlah, bahan);
                        } else if (tipe == 2) {
                            System.out.print("Masukkan Tipe Laminasi (Glossy / Doff / Tanpa Laminasi): ");
                            String laminasi = scanner.nextLine();
                            daftarPesanan[jumlahPesanan] = new BannerIndoor(nama, panjang, lebar, jumlah, laminasi);
                        } else {
                            System.out.println("Tipe tidak valid! Batal menambahkan.");
                            break;
                        }

                        jumlahPesanan++;
                        System.out.println(">> Sukses: Pesanan banner berhasil ditambahkan!");
                    } else {
                        System.out.println(">> Maaf, kapasitas penyimpanan pesanan sudah penuh!");
                    }
                }

                case 2 -> {
                    System.out.println("\n---------------- DAFTAR PESANAN BANNER ----------------");
                    if (jumlahPesanan == 0) {
                        System.out.println("Belum ada data pesanan yang tersimpan.");
                    } else {
                        for (int i = 0; i < jumlahPesanan; i++) {
                            System.out.print((i + 1) + ". ");
                            daftarPesanan[i].tampilkanInfo();
                            daftarPesanan[i].prosesCetak();
                            System.out.println();
                        }
                        System.out.println("Total Objek Pesanan Dibuat (Static Counter): " + PesananBanner.totalPesanan);
                    }
                    System.out.print("\nTekan Enter untuk melanjutkan...");
                    scanner.nextLine();
                }

                case 3 -> {
                    System.out.println("\n--- Fitur Cari Pesanan (Method Overloading) ---");
                    System.out.println("1. Cari Berdasarkan Nama Pelanggan (String)");
                    System.out.println("2. Cari Berdasarkan Total Harga Minimal (Double)");
                    System.out.print("Pilih Mode Cari (1/2): ");
                    int mode = scanner.nextInt();
                    scanner.nextLine();

                    if (mode == 1) {
                        System.out.print("Masukkan Nama Pelanggan: ");
                        String namaCari = scanner.nextLine();
                        cariPesanan(namaCari, daftarPesanan, jumlahPesanan);
                    } else if (mode == 2) {
                        System.out.print("Masukkan Minimal Total Harga (Rp): ");
                        double hargaCari = scanner.nextDouble();
                        scanner.nextLine();
                        cariPesanan(hargaCari, daftarPesanan, jumlahPesanan);
                    } else {
                        System.out.println("Pilihan mode tidak valid.");
                    }
                    System.out.print("\nTekan Enter untuk melanjutkan...");
                    scanner.nextLine();
                }

                case 4 -> {
                    System.out.println("\nTerima kasih telah menggunakan Sistem Percetakan Banner!");
                    isRunning = false;
                }

                default -> System.out.println("Pilihan tidak valid! Silakan masukkan angka 1-4.");
            }
        }
        scanner.close();
    }
}

//tes

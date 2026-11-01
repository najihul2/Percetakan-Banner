/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.percetakanbanner;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
/**
 *
 * @author acer
 */

public class PercetakanBanner {

    public static void prosesCetakBanner(PesananBanner item) {
        item.prosesCetak();
    }

    public static void cariPesanan(String nama, ArrayList<PesananBanner> daftar) throws PesananTidakDitemukanException {
        System.out.println("\n--- Hasil Pencarian Pelanggan: " + nama + " ---");
        boolean ditemukan = false;
        for (int i = 0; i < daftar.size(); i++) {
            if (daftar.get(i).getNamaPelanggan().equalsIgnoreCase(nama)) {
                System.out.print((i + 1) + ". ");
                daftar.get(i).tampilkanInfo();
                prosesCetakBanner(daftar.get(i));
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            throw new PesananTidakDitemukanException("Gagal: Pesanan atas nama '" + nama + "' tidak ditemukan di sistem!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<PesananBanner> daftarPesanan = new ArrayList<>();
        HashMap<String, String> dataPelanggan = new HashMap<>();
        boolean isRunning = true;

        try {
            daftarPesanan.add(new BannerOutdoor("Kedai Azkia", 3.0, 1.0, 2, "Flexi China 280g"));
            daftarPesanan.add(new BannerIndoor("Toko Komputer", 2.0, 0.8, 1, "Glossy"));
            daftarPesanan.add(new BannerMerchandise("Majelis Ta'lim", 4.0, 1.0, 3, "Kain TC Import"));
            daftarPesanan.add(new BannerOutdoor("Soto Bening", 4.0, 1.2, 1, "Flexi Korchin 380g"));
        } catch (Exception e) {
            System.out.println("Inisialisasi data gagal: " + e.getMessage());
        }

        dataPelanggan.put("CUST001", "Kedai Azkia");
        dataPelanggan.put("CUST002", "Toko Komputer");
        dataPelanggan.put("CUST003", "Majelis Ta'lim");

        System.out.println("=================================================");
        System.out.println("   SELAMAT DATANG DI SISTEM PERCETAKAN BANNER   ");
        System.out.println("=================================================");

        while (isRunning) {
            try {
                System.out.println("\n=== MENU UTAMA ===");
                System.out.println("1. Tambah Pesanan Baru (ArrayList)");
                System.out.println("2. Lihat Semua Pesanan (ArrayList & Dynamic Binding)");
                System.out.println("3. Cari Pesanan (Demo Custom Exception & Try-Catch-Finally)");
                System.out.println("4. Kelola Data Pelanggan Langganan (Demo HashMap)");
                System.out.println("5. Keluar");
                System.out.print("Pilih Menu (1-5): ");

                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1 -> {
                        System.out.println("\n--- Pilih Tipe Banner ---");
                        System.out.println("1. Banner Outdoor (Flexi 280g/Korchin)");
                        System.out.println("2. Banner Indoor (High-Res + Laminasi)");
                        System.out.println("3. Banner Merchandise (Kain / Sublim)");
                        System.out.print("Pilihan (1/2/3): ");
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
                            daftarPesanan.add(new BannerOutdoor(nama, panjang, lebar, jumlah, bahan));
                        } else if (tipe == 2) {
                            System.out.print("Masukkan Tipe Laminasi (Glossy / Doff / Tanpa Laminasi): ");
                            String laminasi = scanner.nextLine();
                            daftarPesanan.add(new BannerIndoor(nama, panjang, lebar, jumlah, laminasi));
                        } else if (tipe == 3) {
                            System.out.print("Masukkan Jenis Kain (Kain TC / Satin / Satin Inka): ");
                            String kain = scanner.nextLine();
                            daftarPesanan.add(new BannerMerchandise(nama, panjang, lebar, jumlah, kain));
                        } else {
                            System.out.println("Tipe tidak valid! Batal menambahkan.");
                            break;
                        }

                        System.out.println(">> Sukses: Pesanan banner berhasil ditambahkan ke ArrayList! (Total: " + daftarPesanan.size() + ")");
                    }

                    case 2 -> {
                        System.out.println("\n---------------- DAFTAR PESANAN BANNER ----------------");
                        if (daftarPesanan.isEmpty()) {
                            System.out.println("Belum ada data pesanan yang tersimpan.");
                        } else {
                            for (int i = 0; i < daftarPesanan.size(); i++) {
                                System.out.print((i + 1) + ". ");
                                daftarPesanan.get(i).tampilkanInfo();
                                prosesCetakBanner(daftarPesanan.get(i));
                                daftarPesanan.get(i).hitungDendaKeterlambatan();

                                if (daftarPesanan.get(i) instanceof DapatDipasang itemPasang) {
                                    itemPasang.prosesPemasanganFisik();
                                }

                                if (daftarPesanan.get(i) instanceof DapatDinilai itemNilai) {
                                    itemNilai.beriRating(5);
                                }

                                System.out.println();
                            }
                            System.out.println("Total Objek Pesanan Dibuat: " + PesananBanner.totalPesanan);
                        }
                        System.out.print("\nTekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                    }

                    case 3 -> {
                        System.out.println("\n--- Fitur Cari Pesanan ---");
                        System.out.print("Masukkan Nama Pelanggan yang dicari: ");
                        String namaCari = scanner.nextLine();

                        try {
                            cariPesanan(namaCari, daftarPesanan);
                        } catch (PesananTidakDitemukanException e) {
                            System.out.println("Peringatan Exception: " + e.getMessage());
                        } finally {
                            System.out.println("-> Sesi pencarian pesanan selesai dieksekusi.");
                        }

                        System.out.print("\nTekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                    }

                    case 4 -> {
                        System.out.println("\n-- Kelola Pelanggan Langganan (HashMap) --");
                        System.out.println("1. Tambah Member Baru (.put)");
                        System.out.println("2. Cari Member via ID (.containsKey & .get)");
                        System.out.println("3. Tampilkan Semua Member (.keySet)");
                        System.out.print("Pilih (1-3): ");
                        int menuMember = scanner.nextInt();
                        scanner.nextLine();

                        if (menuMember == 1) {
                            System.out.print("Masukkan ID Pelanggan (sebagai Key): ");
                            String id = scanner.nextLine();
                            System.out.print("Masukkan Nama Pelanggan (sebagai Value): ");
                            String namaMember = scanner.nextLine();
                            dataPelanggan.put(id, namaMember);
                            System.out.println(">> Berhasil menambahkan pelanggan langganan!");
                        } else if (menuMember == 2) {
                            System.out.print("Masukkan ID Pelanggan yang dicari: ");
                            String searchId = scanner.nextLine();
                            if (dataPelanggan.containsKey(searchId)) {
                                System.out.println("Ditemukan! Nama Pelanggan: " + dataPelanggan.get(searchId));
                            } else {
                                System.out.println("Pelanggan dengan ID '" + searchId + "' tidak terdaftar.");
                            }
                        } else if (menuMember == 3) {
                            System.out.println("Total Pelanggan Terdaftar: " + dataPelanggan.size());
                            for (String keyId : dataPelanggan.keySet()) {
                                System.out.println("- ID: " + keyId + " | Nama: " + dataPelanggan.get(keyId));
                            }
                        } else {
                            System.out.println("Pilihan menu member tidak valid.");
                        }

                        System.out.print("\nTekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                    }

                    case 5 -> {
                        System.out.println("\nTerima kasih telah menggunakan Sistem Percetakan Banner!");
                        isRunning = false;
                    }

                    default -> System.out.println("Pilihan tidak valid! Silakan masukkan angka 1-5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n[ERROR INPUT] Format input salah! Anda harus memasukkan angka.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("\n[ERROR SISTEM] Terjadi kesalahan: " + e.getMessage());
            }
        }
        scanner.close();
    }
}

//tes

package com.GroupProject.grup4;

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    static void display(){
        System.out.println("Selamat Datang di Program Team 4");
        System.out.println("1. Mencari Nilai Terkecil dan Terbesar");
        System.out.println("2. Mencari Elemen/Nilai Minus Terbesar yang Hilang");
        System.out.println("3. Cut The Bamboo");
        System.out.println("4. Mencari Nama yang Ganjil");
        System.out.println("5. Keluar");
    }

    static void findMinMax(){
        System.out.print("Masukkan deret angka sebanyak: ");
        int input = scan.nextInt();
        int[] x = new int[input];

        for (int i = 0; i < input; i++) {
            System.out.printf("Angka ke %d: \n", i+1);
            x[i] = scan.nextInt();
        }

        int dataMin = 0;
        int dataMax = 0;

        for (int j : x) {
            if (dataMin > j)
                dataMin = j;
        }

        for (int j : x) {
            if (dataMax < j)
                dataMax = j;
        }
        System.out.println("min: " + dataMin + " max: " + dataMax);
    }

    public static void main(String[] args) {
        int pilihan;

        do{
            display();
            pilihan = scan.nextInt();
            switch (pilihan){
                case 1: findMinMax();
                    break;
                case 2:
                    break;
                case 3: cutTheBamboo();
                    break;
                case 4: cariDanTampilkanNamaGanjil();
                    break;
                case 5: System.exit(1);
                    break;
                default:
                    System.out.println("Masukan pilihan yang ada saja !");
                    break;
            }
        }while(pilihan!=5);

    }

    public static void cariDanTampilkanNamaGanjil() {

        System.out.println("Aplikasi Sederhana Mencari Nama yang Ganjil by. AndriFP");
        System.out.println("--------------------------------------------------------");

        String teksInput;
        Scanner input = new Scanner(System.in);

        do {
            // Input teks dari pengguna
            System.out.print("Masukkan teks/kalimat: ");
            teksInput = input.nextLine().trim();
            if (!teksInput.isEmpty() && !teksInput.matches("[a-zA-Z\\s]+")) {
                System.out.println("Masukkan tidak valid. Mohon masukkan kata atau kalimat yang hanya mengandung huruf.");
            }
        } while (teksInput.isEmpty() || !teksInput.matches("[a-zA-Z\\s]+"));

        // Pisahkan kata-kata dalam inputan
        String[] kataKata = teksInput.split("\\s+");

        // Inisialisasi variabel untuk menyimpan nama ganjil
        String hasilPencarian = "";

        // Iterasi melalui setiap kata
        for (String kata : kataKata) {
            // Cek apakah panjang karakternya ganjil
            if (kata.length() % 2 == 1) {
                hasilPencarian += kata + ", ";
            }
        }

        // Tampilkan hasil
        if (!hasilPencarian.isEmpty()) {
            System.out.println("Output: " + hasilPencarian.substring(0, hasilPencarian.length() - 2));
            //menghilangkan spasi dan koma terakhir menggunakan substring
        } else {
            System.out.println("Tidak ada nama ganjil dalam teks.");
        }
    }

    public static void cutTheBamboo(){
        System.out.println("How many Bamboo?");
        int totBamboo = scan.nextInt();
        int[] bambooLength = new int[totBamboo];

        for (int i = 0; i < totBamboo; i++) {
            System.out.printf("Bamboo %d length : \n", i+1);
            bambooLength[i] = scan.nextInt();
        }
        System.out.println("How many cut cycle ?");
        int cutCycle = scan.nextInt();

        // Print Initials
        System.out.println("Initials");
        for (int i = 0; i < totBamboo; i++) {
            System.out.printf("|");
            for (int j = 0; j < bambooLength[i]; j++) {
                System.out.printf("-");
            }
            System.out.println();
        }

        // Print Cut Cycle
        for (int i = 0; i < cutCycle; i++) {
            System.out.printf("Cycle Cuts %d\n", i+1);
            // Bamboo Cutting
            for (int j = 0; j < totBamboo; j++) {
                System.out.printf("|");
                if(bambooLength[j] <= 0){
                    // If no more Bamboo, then Continue
                    System.out.println();
                    continue;
                }
                else {
                    bambooLength[j]-=1;
                }
                for (int k = 0; k < bambooLength[j]; k++) {
                    System.out.printf("-");
                }
                System.out.println();
            }
        }
    }
}

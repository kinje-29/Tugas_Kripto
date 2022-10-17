/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas3;

/**
 *
 * @author fajar
 */
public class HillChiper {

    static String[] abjad = {"A", "B", "C", "D", "E", "F", "G", "H",
        "I", "J", "K", "L", "M", "N", "O", "P", "Q",
        "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
        };

    static int[] angka = {0, 1, 2, 3, 4,
        5, 6, 7, 8, 9,
        10, 11, 12, 13, 14,
        15, 16, 17, 18, 19,
        20, 21, 22, 23, 24, 25
        };

    static int modulo = 26;

    static String[] teks2karakter;
    static String hasilKonversi[][];
    static String hasilHitungKunci[][];
    static String totalHasilEnkrip = "";

    public String hitungEnkripsi(String text, int[][] kunci) {
        System.out.println("Plaintext : " + text);
        // String hasilSpasi = hilangkanSpasi(text);
        hitungJumlahHuruf(text);
        pisahkanTeks(text);
        AbjadKeAngka(teks2karakter);
        perhitunganKunci(hasilKonversi, kunci);
        AngkaKeAbjad(hasilHitungKunci);

        return totalHasilEnkrip;
    }

    static String hilangkanSpasi(String text) {
        String hasil = text.replaceAll("\\s+", "");
        return hasil;
    }

    public int hitungJumlahHuruf(String text) {
        int jumlahHuruf = text.length();
        System.out.println("Jumlah huruf : " + jumlahHuruf);
        return jumlahHuruf;
    }

    static String pisahkanTeks(String text) {
        System.out.println("========== MEMBAGI TIAP 2 HURUF  ===========");
        String teksnya = text;
        if (teksnya.length() % 2 == 0) {
            teksnya = text;
        } else {
            teksnya = text + ".";
        }
        assert teksnya.length() % 2 == 0;
        teks2karakter = new String[teksnya.length() / 2];
        for (int index = 0; index < teks2karakter.length; index++) {
            teks2karakter[index] = teksnya.substring(index * 2, index * 2 + 2);
            System.out.println("["+teks2karakter[index]+"]");
        }
        return teksnya;
    }

    static String[][] AbjadKeAngka(String[] text) {
        hasilKonversi = new String[text.length][2];
        System.out.println("========== TRANSFORMASI HURUF KE ANGKA  ===========");
        for (int i = 0; i < text.length; i++) {
            String char1 = text[i].substring(0, 1);
            String char2 = text[i].substring(1);

            for (int j = 0; j < abjad.length; j++) {
                if (char1.equals(abjad[j])) {
                    char1 = String.valueOf(angka[j]);
                }
                if (char2.equals(abjad[j])) {
                    char2 = String.valueOf(angka[j]);
                }
            }

            if (hasilKonversi[i][0] == null) {
                hasilKonversi[i][0] = char1;

                if (hasilKonversi[i][1] == null) {
                    hasilKonversi[i][1] = char2;

                }
            }
        }

        for (int n = 0; n < hasilKonversi.length; n++) {
            for (int p = 0; p < hasilKonversi[0].length; p++) {
                System.out.print("["+hasilKonversi[n][p] +"]"+" ");
            }
            System.out.println("");
        }

        return hasilKonversi;
    }

    static String[][] perhitunganKunci(String[][] angka, int[][] kunci) {
        int kunciK0B0 = kunci[0][0];
        int kunciK0B1 = kunci[0][1];
        int kunciK1B0 = kunci[1][0];
        int kunciK1B1 = kunci[1][1];

        hasilHitungKunci = new String[angka.length][2];
        // int hasil = (kunci[0][0]*plain[0]) + (kunci[0][1]*plain[1]) ;
        // int hasil1 = (kunci[1][0]*plain[0]) + (kunci[1][1]*plain[1]) ;
        System.out.println("========== HASIL PERKALIAN KUNCI ===========");
        for (int n = 0; n < angka.length; n++) {
            int konvert = Integer.parseInt(angka[n][0]);
            int konvert1 = Integer.parseInt(angka[n][1]);
            int hasil = (kunciK0B0 * konvert) + (kunciK0B1 * konvert1);
            int hasil1 = (kunciK1B0 * konvert) + (kunciK1B1 * konvert1);
            
            System.out.println("["+hasil+"]" + " " + "["+hasil1+"]");
            
            hasil = hasil % modulo;
            hasil1 = hasil1 % modulo;
            
            
            //   System.out.println(hasil + " " + hasil1);

            if (hasilHitungKunci[n][0] == null) {
                hasilHitungKunci[n][0] = String.valueOf(hasil);
                if (hasilHitungKunci[n][1] == null) {
                    hasilHitungKunci[n][1] = String.valueOf(hasil1);
                }
            }
        }

        System.out.println("========== HASIL MODULO 26 ===========");
        
        for (int i = 0; i < hasilHitungKunci.length; i++) {
            for (int j = 0; j < hasilHitungKunci[0].length; j++) {
                System.out.print("["+hasilHitungKunci[i][j] +"]"+ " ");
            }
            System.out.println("");
        }
        return hasilHitungKunci;
    }

    static String AngkaKeAbjad(String[][] hasilHitungKunci) {

        String hasilEnkripsi = "";

        System.out.println("========== HASIL ENKRIPSI ===========");
        totalHasilEnkrip = "";
        for (int i = 0; i < hasilHitungKunci.length; i++) {
            for (int j = 0; j < hasilHitungKunci[0].length; j++) {
                // System.out.print(hasilHitungKunci[i][j]+" ");
                for (int k = 0; k < angka.length; k++) {
                    if (hasilHitungKunci[i][j].equals(String.valueOf(angka[k]))) {
                        hasilEnkripsi = abjad[k];
                        totalHasilEnkrip = totalHasilEnkrip + hasilEnkripsi;
                    }
                }
            }
        }
        System.out.println(totalHasilEnkrip);
        return totalHasilEnkrip;
    }

    public static void main(String[] args) {
        String text = "FAJARR";
        int[][] kunci = {{2,1}, {3,4}};
        new HillChiper().hitungEnkripsi(text, kunci);
    }
    
}

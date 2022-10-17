/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas1;

import java.util.Scanner;

/**
 *
 * @author fajar
 */
public class ChesarChiper {
    public static void main(String[] args) {
        Scanner m = new Scanner(System.in);
        String text;
        int key;        
        for(;;){
//            int masuk = Integer.parseInt(JOptionPane.showInputDialog("1. Enkrip 2. Deskrip 3. Exit"));
//            text = JOptionPane.showInputDialog("Masukan Teks : ");
//            key = Integer.parseInt(JOptionPane.showInputDialog("Masukan Key : "));
            
           // User Memilih
           System.out.println("1. Enkrip 2. Deskrip 3. Exit");
           System.out.print("Masukan Pilihan : ");
           int masuk = m.nextInt();
           // Input PlainText
           System.out.print("Masukan PlainText : ");
           text = m.next();
           //Input Key
           System.out.print("Masukan Key : ");
           key = m.nextInt();
           
           // Perulangan Switch Case
            switch (masuk) { // Inputan Masukan untuk memili
                // Jika masuk  = 1
                case 1:
                    // array chos = text
                    char[] chos = text.toCharArray();
                    // Perulangan for char variable 
                    for(char c : chos){
                        // C maju sesuai dengan key modulo 26
                        c += key % 26;
                        // Maka Cetak C
                        System.out.print(c);
                    }
                    System.out.print("\t<<<<<<<<<<< Enkrip\n");
                    break;
                case 2:
                    // Jika masuk = 2
                    // array choss = text
                    char[] choss = text.toCharArray();
                    // perulangan for char variable
                    for(char c : choss){
                        // c mundur sesuai dengan key modulo 26
                        c -= key % 26;
                        // Maka Cetak C
                        System.out.print(c);
                    }
                    System.out.print("\t<<<<<<<<<<<<<<< Deskrip\n");
                    break;
                case 3:
                    // Jika memili 3
                    // Maka System Berhenti
                    System.exit(0);
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
}

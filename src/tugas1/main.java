/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas1;

/**
 *
 * @author fajar
 */
public class main {
    private String keyExpanding(String mess, String key){
        String result = "";
        int i = 0;
        while(i < mess.length()){
            result += String.valueOf(key.charAt(i % key.length()));
            i++;
        }
        return result;
    }
    
    public String VigenereChiper(String plaintex, String key, boolean isEncod){
        String result = "";
        // --- Expending the key
        String keyE = keyExpanding(plaintex, key);
        // --- 
        for(int i = 0; i < plaintex.length(); i++){
            int x = (plaintex.charAt(i) + ( isEncod? keyE.charAt(i) : - keyE.charAt(i) + 26)) % 26;
            result += String.valueOf((char)(x + 65));
        }    
        return result;
    }
    

    
    public static void main(String[] args) {
        String plainText = "FAJAR";
        String key = "INODOS";
        
        main m = new main();
        System.out.println("PlainText : " + plainText);
        System.out.println("Key       : " + key);
        String cipherText = m.VigenereChiper(plainText, key, true);
        System.out.println("Chiper Text : " + cipherText);
        System.out.println("Plain Text : " + m.VigenereChiper(cipherText, key, false));
    }
}

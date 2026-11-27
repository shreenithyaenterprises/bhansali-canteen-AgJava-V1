package com.abc.utility;

import java.security.Key;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class AESCrypt {
	
	 private static final String ALGO = "AES";
	 private static final byte[] keyValue = 
		        new byte[] { 'T', 'h', 'e', 'B', 'e', 's', 't',
		'S', 'e', 'c', 'r','e', 't', 'K', 'e', 'y' };

	public static String encrypt(String Data) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(Data.getBytes());
        String encryptedValue = Base64.encodeBase64String(encVal);
        return encryptedValue;
    }

    public static String decrypt(String encryptedData) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = Base64.decodeBase64(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }
    private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGO);
        return key;
    }
    public static void main(String[] args)
    {
    	String encryptPass="";
    	String decryptPass="";
    	System.out.println("Enter Password String to be decrypted:");
    	Scanner scanner = new Scanner(System.in);
    	encryptPass = scanner.nextLine();
    	scanner.close();            
        try {
        	decryptPass=decrypt(encryptPass);
        	//decryptPass=encrypt(encryptPass);
        	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("encrypted password="+encryptPass);
        System.out.println("decrypted password="+decryptPass);
    }
}

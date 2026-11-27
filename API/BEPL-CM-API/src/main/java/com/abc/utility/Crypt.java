package com.abc.utility;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * The Class Crypt.
 */
public class Crypt {

	/** The Constant ALGO. */
	private static final String ALGO = "AES"; // Default uses ECB PKCS5Padding
	private static String secretKey="P@$$word@83423W";

	/**
	 * Encrypt.
	 *
	 * @param Data   the data
	 * @param secret the secret
	 * @return the string
	 * @throws Exception the exception
	 */
	public static String encrypt(String Data, String secret) throws Exception {
		Key key = generateKey(secret);
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encVal = c.doFinal(Data.getBytes());
		String encryptedValue = Base64.getEncoder().encodeToString(encVal);
		return encryptedValue;
	}
	public static String encrypt(String Data) throws Exception {
		Key key = generateKey(secretKey);
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encVal = c.doFinal(Data.getBytes());
		String encryptedValue = Base64.getEncoder().encodeToString(encVal);
		return encryptedValue;
	}
	/**
	 * Decrypt.
	 *
	 * @param strToDecrypt the str to decrypt
	 * @param secret       the secret
	 * @return the string
	 */
	public static String decrypt(String strToDecrypt, String secret) {
		try {
			Key key = generateKey(secret);
			Cipher cipher = Cipher.getInstance(ALGO);
			cipher.init(Cipher.DECRYPT_MODE, key);
			return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		} catch (Exception e) {
			System.out.println("Error while decrypting: " + e.toString());
		}
		return null;
	}

	/**
	 * Decrypt.
	 *
	 * @param strToDecrypt the str to decrypt
	 * @return the string
	 */
	public static String decrypt(String strToDecrypt) {

		try {
			//String secretKey = "volcano20201utlc";
			String secret = encodeKey(secretKey);
			Key key = generateKey(secret);
			Cipher cipher = Cipher.getInstance(ALGO);
			cipher.init(Cipher.DECRYPT_MODE, key);
			return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		} catch (Exception e) {
			System.out.println("Error while decrypting: " + e.toString());
		}
		return null;
	}

	/**
	 * Generate key.
	 *
	 * @param secret the secret
	 * @return the key
	 * @throws Exception the exception
	 */
	private static Key generateKey(String secret) throws Exception {
		byte[] decoded = Base64.getDecoder().decode(secret.getBytes());
		Key key = new SecretKeySpec(decoded, ALGO);
		return key;
	}

	/**
	 * Decode key.
	 *
	 * @param str the str
	 * @return the string
	 */
	public static String decodeKey(String str) {
		byte[] decoded = Base64.getDecoder().decode(str.getBytes());
		return new String(decoded);
	}

	/**
	 * Encode key.
	 *
	 * @param str the str
	 * @return the string
	 */
	public static String encodeKey(String str) {
		byte[] encoded = Base64.getEncoder().encode(str.getBytes());
		return new String(encoded);
	}
	
//	public static void main(String [] args ) {
//		String secretKey = "volcano20201utlc";
//		String secret = encodeKey(secretKey);
//		try {
//			System.out.println("token " + Crypt.encrypt("{\"user_id\":\"2112451\"}",secret));
//			System.out.println("verify " +Crypt.encrypt("{\"token\":\"eybHCHICnvdxEUvtWOAnTYfdPystG9pyxrwrvY0Ka8=\"}",secret));
//			System.out.println("payload " +Crypt.decrypt("UWP/m5VxqHm3yJu0+h9hARs7wR/2YAUnrkH8s3YAG9ULeNeD/z9PTX0pc3ZELwyQ"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}

}

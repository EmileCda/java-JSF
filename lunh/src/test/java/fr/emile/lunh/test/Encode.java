package fr.emile.lunh.test;

import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

public class Encode {

	public static final String ALGORITHM = "AES";
	public static final String CHARSET = "UTF8";

	private static Key genKey() throws NoSuchAlgorithmException {

		KeyGenerator keyGen = KeyGenerator.getInstance(Encode.ALGORITHM);

//		SecureRandom secRandom = new SecureRandom();// Creating a SecureRandom object
//		keyGen.init(secRandom); // other solution : Initializing the KeyGenerator witht random length  

		keyGen.init(256); // Initializing the KeyGenerator

		// Creating/Generating a key
		return keyGen.generateKey();

	}

//-----------------------------------------------------------------------------------------

	public static Key getKey() throws NoSuchAlgorithmException {

		Key keyFromDb = null;
		keyFromDb = Encode.getKeyFromDB(Encode.ALGORITHM);
		if (keyFromDb != null) {

			return keyFromDb;

		} else {

			return Encode.genKey();
		}
	}

//-----------------------------------------------------------------------------------------
	public static Key getKeyFromDB(String algo) {

		return null;
	}

//-----------------------------------------------------------------------------------------

	public static byte[] encrypt(byte[] toEncrypte, Key key) throws Exception {

		Cipher cipher = Cipher.getInstance(Encode.ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, key);
		return cipher.doFinal(toEncrypte);

	}

//-----------------------------------------------------------------------------------------
	public static byte[] encrypt(String String2Encrypte, Key key) throws Exception {

		byte[] messageByte = String2Encrypte.getBytes(CHARSET);
		return encrypt(messageByte, key);

	}

//-----------------------------------------------------------------------------------------
	public static byte[] decrypt(byte[] toDecrypte, Key key) throws Exception {

		Cipher cipher = Cipher.getInstance(Encode.ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, key);
		return cipher.doFinal(toDecrypte);

	}

//-----------------------------------------------------------------------------------------

}
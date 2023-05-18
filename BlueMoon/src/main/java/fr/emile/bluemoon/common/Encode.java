package fr.emile.bluemoon.common;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

public class Encode {

	public static final String ALGORITHM = "AES";
	public static final String CHARSET = "UTF8";

	public static Key genKey() throws NoSuchAlgorithmException {

		KeyGenerator keyGen = KeyGenerator.getInstance(Encode.ALGORITHM);

//		SecureRandom secRandom = new SecureRandom();// Creating a SecureRandom object
//		keyGen.init(secRandom); // other solution : Initializing the KeyGenerator witht random length  

		keyGen.init(56); // Initializing the KeyGenerator

		// Creating/Generating a key
		return keyGen.generateKey();

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
		return   encrypt(messageByte, key);

	}

//-----------------------------------------------------------------------------------------
	public static byte[] decrypt(byte[] toDecrypte, Key key) throws Exception {

		Cipher cipher = Cipher.getInstance(Encode.ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, key);
		return cipher.doFinal(toDecrypte);

	}

//-----------------------------------------------------------------------------------------

}
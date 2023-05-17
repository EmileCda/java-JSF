package fr.emile.lunh.adaptator;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import fr.emile.lunh.common.IConstant;
import fr.emile.lunh.entity.Admin;
import fr.emile.lunh.model.implement.AdminDao;
import fr.emile.lunh.model.interfaces.IAdminDao;
import fr.emile.lunh.utils.Utils;

public class ToBlob implements IConstant {
	public static final String ALGORITHM = "AES";
//	public static final String CHARSET = "UTF8";

// this method generate a new secretKey using algoritm and keylenght
	private static Key genKey() throws NoSuchAlgorithmException {

		KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
//		SecureRandom secRandom = new SecureRandom();// Creating a SecureRandom object
//		keyGen.init(secRandom); // other solution : Initializing the KeyGenerator witht random length  

		keyGen.init(KEY_LENGTH); // Initializing the KeyGenerator
		return keyGen.generateKey();  // Creating/Generating a key

	}

//-----------------------------------------------------------------------------------------
	public static Key getKey() throws NoSuchAlgorithmException {

//		1) retreive key from database
		Key keyFromDb = null;
		keyFromDb = ToBlob.getKeyFromDB(ALGORITHM);
//		2) if key retreived => return key
		if (keyFromDb != null) {

			return keyFromDb;

		} else {
//			else : generate new key and save in database
			Key newKey = ToBlob.genKey();
			ToBlob.saveKey(newKey);
			return newKey;
		}
	}

	// -----------------------------------------------------------------------------------------
	public static void saveKey(Key newKey) {
		
		Utils.trace("saveKey");
		Admin newAdmin = new Admin();
		newAdmin.setCrytoKey(newKey);
		newAdmin.setAlgorythm(ALGORITHM);
		newAdmin.setLentgh(KEY_LENGTH);
		newAdmin.setFunctionCode(FUNCTION_KEY_DB);
		IAdminDao myAdminDao = new AdminDao();
		try {
			myAdminDao.add(newAdmin);
			
		} catch (Exception e) {
			Utils.trace("Catch saveKey");
			e.printStackTrace();
		} 
	
	}

	// -----------------------------------------------------------------------------------------
	private static Key getKeyFromDB(String algo) {

		IAdminDao myAdminDao = new AdminDao();
		Admin myAdmin = null;

		try {
			myAdmin = new Admin();
			myAdmin = myAdminDao.getByFunctionCode(FUNCTION_KEY_DB);

		} catch (Exception e) {
			Utils.trace("Catch getKeyFromDB");
			e.printStackTrace();
		}
//		2 if key retreived => return key
		if (myAdmin != null) {
			return myAdmin.getCrytoKey();
		}
		return null;
	}

//-----------------------------------------------------------------------------------------

	public static byte[] encrypt(byte[] toEncrypte) throws Exception {

		Cipher cipher = Cipher.getInstance(ToBlob.ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, ToBlob.getKey());
		return cipher.doFinal(toEncrypte);

	}

//-----------------------------------------------------------------------------------------
	public static byte[] encrypt(String String2Encrypte) throws Exception {

		byte[] messageByte = String2Encrypte.getBytes(CHARSET);
		return encrypt(messageByte);

	}

//-----------------------------------------------------------------------------------------
	public static byte[] decrypt(byte[] toDecrypte) throws Exception {

		Cipher cipher = Cipher.getInstance(ToBlob.ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, ToBlob.getKey());
		return cipher.doFinal(toDecrypte);

	}

//-----------------------------------------------------------------------------------------
}

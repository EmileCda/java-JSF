package fr.emile.bluemoon.adaptator;

import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import fr.emile.bluemoon.common.IConstant;
import fr.emile.bluemoon.entity.Admin;
import fr.emile.bluemoon.model.implement.ZAdminDao;
import fr.emile.bluemoon.model.interfaces.IAdminDao;
import fr.emile.bluemoon.utils.Utils;

public class ToBlob implements IConstant {

	// -----------------------------------------------------------------------------------------
// this method generate a new secretKey using algoritm and keylenght
	private static Key genKey() throws NoSuchAlgorithmException {

		KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
//		SecureRandom secRandom = new SecureRandom();// Creating a SecureRandom object
//		keyGen.init(secRandom); // other solution : Initializing the KeyGenerator witht random length  

		keyGen.init(KEY_LENGTH); // Initializing the KeyGenerator
		return keyGen.generateKey(); // Creating/Generating a key

	}

//-----------------------------------------------------------------------------------------
// this method retreive the encryption key. 
// retrevie from database if existed or generat a new key if not
	private static Key getKey() throws NoSuchAlgorithmException {

		Key keyFromDb = null;
		keyFromDb = ToBlob.getKeyFromDB(ALGORITHM); // 1) retreive key from database

		if (keyFromDb != null) { // 2) if key retreived => return key
			return keyFromDb;
		} else { // else : generate new key and save in database

			Key newKey = ToBlob.genKey();
			ToBlob.saveKey(newKey);
			return newKey;
		}
	}

// -----------------------------------------------------------------------------------------
// this method save the encryption key as a byte[], conversion is done in setCrytoKey(newKey) method
	public static void saveKey(Key newKey) {

		Utils.trace("saveKey");
		Admin newAdmin = new Admin();
		newAdmin.setCrytoKey(newKey);
		newAdmin.setAlgorythm(ALGORITHM);
		newAdmin.setLentgh(KEY_LENGTH);
		newAdmin.setFunctionCode(FUNCTION_KEY_DB);
		IAdminDao myAdminDao = new ZAdminDao();
		try {
			myAdminDao.add(newAdmin);

		} catch (Exception e) {
			Utils.trace("Catch saveKey");
			e.printStackTrace();
		}

	}

// -----------------------------------------------------------------------------------------
// try to retreive crypto key from database.
// each record in this table has a unique fonction_code.
// return null if function_code do not exist in database	

	private static Key getKeyFromDB(String algo) {

		IAdminDao myAdminDao = new ZAdminDao();
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
// ecrypt a byte[]
	public static byte[] encrypt(byte[] toEncrypte) throws Exception {

		Cipher cipher = Cipher.getInstance(ToBlob.ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, ToBlob.getKey());
		return cipher.doFinal(toEncrypte);

	}

//-----------------------------------------------------------------------------------------
// encrypt a string 	
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
	public static String decrypt2String(byte[] toDecrypte) throws Exception {

		Cipher cipher = Cipher.getInstance(ToBlob.ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, ToBlob.getKey());
		return new String(cipher.doFinal(toDecrypte), CHARSET);

	}

//-----------------------------------------------------------------------------------------
}

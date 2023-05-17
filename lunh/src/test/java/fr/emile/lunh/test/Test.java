package fr.emile.lunh.test;

import java.security.Key;
import java.security.NoSuchAlgorithmException;

import fr.emile.lunh.adaptator.ToBlob;
import fr.emile.lunh.utils.Utils;

public class Test {
	
	
	public static void main(String[] args) {
		
		
		final String myString = "texte libre avec des accents si possible";
		byte[] encoded = null; 
		byte[] decoded = null; 
		String stringDecode="";
		Key mykey;
		try {
			mykey = ToBlob.getKey();
			
			byte[] resultEncoded;

			resultEncoded = ToBlob.encrypt(myString, mykey);
			
			encoded = resultEncoded; 

			byte[] resultDecoded = ToBlob.decrypt(encoded,mykey);
			decoded = resultDecoded;
			stringDecode = new String (decoded,ToBlob.CHARSET );
			
			Utils.trace("originale :"+ myString);
			Utils.trace("decode :"+stringDecode);

			
		} catch (NoSuchAlgorithmException e) {
			Utils.trace("error algorythme");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			
		}
		
	}
				

}

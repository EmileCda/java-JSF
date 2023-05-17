package fr.emile.lunh.test;

import fr.emile.lunh.adaptator.ToBlob;
import fr.emile.lunh.common.IConstant;
import fr.emile.lunh.utils.Utils;

public class TestToBlob implements IConstant {
	public static void main(String[] args) {
		
		
		byte[] textEcrypted = null;
		String resultat ="";
		try {
			Utils.trace("encrytion start");
			byte[]  newTextEcrypted = ToBlob.encrypt(DEFAULT_TEXT);
			textEcrypted = newTextEcrypted ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Utils.trace("encrytion done");
		
		try {
			byte[] textDecrypted = ToBlob.decrypt(textEcrypted);
			Utils.trace("decrytion start");
			resultat = new String (textDecrypted,CHARSET );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			Utils.trace("decrytion done");
			Utils.trace("orignal:"+DEFAULT_TEXT);
			Utils.trace("decrypted:"+ resultat);
			
		}
 		
	}
}

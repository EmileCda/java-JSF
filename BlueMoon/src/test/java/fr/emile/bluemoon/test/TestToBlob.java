package fr.emile.bluemoon.test;

import java.util.logging.Level;

import fr.emile.bluemoon.adaptator.ToBlob;
import fr.emile.bluemoon.common.IConstant;
import fr.emile.bluemoon.utils.Utils;

public class TestToBlob implements IConstant {
	public static void main(String[] args) {
		
//		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
		
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
			Utils.trace( ToBlob.decrypt2String(textEcrypted));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			Utils.trace("decrytion done");
			Utils.trace("orignal  :"+DEFAULT_TEXT);
			Utils.trace("decrypted:"+ resultat);
			
		}
 		
	}
}

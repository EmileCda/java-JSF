package fr.emile.bluemoon.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.util.Arrays;

import javax.crypto.spec.SecretKeySpec;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import fr.emile.bluemoon.common.IConstant;

//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "admin", propOrder = { "id", "blobKey", "algorythm", "function_code","lentgh" })

@Entity
//@Table(name = "admin")
public class Admin implements Serializable, IConstant {
	private static final long serialVersionUID = -5796619001987955526L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
//	@Column(columnDefinition = "BLOB NOT NULL")
	private byte[] blobKey;

	@Transient
	@XmlTransient
	private Key crytoKey;
	private String algorythm;

	private int lentgh;

	@Column(name = "function_code", nullable = false, unique = true)
	private int functionCode;

	public Admin(Integer id, String algorythm, Key key, int functionCode){

		this.setId(id);
		this.setAlgorythm(algorythm);
		this.setCrytoKey(key);
		this.setFunctionCode(functionCode);

	}

	public Admin()  {
		this(-1, "", null, -1);
	}


	private Key byte2Key(byte[] byteKey) {
		
		return new SecretKeySpec(byteKey, "AES");
		
	}
	
	private byte[]   key2byte(Key myKey) {
		
		if (crytoKey != null)
			return myKey.getEncoded();
		
		return null; 
		
	}
	
//-------------------------------------------------------------------------------------------------	
// this methode create the secret key from blog retreive from database
	
	public void setKey() {
	
		
		this.setCrytoKey(this.getBlobKey());
	}



public Integer getId() {
	return id;
}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte[] getBlobKey() {
		return blobKey;
	}

	private void setBlobKey(byte[] blobKey) {
		this.blobKey = blobKey;
	}

	public String getAlgorythm() {
		return algorythm;
	}

	public void setAlgorythm(String algorythm) {
		this.algorythm = algorythm;
	}

	public Key getCrytoKey() {
		return crytoKey;
	}

	public void setCrytoKey(byte[] crytoKeyFromDB) {
		// https://stackoverflow.com/questions/20233775/how-to-generate-secret-key-in-java-once-and-use-that-key-in-2-different-programs

		this.setCrytoKey( this.byte2Key(crytoKeyFromDB));
	}

	public void setCrytoKey(Key crytoKey) {
		this.crytoKey = crytoKey;

		this.setBlobKey(this.key2byte(crytoKey));
	}

	public int getFunctionCode() {
		return functionCode;
	}

	public void setFunctionCode(int functionCode) {
		this.functionCode = functionCode;
	}

	@Override
	public String toString() {
		
		if (this.getCrytoKey() == null )
			return "key is null";
		else
		
		return String.format("id:%d,%d blob %s %s", 
				getId(), getFunctionCode(), Arrays.toString(getBlobKey()),
				getAlgorythm()); 
				

	}

	public int getLentgh() {
		return lentgh;
	}

	public void setLentgh(int lentgh) {
		this.lentgh = lentgh;
	}
}

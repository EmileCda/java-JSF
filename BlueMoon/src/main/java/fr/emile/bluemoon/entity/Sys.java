package fr.emile.bluemoon.entity;

import java.io.Serializable;
import java.security.Key;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlInlineBinaryData;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import fr.emile.bluemoon.common.IConstant;


@Entity
@XmlInlineBinaryData
@Table(name = "sys")
@XmlRootElement
public class Sys implements Serializable, IConstant {



	private static final long serialVersionUID = 8162782036108905382L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	private byte[] blobKey;
	@Transient
	@XmlTransient
	private Key crytoKey;
	private String algorythm;

	private int lentgh;

	@Column(name = "function_code", nullable = false, unique = true)
	private int functionCode;

	
	
	
	public Sys() {
		// TODO Auto-generated constructor stub
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

	public void setBlobKey(byte[] blobKey) {
		this.blobKey = blobKey;
	}

	public Key getCrytoKey() {
		return crytoKey;
	}

	public void setCrytoKey(Key crytoKey) {
		this.crytoKey = crytoKey;
	}

	public String getAlgorythm() {
		return algorythm;
	}

	public void setAlgorythm(String algorythm) {
		this.algorythm = algorythm;
	}

	public int getLentgh() {
		return lentgh;
	}

	public void setLentgh(int lentgh) {
		this.lentgh = lentgh;
	}

	public int getFunctionCode() {
		return functionCode;
	}

	public void setFunctionCode(int functionCode) {
		this.functionCode = functionCode;
	}

	@Override
	public String toString() {
		return "Sys [getId()=" + getId() + ", getBlobKey()=" + Arrays.toString(getBlobKey()) + ", getCrytoKey()="
				+ getCrytoKey() + ", getAlgorythm()=" + getAlgorythm() + ", getLentgh()=" + getLentgh()
				+ ", getFunctionCode()=" + getFunctionCode() + "]";
	}



	
	
}

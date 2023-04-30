package fr.emile.jsfthree.entity;

import java.util.Date;

import fr.emile.jsfthree.common.IConstant;
import fr.emile.jsfthree.utils.Utils;

public class BankCard implements IConstant {
	private int id;
	private String cardNumber;
	private Date expiryDate;
	private String crypto;
	private String belongTo;
	private boolean isValid;
	private boolean isDeleted;
	private int userId;

	// ------------------------ constructor --------------
	/**
	 * @param id
	 * @param cardNumber
	 * @param expiryDate
	 * @param crypto
	 * @param isValid
	 * @param isdeleted
	 */
	public BankCard(int id, String cardNumber, Date expiryDate, 
			String crypto, boolean isValid, boolean isdeleted,
			int userId, String belongTO) {
		this.setId(id);
		this.setCardNumber(cardNumber);
		this.setExpiryDate(expiryDate);
		this.setCrypto(crypto);
		this.setValid(isValid);
		this.setDeleted(isdeleted);
		this.setUserId(userId);
		this.setBelongTo(belongTO);
	}

	public BankCard(String cardNumber, Date expiryDate, String crypto, int userId) {
		this(DEFAULT_ID, cardNumber, expiryDate, crypto, 
				DEFAULT_IS_VALIDE, DEFAULT_IS_DELETE, userId,DEFAULT_FIRSTNAME + " " + DEFAULT_LASTTNAME);
	}

	public BankCard(String cardNumber, Date expiryDate, String crypto) {
		this(DEFAULT_ID, cardNumber, expiryDate, crypto, DEFAULT_IS_VALIDE, DEFAULT_IS_DELETE, DEFAULT_ID,
				DEFAULT_FIRSTNAME + " " + DEFAULT_LASTTNAME);
	}

	public BankCard() {
		this(DEFAULT_ID, DEFAULT_BANK_CARD_NUMBER, NULL_DATE, DEFAULT_BANK_CARD_CRYPTO, DEFAULT_IS_VALIDE,
				DEFAULT_IS_DELETE, DEFAULT_ID,DEFAULT_FIRSTNAME + " " + DEFAULT_LASTTNAME);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCrypto() {
		return crypto;
	}

	public void setCrypto(String crypto) {
		this.crypto = crypto;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isdeleted) {
		this.isDeleted = isdeleted;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String belongTo() {
		return belongTo;
	}

	public void setBelongTo(String belongTo) {
		this.belongTo = belongTo;
	}

	@Override
	public String toString() {

		String result = String.format("BC(%d) %s %s ", this.getId(), this.belongTo(), this.getCardNumber());

		try {
			result += String.format("exp %s ", Utils.date2String(this.getExpiryDate(), "MM/yy"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		result += String.format("[%s] {%s,%s}  userId : %d", 
				this.getCrypto(), this.isValid() ? "Valid" : "inValid",
				this.isDeleted() ? "deleted" : "in use", this.getUserId());

		return result;
	}
}

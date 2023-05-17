package fr.emile.lunh.common;

import java.util.Date;

import fr.emile.lunh.enums.Gender;

public interface IConstant {

//	public final String  DEFAULT_TEXT = "Et je m’en vais au vent mauvais Qui m’emporte Deçà, delà,Pareil à la Feuille morte." ;
	public final String  DEFAULT_TEXT = "je passe ma vie avec Momo et Kawtar";
	
	
	public final String  DEFAULT_BANK_CARD_NUMBER = "1000200030004000" ;
	public final String  DEFAULT_BANK_CARD_CRYPTO = "XYZ" ;
	public final String  DEFAULT_FIRSTNAME = "No-Firstname" ;
	public final String  DEFAULT_LASTTNAME = "No-Lastname" ;

	public final String  DEFAULT_ADDRESS_NUMBER = "No-Number" ;
	public final String  DEFAULT_ADDRESS_STREET = "No-street" ;
	public final String  DEFAULT_ADDRESS_CITY = "No-City" ;
	public final String  DEFAULT_ADDRESS_ZIP_CODE = "AXBXC" ;
	public final String  DEFAULT_EMAIL= "no-mail@no-mail.no" ;

	public final Boolean  DEFAULT_IS_VALIDE= true;
	public final Boolean DEFAULT_IS_DELETE= false;
	public final Integer DEFAULT_ID = -1 ;
	public final Date NULL_DATE = null ;
	public final Gender DEFAULT_GENDER = Gender.OTHERS ;
	public final String CHARSET = "UTF8";
	public static final String ALGORITHM = "AES";
	public static final int FUNCTION_KEY_DB = 1705;
	public static final int KEY_LENGTH = 256;
	

//	public final Address NULL_ADDRESS = null ;
//	public final BankCard NULL_BANKCARD = null ;
//	
//	public final DeliveryMethod DEFAULT_DELIVERY = DeliveryMethod.NULL ;
//	public final OrderStatus DEFAULT_STATUS= OrderStatus.NULL ;
}

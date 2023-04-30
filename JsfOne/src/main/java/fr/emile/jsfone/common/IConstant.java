package fr.emile.jsfone.common;

import java.util.Date;

import fr.emile.jsfone.entity.Address;
import fr.emile.jsfone.entity.BankCard;
import fr.emile.jsfone.enums.DeliveryMethod;
import fr.emile.jsfone.enums.OrderStatus;
import fr.emile.jsfone.enums.Gender;
import fr.emile.jsfone.enums.ServiceLevel;


public interface IConstant {


	public final String  DEFAULT_BANK_CARD_NUMBER = "1000200030004000" ;
	public final String  DEFAULT_BANK_CARD_CRYPTO = "XYZ" ;
	public final String  DEFAULT_FIRSTNAME = "No-Firstname" ;
	public final String  DEFAULT_LASTNAME = "No-Lastname" ;

	public final String  DEFAULT_ADDRESS_NUMBER = "No-Number" ;
	public final String  DEFAULT_ADDRESS_STREET = "No-street" ;
	public final String  DEFAULT_ADDRESS_CITY = "No-City" ;
	public final String  DEFAULT_ADDRESS_ZIP_CODE = "AXBXC" ;
	
	public final Gender  DEFAULT_GENDER = Gender.UNDEFINED;
	public final String  DEFAULT_EMAIL = "";
	public final ServiceLevel  DEFAULT_SERVICE_LEVEL= ServiceLevel.BASIC;

	public final boolean  DEFAULT_IS_VALIDE= true;
	public final boolean DEFAULT_IS_DELETE= false;
	public final int DEFAULT_ID = -1 ;
	public final Date NULL_DATE = null ;
	public final Address NULL_ADDRESS = null ;
	public final BankCard NULL_BANKCARD = null ;
	
	public final DeliveryMethod DEFAULT_DELIVERY = DeliveryMethod.NULL ;
	public final OrderStatus DEFAULT_STATUS= OrderStatus.NULL ;
	
}

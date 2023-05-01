package fr.emile.jsfsix.common;

import java.util.Date;

import fr.emile.jsfsix.entity.Address;
import fr.emile.jsfsix.entity.BankCard;
import fr.emile.jsfsix.enums.DeliveryMethod;
import fr.emile.jsfsix.enums.OrderStatus;

public interface IConstant {

	public final String  DEFAULT_BANK_CARD_NUMBER = "1000200030004000" ;
	public final String  DEFAULT_BANK_CARD_CRYPTO = "XYZ" ;
	public final String  DEFAULT_FIRSTNAME = "No-Firstname" ;
	public final String  DEFAULT_LASTTNAME = "No-Lastname" ;

	public final String  DEFAULT_ADDRESS_NUMBER = "No-Number" ;
	public final String  DEFAULT_ADDRESS_STREET = "No-street" ;
	public final String  DEFAULT_ADDRESS_CITY = "No-City" ;
	public final String  DEFAULT_ADDRESS_ZIP_CODE = "AXBXC" ;
	public final String  DATE_FORMAT= "dd/MM/yyyy" ;

	public final boolean  DEFAULT_IS_VALIDE= true;
	public final boolean DEFAULT_IS_DELETE= false;
	public final int DEFAULT_ID = -1 ;
	public final Date NULL_DATE = null ;
	public final Address NULL_ADDRESS = null ;
	public final BankCard NULL_BANKCARD = null ;

	public final DeliveryMethod DEFAULT_DELIVERY = DeliveryMethod.NULL ;
	public final OrderStatus DEFAULT_STATUS= OrderStatus.NULL ;

}

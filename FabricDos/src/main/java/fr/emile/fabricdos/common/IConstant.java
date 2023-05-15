package fr.emile.fabricdos.common;
import javax.ws.rs.core.MediaType;

public interface IConstant {

	public final String  DEFAULT_BANK_CARD_NUMBER = "1000200030004000" ;
	public final Integer DEFAULT_ID = -1 ;
	public final Integer DEFAULT_AGE = -1 ;
	public final String CHARSET_UTF8 = " charset=UTF-8";
	public final String MEDIA_TYPE_JSON = MediaType.APPLICATION_JSON + ";" + CHARSET_UTF8; 
	public final String MEDIA_TYPE_XML = MediaType.APPLICATION_XML + ";" + CHARSET_UTF8; 
	public final String CRUD_C = "add"; 
	public final String CRUD_R = "read"; 
	public final String CRUD_U = "update"; 
	public final String CRUD_D = "delete"; 
	public final String LINK_SERVER = "http://localhost:9991/fabricdos"; 
	public final String ENTITY_CLASS = "/employee"; 
	public final String PACK_NAME = "fr.emile.fabricdos.server";
	public final String BY_ID		= "/id";
	public final String BY_EMAIL 	=  "/email";
	public final String BY_LIST 	= "/list";
	
}

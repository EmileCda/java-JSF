package fr.emile.bluemoon.test;


import java.util.Date;

import fr.emile.bluemoon.entity.DataTest;
import fr.emile.bluemoon.enums.Gender;
import fr.emile.bluemoon.utils.Utils;

public class MainData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Gender gender = DataTest.gender();

		Date startDate = Utils.string2Date("25/06/1965","dd/MM/yyyy");
		Date endDate = Utils.string2Date("25/06/2023","dd/MM/yyyy");
		Utils.trace(String.format("%s %s %s: %s %s, %s %s %s %s. née le : %s ",
				gender.getTitle(),
				DataTest.firstname(gender),
				DataTest.lastname(),
				DataTest.number(),
				DataTest.numberType(),
				DataTest.streetType(),
				DataTest.street(),
				DataTest.zipcode(),
				DataTest.city(),
				Utils.date2String(DataTest.date(startDate,endDate),"dd/MM/yyyy"))
				);
		
		
		
		
		
	}

}

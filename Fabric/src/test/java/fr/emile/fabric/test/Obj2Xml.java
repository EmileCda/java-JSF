package fr.emile.fabric.test;

import fr.emile.fabric.common.DataTest;
import fr.emile.fabric.common.Utils;
import fr.emile.fabric.entity.Employee;
import fr.emile.fabric.utils.Strings;

public class Obj2Xml {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Employee myEmployee = new Employee(DataTest.firstname(),DataTest.lastname());
		
		
		Utils.trace(myEmployee.toString()) ;
		
		
		System.out.println(Strings.getXlmEmployee(myEmployee));
		System.out.println(Strings.getJsonEmploye(myEmployee));
		

	}

}

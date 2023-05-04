package fr.emile.jsfsix.backingbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIInput;

@ManagedBean(name = "testBean", eager = true)
@SessionScoped
public class TestBean {

	private UIInput widgetName;
	private String name;
	private String password;
	private String choice[];



	public TestBean() {

		this.setName("name-toto");
		this.setPassword("pass");
		System.out.println("TestBean");

	}


	public String[] getChoice() {
		return choice;
	}


	public String getName() {
		return name ;
	}
	public String getPassword() {
		return password;
	}
	public UIInput getWidgetName() {
		return widgetName;
	}
	public void setChoice(String[] choice) {
		this.choice = choice;
	}
	public void setName(String name) {
		this.name = name ;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public void setWidgetName(UIInput widgetName) {
		this.widgetName = widgetName;
	}


	public void activate () {
		System.out.println("public void activate");
		List<String> myList = new ArrayList<String>();
		String value = "JAVA;PHP;CSHARP;" ;
		
		String lang[]=value.split(";");
		
		for (String string : lang) {
			System.out.printf("lan %s\n",string);
			
		}
		System.out.printf("mylist %s \n",myList);
		
		
		String str = "J'aime le Java";
        String[] words = str.split(" ");
        for (String word : words) {
            System.out.println(word);
        }
		
	}
	public void submit() {
//		System.out.println("public void submit");
		System.out.println(this.toString());
	}

	@Override
	public String toString() {

		String returnValue = String.format("name %s pass:%s",this.getName(), this.getPassword());

		for (String string : choice) {
			returnValue += " " + string ;
		}
		return returnValue;
	}



}

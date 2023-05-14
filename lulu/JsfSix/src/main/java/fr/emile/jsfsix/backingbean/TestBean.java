package fr.emile.jsfsix.backingbean;

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

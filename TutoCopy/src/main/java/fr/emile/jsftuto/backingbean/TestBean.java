package fr.emile.jsftuto.backingbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIInput;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.eclipse.jdt.internal.compiler.ast.ForeachStatement;

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
	
	
	public void submit() {
//		System.out.println("public void submit");
		System.out.println(this.toString());
	}
	
	
	public UIInput getWidgetName() {
		return widgetName;
	}
	public void setWidgetName(UIInput widgetName) {
		this.widgetName = widgetName;
	}
	public String getName() {
		return name ;
	}
	public void setName(String name) {
		this.name = name ;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public String[] getChoice() {
		return choice;
	}


	public void setChoice(String[] choice) {
		this.choice = choice;
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

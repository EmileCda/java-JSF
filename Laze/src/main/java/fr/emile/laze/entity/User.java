package fr.emile.laze.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Columns;

@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "User.getAll", query = "Select u from user u"),
		@NamedQuery(name = "User.getById", query = "Select u from user u where u.id = :id"),
		@NamedQuery(name = "User.getByLastname", query = "Select u from user u where u.lastname = :lastname") })

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@GeneratedValue
	@Id
	@Basic(optional = false)
	@Columns(name = "id")
	private Integer id;
	@Basic(optional = false)
	@Columns(name = "id")
	private String firstname;
	@Id
	@Basic(optional = false)
	@Columns(name = "id")
	private String lasttname;
	@Id
	@Basic(optional= false)
	@Columns(name= "id")
	private Date birthdate;
	@Id
	@Basic(optional= false)
	@Columns(name= "id")
	private boolean isDeleted ;
	
	
	public User(Integer id, String firstname, String lasttname, Date birthdate, boolean isDeleted) {
		this.setId ( id);
		this.setFirstname ( firstname);
		this.setLasttname ( lasttname);
		this.setBirthdate ( birthdate);
		this.setDeleted ( isDeleted);
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLasttname() {
		return lasttname;
	}
	public void setLasttname(String lasttname) {
		this.lasttname = lasttname;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Version
	protected Integer version;


	public Integer getVersion() {
		return version;
	}


	public void setVersion(Integer version) {
		this.version = version;
	}

	
	
}

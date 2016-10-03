package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
@Table(name="USERS")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long userid;

	private String useremail;

	private String username;

	private String userpassword;

	private String userrole;

	//bi-directional many-to-one association to Gradebook
	@OneToMany(mappedBy="user")
	private List<Gradebook> gradebooks;

	public User() {
	}

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getUseremail() {
		return this.useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return this.userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getUserrole() {
		return this.userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

	public List<Gradebook> getGradebooks() {
		return this.gradebooks;
	}

	public void setGradebooks(List<Gradebook> gradebooks) {
		this.gradebooks = gradebooks;
	}

	public Gradebook addGradebook(Gradebook gradebook) {
		getGradebooks().add(gradebook);
		gradebook.setUser(this);

		return gradebook;
	}

	public Gradebook removeGradebook(Gradebook gradebook) {
		getGradebooks().remove(gradebook);
		gradebook.setUser(null);

		return gradebook;
	}

}
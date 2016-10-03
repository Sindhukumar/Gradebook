package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GRADEBOOK database table.
 * 
 */
@Entity
@NamedQuery(name="Gradebook.findAll", query="SELECT g FROM Gradebook g")
public class Gradebook implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long gradebookid;

	private String assignment;

	private String assignmenttype;

	private String grade;

	private String subject;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="USERID")
	private User user;

	public Gradebook() {
	}

	public long getGradebookid() {
		return this.gradebookid;
	}

	public void setGradebookid(long gradebookid) {
		this.gradebookid = gradebookid;
	}

	public String getAssignment() {
		return this.assignment;
	}

	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}

	public String getAssignmenttype() {
		return this.assignmenttype;
	}

	public void setAssignmenttype(String assignmenttype) {
		this.assignmenttype = assignmenttype;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
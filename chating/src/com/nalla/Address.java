package com.nalla;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ADDRESS database table.
 * 
 */
@Entity
@Table(name="ADDRESS")
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ADDRESS_AID_GENERATOR", sequenceName="ADD_AID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ADDRESS_AID_GENERATOR")
	@Column(unique=true, nullable=false, precision=5)
	private long aid;

	@Column(length=15)
	private String address;

	@Column(length=10)
	private String aname;

	@Column(length=10)
	private String gender;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="ANO")
	private Employee employee;

	public Address() {
	}

	public long getAid() {
		return this.aid;
	}

	public void setAid(long aid) {
		this.aid = aid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAname() {
		return this.aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
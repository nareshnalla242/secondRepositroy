package com.nalla;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the EMPLOYEE database table.
 * 
 */
@Entity
@Table(name="EMPLOYEE")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EMPLOYEE_ENO_GENERATOR", sequenceName="EMP_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMPLOYEE_ENO_GENERATOR")
	@Column(unique=true, nullable=false, precision=5)
	private long eno;

	@Column(length=10)
	private String ename;

	@Column(precision=10, scale=3)
	private BigDecimal esalary;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="employee")
	private List<Address> addresses;

	public Employee() {
	}

	public long getEno() {
		return this.eno;
	}

	public void setEno(long eno) {
		this.eno = eno;
	}

	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public BigDecimal getEsalary() {
		return this.esalary;
	}

	public void setEsalary(BigDecimal esalary) {
		this.esalary = esalary;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setEmployee(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setEmployee(null);

		return address;
	}

}
package com.project.springbootATM.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userid;
	
	
	private String prefix;
	private String firstName;
	private String middleName;
	private String lastName;
	private String dob;
	private String maritalStatus;
	private String gender;
	@Column(name = "mobile",  unique = true)
	private String mobile;
	private Date date;
	@Column(name = "email", unique = true)
	private String email;
	@Column(name = "adhar",unique = true)
	private String adhar;
	@Column(name = "pan", unique = true)
	private String pan;
	private String address;
	private String city;
	private String state;
	private String country;
	private String countryCode;
	private String acctype;
	private String role;

	@OneToOne(cascade = CascadeType.REMOVE)
	@JsonIgnore
	private Account Account;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdhar() {
		return adhar;
	}

	public void setAdhar(String adhar) {
		this.adhar = adhar;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getAcctype() {
		return acctype;
	}

	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Account getAccount() {
		return Account;
	}

	public void setAccount(Account account) {
		Account = account;
	}

	public User(int userid, String prefix, String firstName, String middleName, String lastName, String dob,
			String maritalStatus, String gender, String mobile, Date date, String email, String adhar, String pan,
			String address, String city, String state, String country, String countryCode, String acctype, String role,
			com.project.springbootATM.model.Account account) {
		super();
		this.userid = userid;
		this.prefix = prefix;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dob = dob;
		this.maritalStatus = maritalStatus;
		this.gender = gender;
		this.mobile = mobile;
		this.date = date;
		this.email = email;
		this.adhar = adhar;
		this.pan = pan;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.countryCode = countryCode;
		this.acctype = acctype;
		this.role = role;
		Account = account;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}

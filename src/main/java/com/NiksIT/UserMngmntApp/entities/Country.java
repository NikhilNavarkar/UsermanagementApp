package com.NiksIT.UserMngmntApp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COUNTRY_MASTER")
public class Country {
	
	@Id
	@Column(name="COUNTRY_ID")
	private Integer countryId;
	@Column(name="COUNTRY_NAME")
	private String countryname;
	@Column(name="COUNTRY_CODE")
	private String countryCode;
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	public String getCountryname() {
		return countryname;
	}
	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}


}

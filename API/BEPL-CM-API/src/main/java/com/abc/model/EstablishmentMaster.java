package com.abc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Establishmentmaster")
public class EstablishmentMaster
{
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "code")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String code;

	@Column(name = "establishment")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String establishment;

	@Column(name = "building")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String building;

	@Column(name = "street")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String street;

	@Column(name = "city")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String city;

	@Column(name = "district")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String district;

	@Column(name = "state")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String state;

	@Column(name = "pin_code")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String pin_code;

	@Column(name = "country")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String country;

	@Column(name = "email_id")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String email_id;

	@Column(name = "website")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String website;
	
	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getEstablishment()
	{
		return establishment;
	}

	public void setEstablishment(String Establishment)
	{
		this.establishment = Establishment;
	}

	public String getBuilding()
	{
		return building;
	}

	public void setBuilding(String Building)
	{
		this.building = Building;
	}

	public String getStreet()
	{
		return street;
	}

	public void setStreet(String Street)
	{
		this.street = Street;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String City)
	{
		this.city = City;
	}

	public String getDistrict()
	{
		return district;
	}

	public void setDistrict(String District)
	{
		this.district = District;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String State)
	{
		this.state = State;
	}

	public String getPin_code()
	{
		return pin_code;
	}

	public void setPin_code(String Pin_code)
	{
		this.pin_code = Pin_code;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public String getEmail_ID()
	{
		return email_id;
	}

	public void setEmail_ID(String Email_Id)
	{
		this.email_id = Email_Id;
	}

}
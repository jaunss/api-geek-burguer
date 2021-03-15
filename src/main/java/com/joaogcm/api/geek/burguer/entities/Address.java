package com.joaogcm.api.geek.burguer.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_address")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAddress;
	private String publicPlaceAddress;
	private String numberAddress;
	private String complementAddress;
	private String districtAddress;
	private String zipCodeAddress;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	public Address() {

	}

	public Address(Long idAddress, String publicPlaceAddress, String numberAddress, String complementAddress,
			String districtAddress, String zipCodeAddress, City city, Client client) {
		this.idAddress = idAddress;
		this.publicPlaceAddress = publicPlaceAddress;
		this.numberAddress = numberAddress;
		this.complementAddress = complementAddress;
		this.districtAddress = districtAddress;
		this.zipCodeAddress = zipCodeAddress;
		this.city = city;
		this.client = client;
	}

	public Long getIdAddress() {
		return idAddress;
	}

	public void setIdAddress(Long idAddress) {
		this.idAddress = idAddress;
	}

	public String getPublicPlaceAddress() {
		return publicPlaceAddress;
	}

	public void setPublicPlaceAddress(String publicPlaceAddress) {
		this.publicPlaceAddress = publicPlaceAddress;
	}

	public String getNumberAddress() {
		return numberAddress;
	}

	public void setNumberAddress(String numberAddress) {
		this.numberAddress = numberAddress;
	}

	public String getComplementAddress() {
		return complementAddress;
	}

	public void setComplementAddress(String complementAddress) {
		this.complementAddress = complementAddress;
	}

	public String getDistrictAddress() {
		return districtAddress;
	}

	public void setDistrictAddress(String districtAddress) {
		this.districtAddress = districtAddress;
	}

	public String getZipCodeAddress() {
		return zipCodeAddress;
	}

	public void setZipCodeAddress(String zipCodeAddress) {
		this.zipCodeAddress = zipCodeAddress;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAddress == null) ? 0 : idAddress.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (idAddress == null) {
			if (other.idAddress != null)
				return false;
		} else if (!idAddress.equals(other.idAddress))
			return false;
		return true;
	}
}
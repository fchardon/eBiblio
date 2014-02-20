package com.test.projet.ebiblio.domain.livre;

import com.test.projet.ebiblio.domain.ValueObject;

public class Prix implements ValueObject {
	
	private Integer prix;

	public Prix(Integer prix) {
		super();
		this.prix = prix;
	}

	public Integer getPrix() {
		return prix;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((prix == null) ? 0 : prix.hashCode());
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
		Prix other = (Prix) obj;
		if (prix == null) {
			if (other.prix != null)
				return false;
		} else if (!prix.equals(other.prix))
			return false;
		return true;
	}
	
	
}

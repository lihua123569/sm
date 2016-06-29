package com.common.generic;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class GenericEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6625104538524576645L;

	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}

package com.hibernate.example;

import javax.persistence.Embeddable;

/**
 * Date: 10/29/2014 Time: 10:53 AM
 *
 * @author assanai.manurat
 */
@Embeddable
public class AccountPk {
	private String code;
	private Integer number;

	public AccountPk() {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public int hashCode() {
		int hashCode = 0;
		if (code != null)
			hashCode ^= code.hashCode();
		if (number != null)
			hashCode ^= number.hashCode();
		return hashCode;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof AccountPk))
			return false;
		AccountPk target = (AccountPk) obj;
		return ((this.code == null) ? (target.code == null) : this.code.equals(target.code))
				&& ((this.number == null) ? (target.number == null) : this.number.equals(target.number));
	}
}

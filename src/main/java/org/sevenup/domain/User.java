package org.sevenup.domain;

import javax.persistence.Entity;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
public class User extends BaseEntity {

//	@NotNull
//	@Size(min = 1, max = 25)
//	@Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
	private String name;

//	@NotEmpty
//	@Email
	private String email;

//	@NotNull
//	@Size(min = 9, max = 12)
//	@Digits(fraction = 0, integer = 12)
	private String phoneNumber;
	
	@Range(min = 1, max = 120)
	// @Digits(fraction = 0, integer = 10)
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}

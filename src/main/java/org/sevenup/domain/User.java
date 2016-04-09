package org.sevenup.domain;

import javax.persistence.Entity;
import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
public class User extends BaseEntity{

	@NotEmpty
	private String name;
	
	@Range(min = 1, max = 120) 
//    @Digits(fraction = 0, integer = 10)
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

}

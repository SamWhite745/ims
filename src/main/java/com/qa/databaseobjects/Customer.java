package com.qa.databaseobjects;

/**
 * @author Sam Implementation of the customer table to perform logic on.
 */
public class Customer {

	private int id;
	private String name;

	/**
	 * @param id
	 * @param name
	 */
	public Customer(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * @param name
	 */
	public Customer(String name) {
		this.name = name;
	}

	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id sets id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name sets name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return returns the customer to string
	 */
	@Override
	public String toString() {
		return (id + " " + name);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Customer other = (Customer) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}

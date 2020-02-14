package com.qa.databaseobjects;

/**
 * @author Sam Implementation of the item table to perform logic on.
 *
 */
public class Item {

	private int id;
	private String name;
	private int value;

	/**
	 * @param id
	 * @param name
	 * @param value
	 */
	public Item(int id, String name, int value) {
		this.id = id;
		this.name = name;
		this.value = value;
	}

	/**
	 * @param name
	 * @param value
	 */
	public Item(String name, int value) {
		this.name = name;
		this.value = value;
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
	 * @return value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value sets value
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	/**
	 * @return item to string format
	 */
	@Override
	public String toString() {
		return this.id + " " + this.name + " " + this.value;
	} 
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + value;
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
		Item other = (Item) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (value != other.value)
			return false;
		return true;
	}
}

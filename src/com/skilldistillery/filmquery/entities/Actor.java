package com.skilldistillery.filmquery.entities;

import java.util.List;

public class Actor {
	private int id;
	private String first_name;
	private String last_name;

	public Actor(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.first_name = firstName;
		this.last_name = lastName;
//		this.films = films;
	}

	public Actor() {
	}
//		@Override
//		public String toString() {
//			return "Actor [id=" + id + ", first Name=" + first_name + ", lastName=" + last_name + ", films=" + films + "]";
//		}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((films == null) ? 0 : films.hashCode());
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + id;
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
//		builder.append("Actor id: ");
//		builder.append(id);
//		builder.append("Actors: \n");
		builder.append(first_name);
		builder.append(" ");
//		builder.append(", Last name: ");
		builder.append(last_name);
//		builder.append(", films=");
//		builder.append(films);
//		builder.append("]");
		return builder.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		if (films == null) {
			if (other.films != null)
				return false;
		} else if (!films.equals(other.films))
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (id != other.id)
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	private List<Film> films;
}

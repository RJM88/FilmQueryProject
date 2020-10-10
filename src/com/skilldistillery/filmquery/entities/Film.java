package com.skilldistillery.filmquery.entities;

import java.util.List;

public class Film {

	private int id;
	private String title;
	private String description;
	private String release_year;
	private String language_id;
	private int rental_duration;
	private String rental_rate;
	private String length;
	private double replacement_cost;
	private String rating;
	private String special_features;
	private String name;
	private List<Actor> actors;


	public Film(int id, String title, String release_year, String rating, String description, String name) {
		this.id = id;
		this.title = title;
		this.release_year = release_year;
		this.rating = rating;
		this.description = description;
		this.name = name;
	}

	public Film(String title, String release_year, String rating, String description, String name, List<Actor> actors) {
		this.title = title;
		this.release_year = release_year;
		this.rating = rating;
		this.description = description;
		this.name = name;
		this.actors = actors;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public Film(int id, String title, String description, String release_year, String language_id,
//			int rental_duration, String rental_rate, String length, double replacement_cost, String rating,
//			String special_features, List<Actor> actors) {
//		super();
//		this.id = id;
//		this.title = title;
//		this.description = description;
//		this.release_year = release_year;
//		this.language_id = language_id;
//		this.rental_duration = rental_duration;
//		this.rental_rate = rental_rate;
//		this.length = length;
//		this.replacement_cost = replacement_cost;
//		this.rating = rating;
//		this.special_features = special_features;
//		this.actors = actors;
//	}

	public Film(String title, String release_year, String rating, String description) {
		this.title = title;
		this.release_year = release_year;
		this.rating = rating;
		this.description = description;
		

	}

	public Film(int id, String title, String release_year, String rating, String description, String name, List<Actor> actors) {
	}

	public Film() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRelease_year() {
		return release_year;
	}

	public void setRelease_year(String string) {
		this.release_year = string;
	}

	public String getLanguage_id() {
		return language_id;
	}

	public void setLanguage_id(String string) {
		this.language_id = string;
	}

	public int getRental_duration() {
		return rental_duration;
	}

	public void setRental_duration(int rental_duration) {
		this.rental_duration = rental_duration;
	}

	public String getRental_rate() {
		return rental_rate;
	}

	public void setRental_rate(String string) {
		this.rental_rate = string;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public double getReplacement_cost() {
		return replacement_cost;
	}

	public void setReplacement_cost(double replacement_cost) {
		this.replacement_cost = replacement_cost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecial_features() {
		return special_features;
	}

	public void setSpecial_features(String special_features) {
		this.special_features = special_features;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actors == null) ? 0 : actors.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((language_id == null) ? 0 : language_id.hashCode());
		result = prime * result + ((length == null) ? 0 : length.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((release_year == null) ? 0 : release_year.hashCode());
		result = prime * result + rental_duration;
		result = prime * result + ((rental_rate == null) ? 0 : rental_rate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(replacement_cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((special_features == null) ? 0 : special_features.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Film other = (Film) obj;
		if (actors == null) {
			if (other.actors != null)
				return false;
		} else if (!actors.equals(other.actors))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (language_id == null) {
			if (other.language_id != null)
				return false;
		} else if (!language_id.equals(other.language_id))
			return false;
		if (length == null) {
			if (other.length != null)
				return false;
		} else if (!length.equals(other.length))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (release_year == null) {
			if (other.release_year != null)
				return false;
		} else if (!release_year.equals(other.release_year))
			return false;
		if (rental_duration != other.rental_duration)
			return false;
		if (rental_rate == null) {
			if (other.rental_rate != null)
				return false;
		} else if (!rental_rate.equals(other.rental_rate))
			return false;
		if (Double.doubleToLongBits(replacement_cost) != Double.doubleToLongBits(other.replacement_cost))
			return false;
		if (special_features == null) {
			if (other.special_features != null)
				return false;
		} else if (!special_features.equals(other.special_features))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
//		builder.append("Film [id=");
//		builder.append(id);
		builder.append("Title: ");
		builder.append(title);
		builder.append("\n");
		builder.append("Release_year: ");
		builder.append(release_year);
		builder.append("\n");
		builder.append("Rating: ");
		builder.append(rating);
		builder.append("\n");
		builder.append("Description: ");
		builder.append(description);
		builder.append("\n");
		builder.append("Language: ");
		builder.append(name);
		builder.append("\n");
//		builder.append(", language_id=");
//		builder.append(language_id);
//		builder.append(", rental_duration=");
//		builder.append(rental_duration);
//		builder.append(", rental_rate=");
//		builder.append(rental_rate);
//		builder.append(", length=");
//		builder.append(length);
//		builder.append(", replacement_cost=");
//		builder.append(replacement_cost);
//		builder.append(", special_features=");
//		builder.append(special_features);
		builder.append("actors: \n");
		for (Actor actor : actors) {
			
			builder.append(actor + "\n");
			
		}
//		for (Film film : filmlist) {
//			builder.append(film + "\n");
//			System.out.println();
//		}
		return builder.toString();
	}

}

package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	private static final String user = "student";
	private static final String pass = "student";

	public DatabaseAccessorObject() { // no args constructor
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		}
	}

	@Override
	public Film findFilmById(int filmId) {
		Film film = null;
		try {
			// 1. set connection
			Connection conn = DriverManager.getConnection(URL, user, pass);
			// 2. SLQ query
			String sql = "SELECT * FROM film join language on film.language_id = language.id where film.id = ?";
			// 3. prepare statement.
			PreparedStatement stmt = conn.prepareStatement(sql);
			// 4. execute query
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			// 5. process data
			if (rs.next()) {
				film = new Film();
				film.setId(rs.getInt("id"));
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setRelease_year(rs.getString("release_year"));
				film.setLanguage_id(rs.getString("language_id"));
				film.setRating(rs.getString("rating"));
				film.setName(rs.getString("name"));
				film.setActors(findActorsByFilmId(filmId));
//			film.setRental_duration(rs.getInt("rental_rate"));
//			film.setRental_rate(rs.getString("length"));
//			film.setLength(rs.getString("length"));
//			film.setReplacement_cost(rs.getDouble("replacement_cost"));
//			film.setSpecial_features(rs.getString("special_features"));
//			findActorsByFilmId(filmId);
			}
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
		// 6. return result post processing
		return film;
	}

	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;
		try {
			// 1. set connection
			Connection conn = DriverManager.getConnection(URL, user, pass);
			// 2. SLQ query
			String sql = "SELECT * FROM actor WHERE actor.id = ?";
			// 3. prepare statement.
			PreparedStatement stmt = conn.prepareStatement(sql);
			// 4. execute query
			stmt.setInt(1, actorId);
			ResultSet rs = stmt.executeQuery();
			// 5. process data
			if (rs.next()) {
				actor = new Actor();
				actor.setId(rs.getInt("id"));
				actor.setFirst_name(rs.getString("first_name"));
				actor.setLast_name(rs.getString("last_name"));
			}
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		// 6. return result post processing
		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> crew = new ArrayList<>();
		try {
			// 1. set connection
			Connection conn = DriverManager.getConnection(URL, user, pass);
			// 2. SLQ query
			String sql = "SELECT * FROM actor JOIN film_actor ON actor.id = film_actor.actor_id JOIN "
					+ "film on film.id = film_actor.film_id WHERE film_actor.film_id = ?";
			// 3. prepare statement.
			PreparedStatement stmt = conn.prepareStatement(sql);
			// 4. execute query
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			// 5. process data
			while (rs.next()) {
				int id = rs.getInt("id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				Actor actor = new Actor(id, first_name, last_name);
				crew.add(actor);
			}

			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		// 6. return result post processing
		return crew;
	}

	@Override
	public List<Film> findFilmsByInput(String input) {
		List<Film> filmList = new ArrayList<>();
		try {
			// 1. set connection
			Connection conn = DriverManager.getConnection(URL, user, pass);
			// 2. SLQ query
			String sql = "select * from film join language on film.language_id = language.id where instr(film.title, ?) or instr(film.description, ?)";
//			String sql = "select * from film join language on film.language_id = language.id where title LIKE ? or description like ?";
			// 3. prepare statement.
			PreparedStatement stmt = conn.prepareStatement(sql);
			// 4. execute query
			stmt.setString(1, input);
			stmt.setString(2, input);
//			stmt.setString(1, "%" + input + "%");
//			stmt.setString(2, "%" + input + "%");
			// 4. execute query
			ResultSet rs = stmt.executeQuery();
			// 5. process data
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String release_year = rs.getString("release_year");
				String rating = rs.getString("rating");
				String description = rs.getString("description");
				String name = rs.getString("name");
				Film film = new Film(id, title, release_year, rating, description, name);
				film.setActors(findActorsByFilmId(id));
				filmList.add(film);
			}

		
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 6. return result post processing
		return filmList;
	}

}
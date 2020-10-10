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

	public DatabaseAccessorObject() { // no args constructor
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Film findFilmById(int filmId) throws SQLException {
		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(URL, user, pass);
		Film film = new Film();

		String sql = "SELECT * FROM film join language on film.language_id = language.id where film.id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			film.setId(rs.getInt("id"));
			film.setTitle(rs.getString("title"));
			film.setDescription(rs.getString("description"));
			film.setRelease_year(rs.getString("release_year"));
			film.setLanguage_id(rs.getString("language_id"));
			film.setRental_duration(rs.getInt("rental_rate"));
			film.setRental_rate(rs.getString("length"));
			film.setLength(rs.getString("length"));
			film.setReplacement_cost(rs.getDouble("replacement_cost"));
			film.setRating(rs.getString("rating"));
			film.setSpecial_features(rs.getString("special_features"));
			film.setName(rs.getString("name"));
//			film.setFilms(findFilmById(filmId)); // An Actor has Films
		}

		stmt.close();
		conn.close();
		return film;
	}

	@Override
	public Actor findActorById(int actorId) throws SQLException {
		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(URL, user, pass);
		Actor actor = null;

		String sql = "SELECT * FROM actor WHERE actor.id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, actorId);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			actor = new Actor(); // Create the object
			// Here is our mapping of query columns to our object fields:

			actor.setId(rs.getInt("id"));
			actor.setFirst_name(rs.getString("first_name"));
			actor.setLast_name(rs.getString("last_name"));

//			film.setFilms(findFilmById(filmId)); // An Actor has Films
		}
		stmt.close();
		conn.close();
		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) throws SQLException {
		List<Actor> crew = new ArrayList<>();
		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(URL, user, pass);

		String sql = "SELECT * FROM actor JOIN film_actor ON actor.id = film_actor.actor_id JOIN "
				+ "film on film.id = film_actor.film_id WHERE film_actor.film_id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			String first_name = rs.getString("first_name");
			String last_name = rs.getString("last_name");
			Actor actor = new Actor(id, first_name, last_name); // Create the object
			crew.add(actor);
		}
		for (Actor actor : crew) {
			System.out.println(actor);
		}
		stmt.close();
		conn.close();
		return crew;
	}

	@Override
	public List<Film> findFilmsByInput(String input) throws SQLException {
		List<Film> filmList = new ArrayList<>();
		String user = "student";
		String pass = "student";
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "select * from film join language on film.language_id = language.id where instr(film.title, ?) or instr(film.description, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, input);
			stmt.setString(2, input);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String release_year = rs.getString("release_year");
				String rating = rs.getString("rating");
				String description = rs.getString("description");
				String name = rs.getString("name");
				
				Film film = new Film(id, title, release_year, rating, description, name);
				filmList.add(film);
			}
			for (Film film : filmList) {
				System.out.println(film);
				System.out.println();

			}
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filmList;
	}

}
//connection/driver/string/iterator all done in here
package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";

	public DatabaseAccessorObject() throws ClassNotFoundException { // no args constructor
		Class.forName("com.mysql.jdbc.Driver");
	}

	@Override
	public Film findFilmById(int filmId) throws SQLException {
		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(URL, user, pass);
		Film film = null;
		
		String sql = "SELECT * FROM film WHERE film.id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			film = new Film(); // Create the object
			// Here is our mapping of query columns to our object fields:
			film.setId(rs.getInt("id"));
			film.setTitle(rs.getString("title"));
			film.setDescription(rs.getString("description"));
			film.setRelease_year(rs.getString("release_year"));
			film.setLanguage_id(rs.getString("language_id"));
			film.setRental_duration(rs.getString(3));
			film.setLastName(rs.getString(3));
			film.setLastName(rs.getString(3));
			film.setFilms(findFilmById(filmId)); // An Actor has Films
		}

//		+ rs.getInt("rental_duration")
//			+ " " + rs.getString("rental_rate") + " " 
//		+ rs.getString("length") + " " + rs.getDouble("replacement_cost")
//			+ " " + rs.getString("rating") + " " 
//		+ rs.getString("special_features"));
//		}
		stmt.close();
		conn.close();
		return film;
	}
//		// ...
//		return actor;
//	}

	@Override
	public Actor findActorById(int actorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Actor findActorById(int actorId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Actor> findActorsByFilmId(int filmId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
//connection/driver/string/iterator all done in here
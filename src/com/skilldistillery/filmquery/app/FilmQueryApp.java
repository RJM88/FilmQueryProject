package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
//		app.test();
		app.launch();
	}

	public FilmQueryApp() {
		super();
	}

//	private void test() throws SQLException {
//		List<Actor> crew = db.findActorsByFilmId(1);
//		for (Actor actor : crew) {
//
//			System.out.println(actor);
//		}
//	}

	private void launch() throws SQLException {
		Scanner input = new Scanner(System.in);
		startUserInterface(input);
		input.close();
	}

	private void startUserInterface(Scanner input) throws SQLException {
		Scanner kb = new Scanner(System.in);
		boolean quit = false;
		while (!quit) {

			System.out.println("1.) Look up a film by its id.");
			System.out.println("2.) Look up a film by a keyword.");
			System.out.println("3.) Exit the application.");
			System.out.println();
			System.out.println("Please choose an option");
			String userChoice = kb.next();

			switch (userChoice) {

			case "1":
				System.out.print("Please choose a Film ID: ");
				int filmIdChoice = kb.nextInt();
				System.out.println();
				if (db.findFilmById(filmIdChoice) == null) {
					System.out.println("Film cannot be found.");
				} else {
					System.out.println(db.findFilmById(filmIdChoice));
					System.out.println();

				}
				System.out.println();
				break;

			case "2":
				System.out.println();
				System.out.print("Search for: ");
				System.out.println();
				String filmSearch = kb.next();
				if (db.findFilmsByInput(filmSearch).size() == 0) {
					System.out.println("No films found.");
				} else {
					List<Film> films = db.findFilmsByInput(filmSearch);
					for (Film film : films) {
						System.out.println(film);
					}
				}
				break;

			case "3":
				System.out.println("Thank you, and goodbye.");
				quit = true;
				break;

			default:
				System.out.println("Not an option, please select again.\n");
			}
		}
		kb.close();

	}

}

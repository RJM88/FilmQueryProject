# Film Query Application ( WEEK 7 )

## Overview
This is a command-line application that retrieves and displays film data from MySQL. It is menu-based, allowing the user to choose actions and submit query data. All JDBC code is encapsulated in methods of the DAO class. 

## Topics
* Arrays Lists
* Classes
* If statements
* Interface
* Inheritance 
* JDBC
* Maven
* Methods
* MySQL
* Objects
* Object-Relational Mapping (ORM)
* Switches
* While loops

### Lessons Learned
* Connecting to a database
* Issuing queries and commands. 
* Handling result sets obtained from the database
* Using data retrieved from a SQL database to construct Java objects

### How to Run
1.-Program will start by asking user to choose one of three options from, the menu. Film by ID, search for a film by keyword, and Quit.

2.-If the user looks up a film by id, they are prompted to enter the film id. If the film is not found, they see a message saying so. If the film is found the film information will be displayed along with all actors in the film.

3.-If "Search for a film by keyword" is chosen, he user will be prompted to enter in a word. This word will then be used to search every movies title and description returning any matches. Then all the matching movies along with a list of actors in the film will be displayed.


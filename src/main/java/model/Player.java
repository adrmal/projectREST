package model;

import usable.Country;
import usable.Date;
import usable.Position;

public class Player {

	private String id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Country nationality;
    private int height;
    private int weight;
    private Position position;
    private String club;
    private int squadNumber;
    
    public Player() {
    }
    
    public Player(String id, String firstName, String lastName, Date dateOfBirth, Country nationality, int height, int weight, Position position) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.height = height;
        this.weight = weight;
        this.position = position;
    }
    
    public Player(String id, String firstName, String lastName, Date dateOfBirth, Country nationality, int height, int weight, Position position, String club, int squadNumber) {
        this(id, firstName, lastName, dateOfBirth, nationality, height, weight, position);
        this.club = club;
        this.squadNumber = squadNumber;
    }
	
    public String getId() {
		return id;
	}
    
    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Country getNationality() {
		return nationality;
	}

	public void setNationality(Country nationality) {
		this.nationality = nationality;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public int getSquadNumber() {
		return squadNumber;
	}

	public void setSquadNumber(int squadNumber) {
		this.squadNumber = squadNumber;
	}
    
}

package model;

import usable.Country;
import usable.Date;

public class Coach {

    private String id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Country nationality;
    private Club club;
    
    public Coach() {
    }
    
	public Coach(String id, String firstName, String lastName, Date dateOfBirth, Country nationality) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.nationality = nationality;
	}
    
	public Coach(String id, String firstName, String lastName, Date dateOfBirth, Country nationality, Club club) {
		this(id, firstName, lastName, dateOfBirth, nationality);
		this.club = club;
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

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}
	
}

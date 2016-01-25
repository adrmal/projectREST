package model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import usable.Country;
import usable.Date;
import usable.Position;

@ApiModel(value = "football player")
public class Player {

	@NotBlank
	private String id;
	@NotBlank
    private String firstName;
	@NotBlank
    private String lastName;
	@NotNull
    private Date dateOfBirth;
	@NotNull
    private Country nationality;
	@NotNull
    private int height;
	@NotNull
    private int weight;
	@NotNull
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
	
    @ApiModelProperty(value = "ID of player", required = true)
    public String getId() {
		return id;
	}
    
    @ApiModelProperty(value = "first name of player", required = true)
    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@ApiModelProperty(value = "last name of player", required = true)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@ApiModelProperty(value = "date of birth of player", required = true)
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@ApiModelProperty(value = "nationality of player", required = true)
	public Country getNationality() {
		return nationality;
	}

	public void setNationality(Country nationality) {
		this.nationality = nationality;
	}

	@ApiModelProperty(value = "height in cm of player", required = true)
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@ApiModelProperty(value = "weight in kg of player", required = true)
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@ApiModelProperty(value = "pitch position of player", required = true)
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	@ApiModelProperty(value = "club in which is player", required = false)
	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	@ApiModelProperty(value = "squad number of player", required = false)
	public int getSquadNumber() {
		return squadNumber;
	}

	public void setSquadNumber(int squadNumber) {
		this.squadNumber = squadNumber;
	}
    
}

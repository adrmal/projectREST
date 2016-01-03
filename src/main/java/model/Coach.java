package model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import usable.Country;
import usable.Date;

@ApiModel(value = "coach of the team")
public class Coach {

    private String id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Country nationality;
    
    public Coach() {
    }
    
	public Coach(String id, String firstName, String lastName, Date dateOfBirth, Country nationality) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.nationality = nationality;
	}
	
	@ApiModelProperty(value = "ID of coach", required = true)
	public String getId() {
		return id;
	}
	
	@ApiModelProperty(value = "first name of coach", required = true)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@ApiModelProperty(value = "last name of coach", required = true)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@ApiModelProperty(value = "date of birth of coach", required = true)
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@ApiModelProperty(value = "nationality of coach", required = true)
	public Country getNationality() {
		return nationality;
	}

	public void setNationality(Country nationality) {
		this.nationality = nationality;
	}
	
}

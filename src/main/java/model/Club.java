package model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "football club")
public class Club {

    @NotBlank
	private String id;
    @NotBlank
    private String name;
    @NotBlank
    private String city;
    @NotNull
    private int foundingYear;
    private String coach;
    
    public Club() {
    }
    
    public Club(String id, String name, String city, int foundingYear) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.foundingYear = foundingYear;
	}

    public Club(String id, String name, String city, int foundingYear, String coach) {
        this(id, name, city, foundingYear);
        this.coach = coach;
    }
    
    @ApiModelProperty(value = "ID of club", required = true)
    public String getId() {
		return id;
	}
    
    @ApiModelProperty(value = "name of club", required = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ApiModelProperty(value = "city in which is club", required = true)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@ApiModelProperty(value = "year of founding club", required = true)
	public int getFoundingYear() {
		return foundingYear;
	}

	public void setFoundingYear(int foundingYear) {
		this.foundingYear = foundingYear;
	}
    
	@ApiModelProperty(value = "coach of club", required = false)
	public String getCoach() {
	    return coach;
	}
	
	public void setCoach(String coach) {
	    this.coach = coach;
	}
	
}

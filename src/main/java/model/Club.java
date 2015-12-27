package model;

public class Club {

	private String id;
    private String name;
    private String city;
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
    
    public String getId() {
		return id;
	}
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getFoundingYear() {
		return foundingYear;
	}

	public void setFoundingYear(int foundingYear) {
		this.foundingYear = foundingYear;
	}
    
	public String getCoach() {
	    return coach;
	}
	
	public void setCoach(String coach) {
	    this.coach = coach;
	}
	
}

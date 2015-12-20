package model;

public class Club {

	private String id;
    private String name;
    private String city;
    private int foundingYear;
    
    public Club() {
    }
    
    public Club(String id, String name, String city, int foundingYear) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.foundingYear = foundingYear;
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
    
}

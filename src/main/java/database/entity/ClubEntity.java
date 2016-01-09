package database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "clubs")
@NamedQueries({
    @NamedQuery(name = "clubs.findAll", query = "SELECT u FROM ClubEntity u")
})
public class ClubEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "city")
    private String city;
    @Column(name = "foundingYear")
    private int foundingYear;
    @Column(name = "coach")
    private String coach;
    private boolean active = false;
    
    public ClubEntity() {
    }
    
    public ClubEntity(String name, String city, int foundingYear, boolean active) {
        this.name = name;
        this.city = city;
        this.foundingYear = foundingYear;
        this.active = active;
    }

    public ClubEntity(String name, String city, int foundingYear, boolean active, String coach) {
        this(name, city, foundingYear, active);
        this.coach = coach;
    }
    
    public Long getId() {
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
    
    public boolean isActive() {
        return active;
    }
    
    public void setActive(boolean active) {
        this.active = active;
    }
    
}

package database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import usable.Country;
import usable.Date;

@Entity
@Table(name = "coaches")
@NamedQueries({
    @NamedQuery(name = "coaches.findAll", query = "SELECT u FROM CoachEntity u")
})
public class CoachEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "dateOfBirth")
    private Date dateOfBirth;
    @Column(name = "nationality")
    private Country nationality;
    private boolean active = false;
    
    public CoachEntity() {
    }
    
    public CoachEntity(String firstName, String lastName, Date dateOfBirth, Country nationality, boolean active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.active = active;
    }
    
    public Long getId() {
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
    
    public boolean isActive() {
        return active;
    }
    
    public void setActive(boolean active) {
        this.active = active;
    }
    
}

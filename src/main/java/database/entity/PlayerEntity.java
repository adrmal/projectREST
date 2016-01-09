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
import usable.Position;

@Entity
@Table(name = "players")
@NamedQueries({
    @NamedQuery(name = "players.findAll", query = "SELECT u FROM PlayerEntity u")
})
public class PlayerEntity {

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
    @Column(name = "height")
    private int height;
    @Column(name = "weight")
    private int weight;
    @Column(name = "position")
    private Position position;
    @Column(name = "club")
    private String club;
    @Column(name = "squadNumber")
    private int squadNumber;
    private boolean active = false;
    
    public PlayerEntity() {
    }
    
    public PlayerEntity(String firstName, String lastName, Date dateOfBirth, Country nationality, int height, int weight, Position position, boolean active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.height = height;
        this.weight = weight;
        this.position = position;
        this.active = active;
    }
    
    public PlayerEntity(String firstName, String lastName, Date dateOfBirth, Country nationality, int height, int weight, Position position, boolean active, String club, int squadNumber) {
        this(firstName, lastName, dateOfBirth, nationality, height, weight, position, active);
        this.club = club;
        this.squadNumber = squadNumber;
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
    
    public boolean isActive() {
        return active;
    }
    
    public void setActive(boolean active) {
        this.active = active;
    }
    
}

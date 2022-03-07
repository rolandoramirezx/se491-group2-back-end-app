package edu.depaul.springbootweatherpoc.weather.entity;

import javax.persistence.*;

@Entity
@Table(name="USER_LOCATION")
public class UserLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "username")
    private User user;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "zipcode")
    private Location location;

    public UserLocation (){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "UserLocation{" +
                "id=" + id +
                ", user=" + user +
                ", location=" + location +
                '}';
    }
}

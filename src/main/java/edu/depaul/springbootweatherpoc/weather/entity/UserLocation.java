package edu.depaul.springbootweatherpoc.weather.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="USER_LOCATION")
public class UserLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(targetEntity = edu.depaul.springbootweatherpoc.weather.entity.User.class)
    @JoinColumn(name = "username")
    private User user;

    @ManyToOne(targetEntity = edu.depaul.springbootweatherpoc.weather.entity.Location.class)
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

    public void setUsers(User user) {
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

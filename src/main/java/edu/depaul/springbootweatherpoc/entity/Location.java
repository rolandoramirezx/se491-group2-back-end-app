package edu.depaul.springbootweatherpoc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="LOCATIONS")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="location_id")
    private Long locationId;

    @Column(name="zip_code")
    private String zipCode;

    @Column(name="city_name")
    private String cityName;

    @Column(name="latitude")
    private double latitude;

    @Column(name="longitude")
    private double longitude;

    @Column(name="date_created")
    private Instant dateCreated;

    @Column(name="user_name")
    private String userName;

    @ManyToOne
    @JoinColumn(name="user_name", nullable=false, insertable = false, updatable = false)
    @JsonIgnore
    private User user;

    @Override
    public String toString() {
        return "Location{" +
                "zipCode='" + zipCode + '\'' +
                ", cityName='" + cityName + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}

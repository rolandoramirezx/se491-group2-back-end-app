package edu.depaul.springbootweatherpoc.weather.entity;

import javax.persistence.*;

@Entity
@Table(name="FEEDBACK")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="userid")
    private String userId;

    @ManyToOne(targetEntity = edu.depaul.springbootweatherpoc.weather.entity.User.class)
    @JoinColumn(name = "username")
    private User user;

    @Column(name="rating")
    private int rating;

    @Column(name="comments")
    private String comments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", user=" + user +
                ", rating=" + rating +
                ", comments='" + comments + '\'' +
                '}';
    }
}

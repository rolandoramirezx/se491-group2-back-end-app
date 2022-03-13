package edu.depaul.springbootweatherpoc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="FEEDBACK")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private int feedbackId;


    @Column(name="user_name")
    private String userName;

    @ManyToOne
    @JoinColumn(name="user_name", nullable=false, insertable = false, updatable = false)
    @JsonIgnore
    private User user;

    @Column(name="rating")
    private int rating;

    @Column(name="comments")
    private String comments;

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + feedbackId +
                ", user=" + user +
                ", rating=" + rating +
                ", comments='" + comments + '\'' +
                '}';
    }
}

package edu.depaul.springbootweatherpoc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Accessors
@Table(name = "LOGIN")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login_id")
    private Long loginId;

    @Column(name = "user_name")
    private String userName;

    @Override
    public String toString() {
        return "Login{" +
                "id=" + loginId +
                ", user=" + userName +
                '}';
    }
}

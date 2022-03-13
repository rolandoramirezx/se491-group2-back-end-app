package edu.depaul.springbootweatherpoc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Table(name = "LOGIN")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login_id")
    private Long loginId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "pass_hash")
    private String passHash;

    @Override
    public String toString() {
        return "Login{" +
                "id=" + loginId +
                ", user=" + userName +
                '}';
    }
}

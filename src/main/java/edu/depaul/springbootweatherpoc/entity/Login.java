package edu.depaul.springbootweatherpoc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LOGIN")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login_id")
    private Long loginId;

    @Column(name = "user_name")
    private String userName;

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_name")
//    private User user;

    @Override
    public String toString() {
        return "Login{" +
                "id=" + loginId +
                ", user=" + userName +
                '}';
    }
}

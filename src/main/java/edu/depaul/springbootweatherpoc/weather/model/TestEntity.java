package edu.depaul.springbootweatherpoc.weather.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="TEST")
public class TestEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private boolean field1;
}


package com.ikh.demo.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="users")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;
    @Column(name="lastname")
    private String lastName;

}

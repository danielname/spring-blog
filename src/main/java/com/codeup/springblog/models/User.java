package com.codeup.springblog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true, length = 100)
    private String username;
    @Column(nullable = false, unique = true, length = 100)
    private String email;
    @Column(nullable = false, length = 100)
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;
}

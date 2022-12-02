package com.codeup.springblog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    public User(long id, String username, String email, String password, List<Post> posts) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.posts = posts;
    }
    public User(long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String email, String password, List<Post> posts) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.posts = posts;
    }

    public User(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

    @Column(nullable = false, unique = true, length = 100)
    private String username;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

    @Column(nullable = false, unique = true, length = 100)
    private String email;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

    @Column(nullable = false, length = 100)
    private String password;

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;

        public List<Post> getPosts() {
            return posts;
        }

        public void setPosts(List<Post> posts) {
            this.posts = posts;
        }
}
